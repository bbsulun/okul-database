package com.cmv.okuldatabase.repository;

import com.cmv.okuldatabase.entity.DonemDersOgrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonemDersOgrenciRepository extends JpaRepository<DonemDersOgrenci, Long> {



}