/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Knjiga {
    private String naslov;
    private String autor;
    private String izdavac;
    private Long isbn;
    private String jezik;
    private String opis;
    private int brojStrana;
    private int ukupanBrojKnjiga;
    private int raspolozivBrojKnjiga;
    private List<Ocena> ocene;
    private double prosecnaOcena;
    private Bibliotekar bibliotekar;

    public Knjiga() {
    }

    
    
    public Knjiga(String naslov, String autor, String izdavac, Long isbn, String jezik, String opis, int brojStrana, int ukupanBrojKnjiga, int raspolozivBrojKnjiga, double prosecnaOcena, Bibliotekar bibliotekar) {
        
        this.naslov = naslov;
        this.autor = autor;
        this.izdavac = izdavac;
        this.isbn = isbn;
        this.jezik = jezik;
        this.opis = opis;
        this.brojStrana = brojStrana;
        this.ukupanBrojKnjiga = ukupanBrojKnjiga;
        this.raspolozivBrojKnjiga = raspolozivBrojKnjiga;
        this.prosecnaOcena = prosecnaOcena;
        this.bibliotekar = bibliotekar;
        this.ocene = new ArrayList<>();
    }

    
    
    

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public int getUkupanBrojKnjiga() {
        return ukupanBrojKnjiga;
    }

    public void setUkupanBrojKnjiga(int ukupanBrojKnjiga) {
        this.ukupanBrojKnjiga = ukupanBrojKnjiga;
    }

    public int getRaspolozivBrojKnjiga() {
        return raspolozivBrojKnjiga;
    }

    public void setRaspolozivBrojKnjiga(int raspolozivBrojKnjiga) {
        this.raspolozivBrojKnjiga = raspolozivBrojKnjiga;
    }

    public List<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(List<Ocena> ocene) {
        this.ocene = ocene;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }
    
    
    
}
