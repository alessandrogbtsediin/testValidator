package it.sediin.testValidator.UserValidation_1.Validator;

import it.sediin.testValidator.UserValidation_1.Entities.User;
import it.sediin.testValidator.UserValidation_1.Validator.ConditionalPackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*



questo overrida @valid x la classe User,
setto il template di errore in .buildconstrainttemplate
setto a quale proprieta deve essere bindato l'errore con .addpropertynode("address" e controlla dentro la classse il valore address


context.disableDefaultConstraintViolation(); = disabilito il text di default x mandare il mio custom
context.buildConstraintViolationWithTemplate.. = buildo il mio custom text come definito nell'interface
.addPropertyNode("address") = specifica su quale proprietà la violation è impostata
.addConstraintViolation(); = finalizza la costruzione della violation
return false = indica che la validation failed

 */





public class ConditionalPackageValidatorForClass implements ConstraintValidator<ConditionalPackage, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {

        if (user == null) {
            return false;
        }

        boolean isValid = true;
        if (user.getHasBought()) {
            if (user.getAddress() == null || user.getAddress().isEmpty()) {
                context.buildConstraintViolationWithTemplate("If you buy something you have to provide an address")
                        .addPropertyNode("address")
                        .addConstraintViolation();
                isValid = false;
            }

            if (user.getCreditCard() == null || user.getCreditCard().isEmpty()) {
                context.buildConstraintViolationWithTemplate("If you buy something you have to provide a credit card")
                        .addPropertyNode("creditCard")
                        .addConstraintViolation();
                isValid = false;
            }
//
//            if (!isValid) {
//                context.disableDefaultConstraintViolation();
//            }
        }

        return isValid;
    }












}