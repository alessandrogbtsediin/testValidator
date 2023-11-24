package it.sediin.testValidator.HospitalPatient.Validator;


import javax.validation.Payload;









public @interface ConditionalHospitalPatient {

    String message() default  "default error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
