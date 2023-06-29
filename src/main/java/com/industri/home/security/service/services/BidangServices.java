package com.industri.home.security.service.services;

import com.industri.home.exception.ResourceNotFoundException;
import com.industri.home.model.Bidang;
import com.industri.home.model.User;
import com.industri.home.repository.BidangRepositori;
import com.industri.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidangServices {

    @Autowired
    BidangRepositori repository;

    @Autowired
    UserRepository userRepository;

    public Bidang findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bidang dengan id = " + id));
    }
    public List<Bidang> findAll(){
        return repository.findAll();
    }

    public Bidang create(Bidang request){
        try {
            Bidang checkBidang = repository.findByNamaPekerjaan(request.getNamaPekerjaan()).orElse(new Bidang());
            if (checkBidang.getNamaPekerjaan() != null){
                throw new ResourceNotFoundException("nama sudah di gunakan");
            }
            if (request.getNamaPekerjaan().length()<3){
                throw new ResourceNotFoundException("nama pekerjaan tidak noleh kosong ");
            }
            if (request.getDeskripsi().isBlank()){
                throw new ResourceNotFoundException("Deskripsi tidak boleh kosong");
            }
            Optional<User> user = userRepository.findById(request.getCreatedBy().getId());
            if (!user.isPresent()){
                throw new ResourceNotFoundException("user Id tidak ditemukan");
            }else {
                User userId = userRepository.findById(request.getCreatedBy().getId()).get();
                request.setCreatedBy(userId);
            }
            Bidang bidangBaru = new Bidang(request.getNamaPekerjaan(), request.getDeskripsi());
            bidangBaru.setCreatedBy(user.get());
            repository.save(bidangBaru);
            return bidangBaru;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Bidang edit(Bidang request, long id) {
        try {
            Bidang checkBidang = repository.findByNamaPekerjaan(request.getNamaPekerjaan()).orElse(new Bidang());
            if (checkBidang.getNamaPekerjaan() != null){
                throw new ResourceNotFoundException("nama sudah di gunakan");
            }
            if (request.getNamaPekerjaan().length()<3){
                throw new ResourceNotFoundException("nama pekerjaan tidak noleh kosong ");
            }
            if (request.getDeskripsi().isBlank()){
                throw new ResourceNotFoundException("Deskripsi tidak boleh kosong");
            }
            Optional<User> user = userRepository.findById(request.getCreatedBy().getId());
            if (!user.isPresent()){
                throw new ResourceNotFoundException("user Id tidak ditemukan");
            }else {
                User userId = userRepository.findById(request.getCreatedBy().getId()).get();
                request.setCreatedBy(userId);
            }
            Bidang bidangBaru = new Bidang(request.getId(),request.getNamaPekerjaan(), request.getDeskripsi());
            bidangBaru.setCreatedBy(user.get());
            repository.save(bidangBaru);
            return bidangBaru;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
