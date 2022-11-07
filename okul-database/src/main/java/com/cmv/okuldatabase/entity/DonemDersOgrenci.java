package com.cmv.okuldatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class DonemDersOgrenci {
    @Id
    private Long id;

    @ManyToOne
    private Ogrenci ogrenci;

    @ManyToOne
    private Donem donem;

    @ManyToOne
    private Ders ders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonemDersOgrenci that = (DonemDersOgrenci) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
