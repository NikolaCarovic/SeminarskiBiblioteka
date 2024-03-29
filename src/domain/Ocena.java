/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Nikola
 */
public class Ocena {
    
    private Double ocena;
    private String opis;
    private Knjiga knjiga;
    private Korisnik korisnik;

    public Ocena( Double ocena, String opis, Knjiga knjiga, Korisnik korisnik) {
        this.ocena = ocena;
        this.opis = opis;
        this.knjiga = knjiga;
        this.korisnik = korisnik;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    
}
