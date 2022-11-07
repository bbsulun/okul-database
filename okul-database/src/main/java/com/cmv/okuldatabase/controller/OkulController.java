package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.Ogrenci;
import com.cmv.okuldatabase.entity.Okul;
import com.cmv.okuldatabase.model.OgrenciDTO;
import com.cmv.okuldatabase.model.OkulDTO;
import com.cmv.okuldatabase.service.OkulService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RequiredArgsConstructor
@RestController
public class OkulController {

    private final ModelMapper mapper;
    private final OkulService okulService;

    @PostMapping("/okulSave")
    public OkulDTO save(@RequestBody OkulDTO okulDto){
        Okul okul = mapper.map(okulDto, Okul.class);
        System.out.println("Printing okul after mapping:"+okul);
        okul= okulService.save(okul);
        OkulDTO okulDTO = mapper.map(okul, OkulDTO.class);
        return okulDTO;
    }

    @GetMapping("/okul")
    public List<Okul> retrieveAllOkuls() {

        return okulService.findAll();
    }

    @GetMapping("/okulById/{id}")
    public Okul findOkulById(@PathVariable long id) {
        return okulService.getOkulById(id);
    }

    @GetMapping("/okul/{adi}")
    public Okul findOkulByName(@PathVariable String adi){
        return okulService.getOkulByName(adi);
    }

    @PostMapping("/addOkul")
   public Okul addOkul(@RequestBody Okul okul){
        return okulService.save(okul);
    }
    @PostMapping("/addOkuls")
    public List<Okul> addOkuls(@RequestBody List<Okul> okuls){
        return okulService.saveOkuls(okuls);
    }

    @PutMapping("/updateOkul")
    public Okul updateOkul(@RequestBody Okul okul){
        return okulService.updateOkul(okul);
    }

    @DeleteMapping("/deleteOkul/{id}")
    public String deleteOkul(@PathVariable long id){
        return okulService.deleteOkul(id);
    }
}
