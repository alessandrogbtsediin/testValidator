package it.sediin.testValidator.Controller;


import it.sediin.testValidator.Entities.UploadFiles;
import it.sediin.testValidator.Entities.User;
import it.sediin.testValidator.Service.UploadFilesService;
import it.sediin.testValidator.Validator.ConditionalUploadFiles;
import it.sediin.testValidator.Validator.ConditionalUploadMultipleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

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


    @PostMapping("/uploadFC")
    public ResponseEntity<String> uploadFiles(@RequestParam("documents") @Valid @ConditionalUploadFiles MultipartFile documents) throws Exception {

        try {
            fileUploadService.store(documents);
            return ResponseEntity.ok("Files uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }

    @PostMapping("/uploadFCMulti")
    public ResponseEntity<String> uploadFilesMulti(@RequestParam("documents") @Valid @ConditionalUploadMultipleFiles MultipartFile[] documents) throws Exception {

        try {

            fileUploadService.storeMultipleFiles(documents);

            return ResponseEntity.ok("Files uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }







}


//    @PostMapping("/uploadFC")
//    public ResponseEntity<String> uploadFiles(@RequestParam("documents") MultipartFile[] files, UploadFiles uploadFiles) {
//        try {
//            fileUploadService.store(uploadFiles.setDocuments2(files));
//            return ResponseEntity.ok("Files uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
//        }
//    }


//funziona
//    @PostMapping("/uploadFC")
//    public ResponseEntity<String> uploadFiles(@RequestParam("documents") MultipartFile[] files) {
//        try {
//            fileUploadService.store(files);
//            return ResponseEntity.ok("Files uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
//        }
//    }






