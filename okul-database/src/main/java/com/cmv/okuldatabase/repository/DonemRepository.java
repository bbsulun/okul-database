package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Donem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonemRepository extends JpaRepository<Donem, Long> {

    Donem findByAdi(String name);

}