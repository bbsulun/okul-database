package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.DonemDersOgrenci;
import com.cmv.okuldatabase.model.DonemDersOgrenciDTO;
import com.cmv.okuldatabase.service.DonemDersOgrenciService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DonemDersOgrenciController {

    private final DonemDersOgrenciService donemDersOgrenciService;
    private final ModelMapper mapper;

    @PostMapping("/donemDersOgrenciSave")
    public DonemDersOgrenciDTO save(@RequestBody DonemDersOgrenciDTO donemDersOgrenciDto){
        DonemDersOgrenci donemDersOgrenci = mapper.map(donemDersOgrenciDto, DonemDersOgrenci.class);
        System.out.println("Printing donemDersOgrenci after mapping:"+donemDersOgrenci);
        donemDersOgrenci= donemDersOgrenciService.save(donemDersOgrenci);
        DonemDersOgrenciDTO donemDersOgrenciDTO = mapper.map(donemDersOgrenci, DonemDersOgrenciDTO.class);
        return donemDersOgrenciDTO;
    }

    @GetMapping("/donemDersOgrenci")
    public List<DonemDersOgrenci> retrieveAllDonemDersOgrencis() {
        return donemDersOgrenciService.findAll();
    }

    @PostMapping("/addDonemDersOgrenci")
    public DonemDersOgrenci addDonemDersOgrenci(@RequestBody DonemDersOgrenci donemDersOgrenci){
        return donemDersOgrenciService.save(donemDersOgrenci);
    }
    @PostMapping("/addDonemDersOgrencis")
    public List<DonemDersOgrenci> addDonemDersOgrenci(@RequestBody List<DonemDersOgrenci> donemDersOgrencis){
        return donemDersOgrenciService.saveDonemDersOgrencis(donemDersOgrencis);
    }

    @PutMapping("/updateDDO")
    public DonemDersOgrenci updateDonemDersOgrenci(@RequestBody DonemDersOgrenci donemDersOgrenci){
        return donemDersOgrenciService.updateDonemDersOgrenci(donemDersOgrenci);
    }

    @DeleteMapping("/deleteDDO/{id}")
    public String deleteDonemDersOgrenci(@PathVariable long id){
        return donemDersOgrenciService.deleteDonemDersOgrenci(id);
    }
}


