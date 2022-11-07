package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolumRepository extends JpaRepository<Bolum, Long> {

    Bolum findByAdi(String name);

}
