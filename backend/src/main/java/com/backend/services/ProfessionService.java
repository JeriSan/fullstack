package com.backend.services;

import com.backend.entity.ProfessionEntity;
import com.backend.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProfessionService {
    @Autowired
    private ProfessionRepository professionRepository;

    @Transactional
    public void save (ProfessionEntity professionEntity){
        professionRepository.save(professionEntity);
    }

    public Optional<ProfessionEntity> findById(Long id){
        return professionRepository.findById(id);
    }
}
