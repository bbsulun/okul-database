package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    Ogrenci findByAdi(String name);

}
