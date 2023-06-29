package com.industri.home.security.service.services;

import com.industri.home.exception.ResourceNotFoundException;
import com.industri.home.model.User;
import com.industri.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepository repository;

    public User findById(String id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id = " + id));
    }
    public List<User> findAll(){
        return repository.findAll();
    }
    public User create(User request) {

        if (!StringUtils.hasText(request.getId())) {
            throw new ResourceNotFoundException("Username harus diisi");
        }

        if (repository.existsById(request.getId())) {
            throw new ResourceNotFoundException("Username " + request.getId() + " sudah terdaftar");
        }

        if (!StringUtils.hasText(request.getEmail())) {
            throw new ResourceNotFoundException("Email harus diisi");
        }

        if (repository.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException("Email " + request.getEmail() + " sudah terdaftar");
        }
        request.setIsAktif(true);
        return repository.save(request);

    }
    public User edit(User users, String id) {
        if (!StringUtils.hasText(users.getId())) {
            throw new ResourceNotFoundException("Username harus diisi");
        }

        if (!StringUtils.hasText(users.getEmail())) {
            throw new ResourceNotFoundException("Email harus diisi");
        }

        return repository.save(users);

    }
    public void deleteById(String id){
        repository.deleteById(id);
    }
}
