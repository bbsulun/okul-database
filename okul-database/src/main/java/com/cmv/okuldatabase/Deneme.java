package com.cmv.okuldatabase;

import com.cmv.okuldatabase.entity.Ogrenci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deneme  {

    public static void main(String[] args){
        String a ="1";
        String b ="1";

        Ogrenci ogrenci= new Ogrenci();

        ogrenci.setId(1L);
        ogrenci.setAdi("bitane");

        Ogrenci ogrenci1= new Ogrenci();

        ogrenci1.setId(1L);
        ogrenci1.setAdi("cemil");

        Ogrenci ogrenci3= new Ogrenci();

        ogrenci3.setId(1L);

        System.out.println(ogrenci.equals(ogrenci1));
        System.out.println(ogrenci.hashCode()+"-"+ ogrenci1.hashCode());
        System.out.println(ogrenci==ogrenci1);


        List<Ogrenci>  ogrenciList=new ArrayList<>();
        ogrenciList.add(ogrenci);
        ogrenciList.add(ogrenci1);

        Set<Ogrenci> hashSet= new HashSet<>();
        hashSet.add(ogrenci);
        hashSet.add(ogrenci1);

        System.out.println(ogrenciList.contains(ogrenci3));

        System.out.println(hashSet.contains(ogrenci3));





    }
}
