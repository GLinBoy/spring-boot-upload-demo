package com.glinboy.sample.upload.web.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.glinboy.sample.upload.service.FileStorageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadController {

    private final FileStorageService fileStorageService;

    @PostMapping
    public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        Optional<String> stored = fileStorageService.store(file);
        return stored.map(r -> {
            redirectAttributes.addFlashAttribute("message", r);
            return "redirect:/successful.html";
        }).orElseGet(() -> "redirect:/error.html");
    }

    @PostMapping("/multiple")
    public String uploadFiles(@RequestParam MultipartFile[] files) {
        Stream.of(files).forEach(fileStorageService::store);
        return "redirect:/successful.html";
    }
}
