package com.backend.services;

import com.backend.entity.DocumentEntity;
import com.backend.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DocService {
    @Autowired
    private DocRepository docRepository;

    @Transactional
    public void save (DocumentEntity documentEntity){
        docRepository.save(documentEntity);
    }

    public Optional <DocumentEntity> findById(Long id) {
        return  docRepository.findById(id);
    }
}
