package it.sediin.testValidator.Controller;

import it.sediin.testValidator.Entities.User;
import it.sediin.testValidator.Validator.ConditionalPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    /*
BindingResult result) = quando metti valid ad 1 elemento bindingresult cattura gli errori, serve x fare 1 lista di errori
                        esso contiene 1 lista di FieldError, metto poi il field e message in una Map e la ritorno


     */

//    @Autowired
//    public Validator validator;
//
//    @PostMapping("/users")
//    public Map<String, String> addUser(@RequestBody User user, BindingResult result) {
//
//        validator.validate(user, result);
//
//        Map<String, String> errors = new HashMap<>();
//
//
//        if (result.hasErrors()) {
//            for (FieldError error : result.getFieldErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return errors;
//        }
//        return Map.of("message", "User processed successfully");
//        }
//    }


    @PostMapping("/users")
    public Map<String, String> addUser(@Valid @RequestBody User user, BindingResult result) {
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
