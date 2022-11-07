package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.Bolum;
import com.cmv.okuldatabase.model.BolumDTO;
import com.cmv.okuldatabase.service.BolumService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BolumController {

    private final BolumService bolumService;
    private final ModelMapper mapper;

    @PostMapping("/bolumSave")
    public BolumDTO save(@RequestBody BolumDTO bolumDto){
        Bolum bolum = mapper.map(bolumDto, Bolum.class);
        System.out.println("Printing bolum after mapping:"+bolum);
        bolum= bolumService.save(bolum);
        return mapper.map(bolum, BolumDTO.class);
    }


    @GetMapping("/bolum")
    public List<Bolum> retrieveAllBolums() {
        return bolumService.findAll();
    }

    @GetMapping("/bolum/{adi}")
    public Bolum findBolumByName(@PathVariable String adi) {
        return bolumService.getBolumByName(adi);
    }

    @PostMapping("/addBolum")

    public Bolum addBolum(@RequestBody Bolum bolum){
        return bolumService.save(bolum);
    }
    @PostMapping("/addBolums")
    public List<Bolum> addBolums(@RequestBody List<Bolum> bolums){
        return bolumService.saveBolums(bolums);
    }

    @PutMapping("/updateBolum")
    public Bolum updateBolum(@RequestBody Bolum bolum){
        return bolumService.updateBolum(bolum);
    }

    @DeleteMapping("/deleteBolum/{id}")
    public String deleteBolum(@PathVariable long id){
        return bolumService.deleteBolum(id);
    }
}
