package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Ogretmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen, Long> {

    Ogretmen findByAdi(String name);

}