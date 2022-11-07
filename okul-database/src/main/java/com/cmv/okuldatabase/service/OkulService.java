package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.Okul;
import com.cmv.okuldatabase.repository.OkulRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Service
public class OkulService {

    private final OkulRepository okulRepository;

    public List<Okul> findAll() {
        return okulRepository.findAll();
    }

    public Okul getOkulById(long id){
        return okulRepository.findById(id).orElse(null);
    }

    public Okul getOkulByName(String adi){
        return okulRepository.findByAdi(adi);
    }

    public Okul save(Okul okul){
        return okulRepository.save(okul);
    }

    public List<Okul> saveOkuls(List<Okul> okuls){
        return okulRepository.saveAll(okuls);
    }

    public Okul updateOkul(Okul okul){
        Okul existingOkul = okulRepository.findById(okul.getId()).orElse(null);
        existingOkul.setAdi(okul.getAdi());
        return okulRepository.save((existingOkul));

    }

    public String deleteOkul(long id){
        okulRepository.deleteById(id);
        return "product removed" + id;
    }

}
