package com.backend.controller;

import com.backend.entity.DocumentEntity;
import com.backend.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocService docService;

    @GetMapping("findbyid")
    public Optional<DocumentEntity> DocById(Long id) {
        id = 3L;
        return docService.findById(id);
    }
}
