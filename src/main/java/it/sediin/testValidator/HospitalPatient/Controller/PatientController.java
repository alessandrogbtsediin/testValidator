package it.sediin.testValidator.HospitalPatient.Controller;

import it.sediin.testValidator.HospitalPatient.Entites.Patient;
import it.sediin.testValidator.UserValidation_1.Entities.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {




    @PostMapping("/patient")
    public Map<String, String> patientDischarge(@Valid @RequestBody Patient patient, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return errors;
        }

        return Map.of("message", "User processed successfully");
    }









}
