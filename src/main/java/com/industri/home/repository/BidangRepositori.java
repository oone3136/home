package com.industri.home.repository;

import com.industri.home.model.Bidang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BidangRepositori extends JpaRepository<Bidang, Long>{
    @Transactional
    Optional<Bidang> findByNamaPekerjaan(String namaPekerjaan);
}
