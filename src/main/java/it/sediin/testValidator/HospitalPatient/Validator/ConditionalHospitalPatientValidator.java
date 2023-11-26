package it.sediin.testValidator.HospitalPatient.Validator;

import it.sediin.testValidator.HospitalPatient.Entites.Patient;
import it.sediin.testValidator.UserValidation_1.Validator.ConditionalPackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class ConditionalHospitalPatientValidator implements ConstraintValidator<ConditionalHospitalPatient, Patient> {
    @Override
    public boolean isValid(Patient patient, ConstraintValidatorContext context) {
        if (patient == null) {
            return true;
        }

        Date admissionDate = patient.getAdmissionDate();
        Date dischargeDate = patient.getDischargeDate();

        boolean isValid = (
                admissionDate != null
                && dischargeDate != null)
                && dischargeDate.after(admissionDate);  //It returns a boolean (true if the Date is after the specified date, false otherwise).

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Discharge date must happen after the admission date.")
                    .addPropertyNode("dischargeDate")
                    .addConstraintViolation();
        }

        return isValid;
    }





}
