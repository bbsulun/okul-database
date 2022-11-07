package com.cmv.okuldatabase.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Bolum {
    @Id
    private Long id;
    private String adi;

    @ManyToMany
    Set<Ders> dersler;

    @ManyToOne
    private Okul okul;

    @OneToMany(mappedBy = "bolum")
    private Set<Ogrenci> ogrenciler;

    @OneToMany(mappedBy = "bolum")
    private Set<Ogretmen> ogretmenler;



}
