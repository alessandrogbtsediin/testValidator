package it.sediin.testValidator.Validator;

import it.sediin.testValidator.Entities.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*



se HasBought true E getAddress è null or empty


context.disableDefaultConstraintViolation(); = disabilito il text di default x mandare il mio custom
context.buildConstraintViolationWithTemplate.. = buildo il mio custom text come definito nell'interface
.addPropertyNode("address") = specifica su quale proprietà la violation è impostata
.addConstraintViolation(); = finalizza la costruzione della violation
return false = indica che la validation failed

 */





public class ConditionalPackageValidatorForClass implements ConstraintValidator<ConditionalPackage, User> {



    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user.getHasBought() && (user.getAddress() == null || user.getAddress().isEmpty())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("address")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }










}