package com.cmv.okuldatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Ogretmen {

    @Id
    private Long id;
    private Long tc;
    private String adi;
    private String soyadi;
    private Date dtarihi;
    private Long tel;


    @ManyToMany
    Set<Ders> dersler;

    @ManyToOne
    private Bolum bolum;

    @ManyToOne
    private Okul okul;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ogretmen ogretmen = (Ogretmen) o;
        return id.equals(ogretmen.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
