package com.cmv.okuldatabase.controller;

import com.cmv.okuldatabase.entity.Ogretmen;
import com.cmv.okuldatabase.model.OgretmenDTO;
import com.cmv.okuldatabase.service.OgretmenService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OgretmenController {

    private final OgretmenService ogretmenService;

    private final ModelMapper mapper;

    @PostMapping("/ogretmensave")
    public OgretmenDTO save(@RequestBody OgretmenDTO ogretmenDto){
        Ogretmen ogretmen = mapper.map(ogretmenDto, Ogretmen.class);
        System.out.println("Printing ogretmen after mapping:"+ogretmen);
        ogretmen= ogretmenService.save(ogretmen);
        OgretmenDTO ogretmenDTO = mapper.map(ogretmen, OgretmenDTO.class);
        return ogretmenDTO;
    }

    @GetMapping("/ogretmen")
    public List<Ogretmen> retrieveAllOgretmen(){
        return ogretmenService.findAll();
    }


    @PostMapping("/addOgretmen")
    public Ogretmen addOgretmen(@RequestBody Ogretmen ogretmen){
        return ogretmenService.save(ogretmen);
    }

    @PostMapping("/addOgretmens")
    public List<Ogretmen> addOgretmens(@RequestBody List<Ogretmen> ogretmens){
        return ogretmenService.saveOgretmens(ogretmens);
    }

    @PutMapping("/updateOgretmen")
    public Ogretmen updateOgretmen(@RequestBody Ogretmen ogretmen){
        return ogretmenService.updateOgretmen(ogretmen);
    }

    @DeleteMapping("/deleteOgretmen/{id}")
    public String deleteOgretmen(@PathVariable long id){
        return ogretmenService.deleteOgretmen(id);
    }
}
