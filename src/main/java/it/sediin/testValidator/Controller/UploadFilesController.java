package it.sediin.testValidator.Controller;


import it.sediin.testValidator.Entities.UploadFiles;
import it.sediin.testValidator.Entities.User;
import it.sediin.testValidator.Service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFilesController {

    @Autowired
    private UploadFilesService uploadFiles;

    @Autowired
    UploadFilesService fileUploadService;




    @PostMapping("/uploadFC")
    public ResponseEntity<String> uploadFiles(@RequestParam("documents") MultipartFile[] files, UploadFiles uploadFiles) {
        try {
            fileUploadService.store(uploadFiles.setDocuments2(files));
            return ResponseEntity.ok("Files uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }


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





}
