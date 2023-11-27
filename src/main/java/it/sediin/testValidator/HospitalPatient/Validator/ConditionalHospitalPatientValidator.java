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
            return false;
        }

        boolean result = true;

        Date admissionDate = patient.getAdmissionDate();
        Date dischargeDate = patient.getDischargeDate();

        String password = patient.getPassword();
        String passwordMatch = patient.getPasswordMatch();

        //returns true if dischargeDate is after admissionDate
        boolean isValid = (
                admissionDate != null
                && dischargeDate != null)
                && dischargeDate.after(admissionDate);

        boolean doPasswordMatch = (
                password != null
                && passwordMatch != null)
                && passwordMatch.equals(password);


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Discharge date must happen after the admission date.")
                    .addPropertyNode("dischargeDate")
                    .addConstraintViolation();
            result = false;
        }

        if (!doPasswordMatch) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords must match")
                    .addPropertyNode("passwordMatch")
                    .addConstraintViolation();
            result = false;
        }



        return result;
    }





}
