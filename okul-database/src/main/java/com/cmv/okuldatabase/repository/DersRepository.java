package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DersRepository extends JpaRepository<Ders, Long> {

    Ders findByAdi(String name);

}