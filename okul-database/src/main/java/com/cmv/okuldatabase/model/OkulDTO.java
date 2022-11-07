package com.cmv.okuldatabase.model;

public class OkulDTO {
    private Long id;
    private String adi;

    private Long getId(){
        return id;
    }
    private void setId(Long id){
        this.id = id;
    }

    private String getadi(){
        return adi;
    }
    private void setAdi(String adi){
        this.adi = adi;
    }
}
