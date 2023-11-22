//package it.sediin.testValidator.Validator;
//
//import it.sediin.testValidator.Entities.User;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//public class UserValidator implements Validator {
//
////    @Override
////    public boolean supports(Class<?> clazz) {
////        return User.class.equals(clazz);
////    }
////
////    @Override
////    public void validate(Object obj, Errors errors) {
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
////        User user = (User) obj;
////        // Custom validation logic
////        if (user.getEmail() != null && !user.getEmail().contains("@")) {
////            errors.rejectValue("email", "email.notValid");
////        }
////    }
//}
