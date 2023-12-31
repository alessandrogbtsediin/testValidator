package it.sediin.testValidator.Controller;
import it.sediin.testValidator.Entities.User;
import it.sediin.testValidator.Validator.ConditionalUploadFiles;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
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
