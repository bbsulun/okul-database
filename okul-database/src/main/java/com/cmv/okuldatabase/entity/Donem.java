package com.cmv.okuldatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Donem {

    @Id
    private Long id;
    private String adi;


    @ManyToOne
    private Okul okul;


    @ManyToMany
    Set<Ders> dersler;


    @OneToMany(mappedBy = "donem")
    private Set<DonemDersOgrenci> donemKayitlari;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donem donem = (Donem) o;
        return id.equals(donem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}