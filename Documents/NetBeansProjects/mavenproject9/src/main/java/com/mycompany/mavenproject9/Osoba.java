/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject9;

/**
 *
 * @author Kasia
 */
public class Osoba {
    private String nazwisko;
    private String imie;
    private Double wiek;
    public Osoba(String naz, String im, Double w)
    {
        nazwisko = naz;
        imie = im;
        wiek = w;
    }
    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the wiek
     */
    public Double getWiek() {
        return wiek;
    }

    /**
     * @param wiek the wiek to set
     */
    public void setWiek(Double wiek) {
        this.wiek = wiek;
    }
    
}
