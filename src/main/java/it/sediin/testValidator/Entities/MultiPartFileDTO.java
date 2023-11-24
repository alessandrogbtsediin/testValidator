package it.sediin.testValidator.Entities;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileDTO {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
