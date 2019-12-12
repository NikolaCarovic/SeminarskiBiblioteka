/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Nikola
 */
public class Rezervacija {
    
    private Date datumOD;
    private Date datumDo;
    private StatusRezervacije statusRezervacije;
    private Knjiga knjiga;
    private Korisnik korisnik;

    public Rezervacija(Date datumOD, Date datumDo, StatusRezervacije statusRezervacije, Knjiga knjiga, Korisnik korisnik) {
        this.datumOD = datumOD;
        this.datumDo = datumDo;
        this.statusRezervacije = statusRezervacije;
        this.knjiga = knjiga;
        this.korisnik = korisnik;
    }

    public Date getDatumOD() {
        return datumOD;
    }

    public void setDatumOD(Date datumOD) {
        this.datumOD = datumOD;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public StatusRezervacije getStatusRezervacije() {
        return statusRezervacije;
    }

    public void setStatusRezervacije(StatusRezervacije statusRezervacije) {
        this.statusRezervacije = statusRezervacije;
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
