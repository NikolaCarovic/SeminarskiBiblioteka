/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Bibliotekar;
import domain.Knjiga;
import domain.Korisnik;
import domain.Nalog;
import domain.Ocena;
import domain.Rezervacija;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.ServiceBibliotekar;
import service.ServiceKnjiga;
import service.ServiceKorisnik;
import service.ServiceOcena;
import service.ServiceRezervacija;
import service.impl.ServiceBibliotekarImpl;
import service.impl.ServiceKnjigaImpl;
import service.impl.ServiceKorisnikImpl;
import service.impl.ServiceOcenaImpl;
import service.impl.ServiceRezervacijaImpl;
import ui.form.Acive;
import ui.form.FKnjiga;
import ui.form.FLogin;
import ui.form.FMain;
import ui.form.FPretraziKnjige;
import ui.form.FPretraziRezervacije;
import ui.form.FRezervacija;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;
    private JDialog view;
    private JFrame frame;
    private boolean aktivanNalog;
    private final ServiceKnjiga serviceKnjiga;
    private final ServiceRezervacija serviceRezervacija;
    private final ServiceKorisnik serviceKorisnik;
    private final ServiceBibliotekar serviceBibliotekar;
    private final ServiceOcena serviceOcena;
    private final Map<String, Object> mapa;

    public Controller() {
        aktivanNalog = false;
        serviceKnjiga = new ServiceKnjigaImpl();
        serviceRezervacija = new ServiceRezervacijaImpl();
        serviceKorisnik = new ServiceKorisnikImpl();
        serviceBibliotekar = new ServiceBibliotekarImpl();
        serviceOcena = new ServiceOcenaImpl();
        mapa = new HashMap<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void formaNovaKnjiga() {
        view = new FKnjiga();
        view.setVisible(true);
    }

    public void formaPretraziKnjige() {
        view = new FPretraziKnjige();
        view.setVisible(true);
    }

    public void formaLogin() {
        view = new FLogin();
        view.setVisible(true);
        //view.setFocusable(true);
    }

    public boolean validacija(String username, String password) {
        return true;
    }

    public boolean isAktivanNalog() {
        return aktivanNalog;
    }

    public void omoguci() {
        aktivanNalog = true;
    }
    
    public void formaMain2(){
        frame = new FMain(Acive.INACTIVE);
        frame.setVisible(true);
    }
    
    public void formaMain(){
        frame = new FMain(Acive.ACTIVE);
        frame.setVisible(true);
    }

    public void formaNovaRezervacija() {
        view = new FRezervacija();
        view.setVisible(true);
    }

    public void formaPretragaRezervacija() {
        view = new FPretraziRezervacije();
        view.setVisible(true);
    }

    public List<Knjiga> vratiKnjige() {
        return serviceKnjiga.getAll();
    }

    public Knjiga sacuvajKnjigu(Knjiga knjiga) throws SQLException {
        return serviceKnjiga.save(knjiga);
    }
    
    public Knjiga izmeniKnjigu(Knjiga knjiga){
        return serviceKnjiga.update(knjiga);
    }
    
    public Knjiga izbrisiKnjigu(Knjiga knjiga){
        return serviceKnjiga.delete(knjiga);
    }

    public List<Rezervacija> vratiRezervacije() {
        return serviceRezervacija.getAll();
    }

    public Rezervacija sacuvajRezervaciju(Rezervacija rezervacija) {
        return serviceRezervacija.save(rezervacija);
    }
    
    public Rezervacija izmeniRezervaciju(Rezervacija rezervacija){
        return serviceRezervacija.update(rezervacija);
    }

    public void activeUser(Nalog nalog) {
        mapa.put("active_user", nalog);
    }
    
    public void selectedItem(Object obj){
        mapa.put("selected_item", obj);
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public List<Korisnik> vratiSveKorisnike() {
        return serviceKorisnik.getAll();
    }

    public List<Bibliotekar> vratiSveBibliotekare() {
        return serviceBibliotekar.getAll();
    }
    
    public Ocena sacuvajOcenu(Ocena ocena){
        return serviceOcena.save(ocena);
    }
    
    public List<Ocena> vratiSveOceneDateKnjige(Knjiga knjiga){
        return serviceOcena.getAll(knjiga);
    }

    public boolean login(String username, String password) {
        boolean postoji = false;
        List<Korisnik> korisnici = serviceKorisnik.getAll();
        List<Bibliotekar> bibliotekari = serviceBibliotekar.getAll();
        for (Bibliotekar bibliotekar : bibliotekari) {
            if (bibliotekar.getKorisnickoIme().equals(username) && bibliotekar.getSifra().equals(password)) {
                postoji = true;
                getMapa().put("active_user", bibliotekar);
                return postoji;
            }
        }
        if (postoji == false) {
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(username) && korisnik.getSifra().equals(password)) {
                    postoji = true;
                    getMapa().put("active_user", korisnik);
                    return postoji;
                }
            }
        }
        return postoji;
    }
    
    public String postaviImeUsera(Object obj){
        if(obj instanceof Korisnik){
            Korisnik k = (Korisnik) obj;
            return k.getKorisnickoIme();
        } else if(obj instanceof Bibliotekar){
            Bibliotekar b = (Bibliotekar) obj;
            return b.getKorisnickoIme();
        }
        return "N/A";
    }

}
