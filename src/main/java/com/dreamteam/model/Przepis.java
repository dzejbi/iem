package com.dreamteam.model;

public class Przepis {

    private long id_przepis;
    private String nazwa;
    private String opis;
    private int ocena;
    private int typ;
    private String zdjecie;

    public long getId_przepis() {
        return id_przepis;
    }

    public void setId_przepis(long id_przepis) {
        this.id_przepis = id_przepis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }
}
