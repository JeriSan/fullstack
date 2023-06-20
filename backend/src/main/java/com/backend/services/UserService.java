package com.backend.services;

import com.backend.entity.UserEntity;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save (UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public void changePasswordUser(Long id, String password){ userRepository.changePasswordUser(id, password);}

    public List<UserEntity> selectUserWithPerson(){
        List<UserEntity> userList = userRepository.selectUserWithPerson();
        return userList;
    }

}
