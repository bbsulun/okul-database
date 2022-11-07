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
public class Ogrenci {

    @Id
    private Long id;
    private Long tc;
    private String adi;
    private String soyadi;
    private Date dtarihi;
    private Long tel;



    @ManyToMany
    Set<Ders> dersler;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bolum bolum;


    @ManyToOne(fetch = FetchType.LAZY)
    private Okul okul;


    @OneToMany(mappedBy = "ogrenci")
    private Set<DonemDersOgrenci> ogrenciKayitlari;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ogrenci ogrenci = (Ogrenci) o;
        return id.equals(ogrenci.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
