package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.Ogrenci;
import com.cmv.okuldatabase.model.OgrenciDTO;
import com.cmv.okuldatabase.service.OgrenciService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class OgrenciController {

    private final OgrenciService ogrenciService;
    private final ModelMapper mapper;

    @PostMapping("/ogrencisave")
    public OgrenciDTO save(@RequestBody OgrenciDTO ogrenciDto){
        Ogrenci ogrenci = mapper.map(ogrenciDto, Ogrenci.class);
        System.out.println("Printing ogrenci after mapping:"+ogrenci);
        ogrenci= ogrenciService.save(ogrenci);
        OgrenciDTO ogrenciDTO = mapper.map(ogrenci, OgrenciDTO.class);
        return ogrenciDTO;

    }


    @GetMapping("/ogrenci")
    public List<Ogrenci> retrieveAllOgrencis() {
        return ogrenciService.findAll();

    }

    @GetMapping("/ogrenciById/{id}")
    public Ogrenci findOgrenciById(@PathVariable long id){
        return ogrenciService.getOgrenciById(id);
    }

    @GetMapping( "/ogrenci/{adi}")
    public Ogrenci findOgrenciByName(@PathVariable String adi) {
        return ogrenciService.getOgrenciByName(adi);
    }

    @PostMapping("/addOgrenci")
    public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci){
        return ogrenciService.save(ogrenci);
    }

    @PostMapping("/addOgrencis")
    public List<Ogrenci> addOgrencis(@RequestBody List<Ogrenci> ogrencis){
        return ogrenciService.saveOgrencis(ogrencis);
    }

    @PutMapping("/updateOgrenci")
    public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci){
        return ogrenciService.updateOgrenci(ogrenci);
    }

    @DeleteMapping("/deleteOgrenci/{id}")
    public String deleteOgrenci(@PathVariable long id){
        return ogrenciService.deleteOkul(id);
    }
}
