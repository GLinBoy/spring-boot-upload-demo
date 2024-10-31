package com.glinboy.sample.upload.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    Optional<String> store(MultipartFile file);
}
