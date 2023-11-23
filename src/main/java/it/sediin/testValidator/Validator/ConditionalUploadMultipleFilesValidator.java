package it.sediin.testValidator.Validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConditionalUploadMultipleFilesValidator implements ConstraintValidator<ConditionalUploadMultipleFiles, MultipartFile[]> {
    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("text/xml")
                || contentType.equals("application/pdf")
                || contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }

    @Override
    public boolean isValid(MultipartFile[] multipartFiles, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();
            boolean result = true;

        for (MultipartFile m: multipartFiles) {
            String type = m.getContentType();
            if (type==null || !isSupportedContentType(type)) {
                context.buildConstraintViolationWithTemplate(m.getOriginalFilename()+" HAS INCORRECT FILE TYPE")
                    .addPropertyNode("documents")
                    .addConstraintViolation();
                result = false;
            }
        }
            return result;
            }





}










    //check sul MIME format
//    private boolean isSupportedContentType(String contentType) {
//        return contentType != null && (contentType.equals("application/pdf") || contentType.startsWith("image/"));
//    }
//
//    @Override
//    public boolean isValid(MultipartFile[] multipartFiles, ConstraintValidatorContext context) {
//        if (multipartFiles == null || multipartFiles.length < 1) {
//            context.buildConstraintViolationWithTemplate("You have to upload at least 1 file")
//                    .addPropertyNode("documents")
//                    .addConstraintViolation();
//            return false;
//        }
//
//        boolean isValid = true;
//
//        for (MultipartFile file : multipartFiles) {
//            if (file.isEmpty() || file.getSize() == 0) {
//                context.buildConstraintViolationWithTemplate("One or more file(s) are empty or have invalid size")
//                        .addPropertyNode("documents")
//                        .addConstraintViolation();
//                isValid = false;
//            } else if (!isSupportedContentType(file.getContentType())) {
//                context.buildConstraintViolationWithTemplate("Unsupported file type: " + file.getContentType())
//                        .addPropertyNode("documents")
//                        .addConstraintViolation();
//                isValid = false;
//            }
//        }
//
//        return isValid;
//    }
//}



//
//package it.sediin.testValidator.Validator;
//
//        import it.sediin.testValidator.Entities.UploadFiles;
//        import it.sediin.testValidator.Entities.User;
//        import org.springframework.web.multipart.MultipartFile;
//
//        import javax.validation.ConstraintValidator;
//        import javax.validation.ConstraintValidatorContext;
//
//public class ConditionalUploadFilesValidator implements ConstraintValidator<ConditionalUploadFiles, UploadFiles> {
//
//
//    @Override
//    public boolean isValid(UploadFiles uploadFiles, ConstraintValidatorContext context) {
//
//
//        if (uploadFiles.getDocuments() == null || uploadFiles.getDocuments().length < 1) {
//            context.buildConstraintViolationWithTemplate("You have to upload at least 1 file")
//                    .addPropertyNode("documents")
//                    .addConstraintViolation();
//            return false;
//        }
//
//        boolean isValid = true;
//
//        for (MultipartFile file : uploadFiles.getDocuments()) {
//            if (file.isEmpty() || file.getSize() <= 0) {
//                context.buildConstraintViolationWithTemplate("One or more file(s) are empty or have invalid size")
//                        .addPropertyNode("documents")
//                        .addConstraintViolation();
//                isValid = false;
//            } else if (!isSupportedContentType(file.getContentType())) {
//                context.buildConstraintViolationWithTemplate("Unsupported file type: " + file.getContentType())
//                        .addPropertyNode("documents")
//                        .addConstraintViolation();
//                isValid = false;
//            }
//        }
//
//        return isValid;
//    }
//
//    //check sul MIME format
//    private boolean isSupportedContentType(String contentType) {
//        return contentType != null && (contentType.equals("application/pdf") || contentType.startsWith("image/")); // This will cover image/jpeg, image/png, etc.
//    }
//}
