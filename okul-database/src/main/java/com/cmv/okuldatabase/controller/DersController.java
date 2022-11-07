package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.Ders;
import com.cmv.okuldatabase.model.DersDTO;
import com.cmv.okuldatabase.service.DersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DersController {

    private final DersService dersService;
    private final ModelMapper mapper;

    @PostMapping("/dersSave")
    public DersDTO save(@RequestBody DersDTO dersDto){
        Ders ders = mapper.map(dersDto, Ders.class);
        System.out.println("Printing ders after mapping:"+ders);
        ders= dersService.save(ders);
        DersDTO dersDTO = mapper.map(ders, DersDTO.class);
        return dersDTO;
    }

    @GetMapping("/ders")
    public List<Ders> retrieveAllDers() {
        return dersService.findAll();
    }

    @GetMapping("/ders/{adi}")
    public Ders findDersByName(@PathVariable String adi) {
        return dersService.getDersByName(adi);
    }

    @GetMapping("/dersById/{id}")
    public Ders findDersById(@PathVariable Long id) {
        return dersService.getDersById(id);
    }

    @PostMapping("/addDers")
    public Ders addDers(@RequestBody Ders ders){
        return dersService.save(ders);
    }

    @PostMapping("/addDerss")
    public List<Ders> addDerss(@RequestBody List<Ders> derss){
        return dersService.saveDers(derss);
    }

    @PutMapping("/updateDers")
    public Ders updateDers(@RequestBody Ders ders){
        return dersService.updateDers(ders);
    }

    @DeleteMapping("/deleteDers/{id}")
    public String deleteDers(@PathVariable long id){
        return dersService.deleteDers(id);
    }

}
