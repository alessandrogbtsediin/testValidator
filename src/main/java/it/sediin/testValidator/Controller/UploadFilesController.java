package it.sediin.testValidator.Controller;


import it.sediin.testValidator.Entities.MultiPartFileDTO;
import it.sediin.testValidator.Entities.UploadFiles;
import it.sediin.testValidator.Entities.User;
import it.sediin.testValidator.Service.UploadFilesService;
import it.sediin.testValidator.Validator.ConditionalUploadFiles;
import it.sediin.testValidator.Validator.ConditionalUploadMultipleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class UploadFilesController {

    @Autowired
    UploadFilesService fileUploadService;


    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("text/xml")
                || contentType.equals("application/pdf")
                || contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }


//    @PostMapping("/uploadFC")
//    public ResponseEntity<Map<String, String>> uploadFiles(@Valid @ConditionalUploadFiles @RequestPart("documents") MultipartFile documents, BindingResult result) {
//        Map<String, String> response = new HashMap<>();
//
//        if (result.hasErrors()) {
//            for (FieldError error : result.getFieldErrors()) {
//                response.put(error.getField(), error.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        try {
//            fileUploadService.store(documents);
//            response.put("success", "File "+documents.getOriginalFilename()+" uploaded successfully");
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            response.put("error", "Failed to upload file "+documents.getOriginalFilename()+": " + e.getMessage());
//            return ResponseEntity.status(500).body(response);
//        }
//    }

        @PostMapping("/uploadFC")
    public ResponseEntity<String> uploadFiles(@RequestPart("documents") @Valid @ConditionalUploadFiles MultipartFile documents, BindingResult bindingResult) throws Exception {

        try {
            fileUploadService.store(documents);
            return ResponseEntity.ok("Files uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }


    @PostMapping("/uploadFCmodel")
    public ResponseEntity<String> processUploadWithModelAttribute(@ModelAttribute("multiPartFileDTO") MultiPartFileDTO multiPartFileDTO, BindingResult result) throws IOException {
        try {
            fileUploadService.store(multiPartFileDTO.getFile());
            return ResponseEntity.ok("Files uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }






    @PostMapping("/uploadFCMulti")
    public ResponseEntity<Map<String, String>> uploadFilesMulti(@Valid @ConditionalUploadMultipleFiles @RequestParam("documents") MultipartFile[] documents, BindingResult result) {
        Map<String, String> response = new HashMap<>();

        // Checking for validation errors
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                response.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        try {
            fileUploadService.storeMultipleFiles(documents);
            response.put("success", "Files uploaded successfully");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Handling general exceptions without stack trace
            response.put("error", "Failed to upload files: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }



}


//working
//    @PostMapping("/uploadFC")
//    public ResponseEntity<String> uploadFiles(@RequestParam("documents") @Valid @ConditionalUploadFiles MultipartFile documents) throws Exception {
//
//        try {
//            fileUploadService.store(documents);
//            return ResponseEntity.ok("Files uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
//        }
//    }


//    @PostMapping("/uploadFCMulti")
//    public ResponseEntity<String> uploadFilesMulti(@RequestParam("documents") @Valid @ConditionalUploadMultipleFiles MultipartFile[] documents) throws Exception {
//
//        try {
//            fileUploadService.storeMultipleFiles(documents);
//            return ResponseEntity.ok("Files uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
//        }
//    }
//
















