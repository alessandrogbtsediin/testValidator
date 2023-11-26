package it.sediin.testValidator.HospitalPatient.Entites;

import it.sediin.testValidator.HospitalPatient.Validator.ConditionalHospitalPatient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@ConditionalHospitalPatient
public class Patient {


    private Date admissionDate;

    private Date dischargeDate;


    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}