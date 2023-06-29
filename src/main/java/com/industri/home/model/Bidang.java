package com.industri.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "bidang")
public class Bidang {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    private Long id;

    @Column(name = "nama_pekerjaan", nullable = false, length = 50)
    private String namaPekerjaan;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", nullable = false)
    @JsonIgnoreProperties({"email","password","alamat","createdOn", "updatedOn"})
    private User createdBy;

    public Bidang() {
    }

    public Bidang(String namaPekerjaan, String deskripsi) {
        this.namaPekerjaan =namaPekerjaan;
        this.deskripsi = deskripsi;
    }

    public Bidang(long id, String namaPekerjaan, String deskripsi) {
        this.id = id;
        this.namaPekerjaan = namaPekerjaan;
        this.deskripsi = deskripsi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
