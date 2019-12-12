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
public abstract class Nalog {
    
    private String korisnickoIme;
    private String sifra;
    private String imePrezime;
    private String email;
    private String JMBG;

    public Nalog() {
    }

    public Nalog(String korisnickoIme, String sifra, String imePrezime, String email, String JMBG) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.imePrezime = imePrezime;
        this.email = email;
        this.JMBG = JMBG;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }
    
    
}
