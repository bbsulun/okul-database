package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Okul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OkulRepository extends JpaRepository<Okul, Long> {

    Okul findByAdi(String name);

}