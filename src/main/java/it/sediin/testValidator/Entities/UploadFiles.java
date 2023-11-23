package it.sediin.testValidator.Entities;

import it.sediin.testValidator.Validator.ConditionalUploadFiles;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@ConditionalUploadFiles
public class UploadFiles {

    private MultipartFile[] documents;

    public MultipartFile[] getDocuments() {
        return documents;
    }

    public void setDocuments(MultipartFile[] documents) {
        this.documents = documents;
    }
    public MultipartFile[] setDocuments2(MultipartFile[] documents) {
        this.documents = documents;
        return documents;
    }

}
