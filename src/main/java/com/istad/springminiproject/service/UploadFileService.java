package com.istad.springminiproject.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    String fileUpload(MultipartFile file) throws IOException;
}
