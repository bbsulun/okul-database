package com.cmv.okuldatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Ders {

    @Id
    private Long id;

    private String adi;



    @OneToMany(mappedBy = "ders")
    private Set<DonemDersOgrenci> dersKayitlari;

    @ManyToMany(mappedBy = "dersler")
    Set<Ogrenci> alinanDers;

    @ManyToMany(mappedBy = "dersler")
    Set<Ogretmen> verilenDers;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ders ders = (Ders) o;
        return id.equals(ders.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
