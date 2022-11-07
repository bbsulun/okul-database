package com.cmv.okuldatabase.service;

import com.cmv.okuldatabase.entity.Ders;
import com.cmv.okuldatabase.repository.DersRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class DersService {

    private final DersRepository dersRepository;

    public List<Ders> findAll() {
        return dersRepository.findAll();
    }

    public Ders save(Ders ders){
        return dersRepository.save(ders);
    }

   public Ders getDersByName(String adi){
        return dersRepository.findByAdi(adi);
   }

   public Ders getDersById(Long id){
        return dersRepository.findById(id).orElse(null);
   }


    public List<Ders> saveDers(List<Ders> ders){
        return dersRepository.saveAll(ders);
    }

    public Ders updateDers(Ders ders){
        Ders existingDers = dersRepository.findById(ders.getId()).orElse(null);
        existingDers.setAdi(ders.getAdi());
        return dersRepository.save((existingDers));

    }

    public String deleteDers(long id){
        dersRepository.deleteById(id);
        return "product removed" + id;
    }

}
