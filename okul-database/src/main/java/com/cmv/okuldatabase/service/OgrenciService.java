package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.Ogrenci;
import com.cmv.okuldatabase.repository.OgrenciRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class OgrenciService {

    private final OgrenciRepository ogrenciRepository;

    public List<Ogrenci> findAll() {
        return ogrenciRepository.findAll();
    }

    public Ogrenci getOgrenciById(long id){
        return ogrenciRepository.findById(id).orElse(null);
    }

    public Ogrenci getOgrenciByName(String adi){
        return ogrenciRepository.findByAdi(adi);
    }


    public Ogrenci save(Ogrenci ogrenci){
        return ogrenciRepository.save(ogrenci);
    }

    public List<Ogrenci> saveOgrencis(List<Ogrenci> ogrencis){
        return ogrenciRepository.saveAll(ogrencis);
    }

    public Ogrenci updateOgrenci(Ogrenci ogrenci){
        Ogrenci existingOgrenci = ogrenciRepository.findById(ogrenci.getId()).orElse(null);
        existingOgrenci.setAdi(ogrenci.getAdi());
        return ogrenciRepository.save((existingOgrenci));

    }

    public String deleteOkul(long id){
        ogrenciRepository.deleteById(id);
        return "product removed" + id;
    }

}
