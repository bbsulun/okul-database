package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.Bolum;
import com.cmv.okuldatabase.repository.BolumRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Getter
public class BolumService {

    private final BolumRepository bolumRepository;

    public List<Bolum> findAll() {

        return bolumRepository.findAll();
    }

    public Bolum getBolumByName(String adi){
        return bolumRepository.findByAdi(adi);
    }

    public Bolum save(Bolum bolum){
        return bolumRepository.save(bolum);
    }

    public List<Bolum> saveBolums(List<Bolum> bolums){
        return bolumRepository.saveAll(bolums);
    }

    public Bolum updateBolum(Bolum bolum){
        Bolum existingBolum = bolumRepository.findById(bolum.getId()).orElse(null);
        existingBolum.setAdi(bolum.getAdi());
        return bolumRepository.save((existingBolum));

    }

    public String deleteBolum(long id){
        bolumRepository.deleteById(id);
        return "product removed" + id;
    }
}
