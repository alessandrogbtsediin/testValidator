package it.sediin.testValidator.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class UploadFilesService {

//    private String folderRepository() {
//        return System.getProperty("user.home") + File.separator + "Desktop";
//    }

    private final Path rootLocation = Paths.get(System.getProperty("user.home") + File.separator + "Desktop"+ File.separator+ "files");

//    public void store(MultipartFile files) throws IOException {
//            try {
//                Files.copy(files.getInputStream(), this.rootLocation.resolve(Objects.requireNonNull(files.getOriginalFilename())));
//
//            } catch (Exception e) {
//                throw new IOException("Error saving file: " + files.getOriginalFilename(), e);
//            }
//        }

    public void store(MultipartFile file) throws IOException {
        String originalFilename = Objects.requireNonNull(file.getOriginalFilename());

        try (InputStream inputStream = file.getInputStream()) {
            Path destinationFile = this.rootLocation.resolve(originalFilename);
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new IOException("Error saving file: " + originalFilename, e);
        }
    }





    public void storeMultipleFiles(MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
            try (InputStream inputStream = file.getInputStream()) {
                if (!file.isEmpty()) {
                    Path destinationFile = this.rootLocation.resolve(originalFilename);
                    Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

                }
            } catch (Exception e) {
                throw new IOException("Error saving file: " + file.getOriginalFilename(), e);
            }
        }
    }



    }

//}
