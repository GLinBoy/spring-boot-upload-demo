package com.glinboy.sample.upload.service.mpl;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.glinboy.sample.upload.service.FileStorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileStorageTempServiceImpl implements FileStorageService {

    @Override
    public Optional<String> store(MultipartFile file) {
        try {
            File uploadedFile = new File("%s/%s".formatted(
                    System.getProperty("java.io.tmpdir"), file.getOriginalFilename()));
            file.transferTo(uploadedFile);
            return Optional.of(uploadedFile.getAbsolutePath());
        } catch (IOException ex) {
            log.error("Can't store file", ex);
        }
        return Optional.empty();
    }
}
