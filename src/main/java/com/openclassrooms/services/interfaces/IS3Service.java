package com.openclassrooms.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IS3Service {

    String uploadFile(MultipartFile multipartFile) throws IOException;
    File convertMultiPartToFile(MultipartFile file) throws IOException;
    void downloadFile(String fileName, File file);
    void deleteFile(String fileName);
}
