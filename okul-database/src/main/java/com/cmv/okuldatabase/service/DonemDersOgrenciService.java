package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.DonemDersOgrenci;
import com.cmv.okuldatabase.repository.DonemDersOgrenciRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class DonemDersOgrenciService {

    private final DonemDersOgrenciRepository donemDersOgrenciRepository;

    public List<DonemDersOgrenci> findAll() {
        return donemDersOgrenciRepository.findAll();
    }

    public DonemDersOgrenci save(DonemDersOgrenci donemDersOgrenci){
        return donemDersOgrenciRepository.save(donemDersOgrenci);
    }

    public List<DonemDersOgrenci> saveDonemDersOgrencis(List<DonemDersOgrenci> donemDersOgrencis){
        return donemDersOgrenciRepository.saveAll(donemDersOgrencis);
    }

    public DonemDersOgrenci updateDonemDersOgrenci(DonemDersOgrenci donemDersOgrenci){
        DonemDersOgrenci existingDonemDersOgrenci = donemDersOgrenciRepository.findById(donemDersOgrenci.getId()).orElse(null);
        existingDonemDersOgrenci.setId(donemDersOgrenci.getId());
        return donemDersOgrenciRepository.save((existingDonemDersOgrenci));

    }

    public String deleteDonemDersOgrenci(long id){
        donemDersOgrenciRepository.deleteById(id);
        return "product removed" + id;
    }

}
