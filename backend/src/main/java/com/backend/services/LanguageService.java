package com.backend.services;

import com.backend.entity.LanguageEntity;
import com.backend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Transactional
    public void save (LanguageEntity languageEntity){
        languageRepository.save(languageEntity);
    }

    public Optional<LanguageEntity> findById(Long id){
        return languageRepository.findById(id);
    }


}
