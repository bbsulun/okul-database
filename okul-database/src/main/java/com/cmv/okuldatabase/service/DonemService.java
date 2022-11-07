package com.cmv.okuldatabase.service;
import com.cmv.okuldatabase.entity.Donem;
import com.cmv.okuldatabase.repository.DonemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class DonemService {

    private final DonemRepository donemRepository;

    public List<Donem> findAll() {
        return donemRepository.findAll();
    }

    public Donem save(Donem donem){
        return donemRepository.save(donem);
    }

    public List<Donem> saveDonems(List<Donem> donems){
        return donemRepository.saveAll(donems);
    }

    public Donem updateDonem(Donem donem){
        Donem existingDonem = donemRepository.findById(donem.getId()).orElse(null);
        existingDonem.setAdi(donem.getAdi());
        return donemRepository.save((existingDonem));

    }

    public String deleteDonem(long id){
        donemRepository.deleteById(id);
        return "product removed" + id;
    }
}
