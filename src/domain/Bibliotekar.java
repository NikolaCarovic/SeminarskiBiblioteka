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
public class Bibliotekar extends Nalog{
    
    private Long sifraZaposlenog;
    private String brojTelefona;

    public Bibliotekar() {
    }

    

    public Bibliotekar(Long sifraZaposlenog, String brojTelefona, String korisnickoIme, String sifra, String imePrezime, String email, String JMBG) {
        super(korisnickoIme, sifra, imePrezime, email, JMBG);
        this.sifraZaposlenog = sifraZaposlenog;
        this.brojTelefona = brojTelefona;
    }

    public Long getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Long sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
    
    
}
