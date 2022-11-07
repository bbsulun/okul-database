package com.cmv.okuldatabase.controller;
import com.cmv.okuldatabase.entity.Donem;
import com.cmv.okuldatabase.model.DonemDTO;

import com.cmv.okuldatabase.service.DonemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DonemController {

    private final DonemService donemService;
    private final ModelMapper mapper;

    @PostMapping("/donemsave")
    public DonemDTO save(@RequestBody DonemDTO donemDto){
        Donem donem = mapper.map(donemDto, Donem.class);
        System.out.println("Printing donem after mapping:"+donem);
        donem= donemService.save(donem);
        DonemDTO donemDTO = mapper.map(donem, DonemDTO.class);
        return donemDTO;
    }

    @GetMapping("/donem")
    public List<Donem> retrieveAllDonems() {
        return donemService.findAll();

    }

    @PostMapping("/addDonem")
    public Donem addDonem(@RequestBody Donem donem){
        return donemService.save(donem);
    }

    @PostMapping("/addDonems")
    public List<Donem> addDonems(@RequestBody List<Donem> donems){
        return donemService.saveDonems(donems);
    }

    @PutMapping("/updateDonem")
    public Donem updateDonem(@RequestBody Donem donem){
        return donemService.updateDonem(donem);
    }

    @DeleteMapping("/deleteDonem/{id}")
    public String deleteDonem(@PathVariable long id){
        return donemService.deleteDonem(id);
    }

}
