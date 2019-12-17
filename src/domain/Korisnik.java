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
public class Korisnik extends Nalog{
    
    private Status status;
    private int brojAktivnihIznajmljivanja;

    public Korisnik() {
    }

    public Korisnik(Status status, int brojAktivnihIznajmljivanja, String korisnickoIme, String sifra, String imePrezime, String email, String JMBG) {
        super(korisnickoIme, sifra, imePrezime, email, JMBG);
        this.status = status;
        this.brojAktivnihIznajmljivanja = brojAktivnihIznajmljivanja;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getBrojAktivnihIznajmljivanja() {
        return brojAktivnihIznajmljivanja;
    }

    public void setBrojAktivnihIznajmljivanja(int brojAktivnihIznajmljivanja) {
        this.brojAktivnihIznajmljivanja = brojAktivnihIznajmljivanja;
    }
    
    
}
