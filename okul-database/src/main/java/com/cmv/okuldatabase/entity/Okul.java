package com.cmv.okuldatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Okul {
    @Id
    private Long id;
    private String adi;

    @OneToMany(mappedBy = "okul")
    private Set<Bolum> bolumler;

    @OneToMany(mappedBy = "okul")
    private Set<Donem> donemler;

    @OneToMany(mappedBy = "okul")
    private Set<Ogrenci> ogrenciler;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Okul okul = (Okul) o;
        return id.equals(okul.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
