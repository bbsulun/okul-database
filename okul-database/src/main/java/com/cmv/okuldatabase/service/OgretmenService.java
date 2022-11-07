package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.Ogretmen;
import com.cmv.okuldatabase.repository.OgretmenRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class OgretmenService {

    private final OgretmenRepository ogretmenRepository;

    public List<Ogretmen> findAll() {
        return ogretmenRepository.findAll();
    }

    public Ogretmen save(Ogretmen ogretmen){
        return ogretmenRepository.save(ogretmen);
    }

    public List<Ogretmen> saveOgretmens(List<Ogretmen> ogretmens){
        return ogretmenRepository.saveAll(ogretmens);
    }

    public Ogretmen updateOgretmen(Ogretmen ogretmen){
        Ogretmen existingOgretmen = ogretmenRepository.findById(ogretmen.getId()).orElse(null);
        existingOgretmen.setAdi(ogretmen.getAdi());
        return ogretmenRepository.save((existingOgretmen));

    }

    public String deleteOgretmen(long id){
        ogretmenRepository.deleteById(id);
        return "product removed" + id;
    }
}
