package it.sediin.testValidator.HospitalPatient.Validator;


import it.sediin.testValidator.UserValidation_1.Validator.ConditionalPackageValidatorForClass;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy = ConditionalHospitalPatientValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionalHospitalPatient {

    String message() default  "default error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
