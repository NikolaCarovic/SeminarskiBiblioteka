/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import database.connection.ConnectionFactory;
import domain.Bibliotekar;
import domain.Knjiga;
import domain.Korisnik;
import domain.Rezervacija;
import domain.Status;
import domain.StatusRezervacije;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageRezervacija;

/**
 *
 * @author Nikola
 */
public class DatabaseStorageRezervacija implements StorageRezervacija{

    @Override
    public List<Rezervacija> getAll() {
        List<Rezervacija> lista = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "select r.datum_od, r.datum_do, r.status, k.isbn, k.naslov, k.autor, k.izdavac, k.jezik, k.opis, k.broj_strana, k.ukupan_broj_knjiga"+
                    ", k.raspoloziv_broj_knjiga, k.prosecna_ocena, b.korisnicko_ime, b.sifra, b.ime_prezime, b.email"+
                    ", b.jmbg, b.sifra_zaposlenog, b.broj_telefona, ko.korisnicko_ime, ko.sifra, ko.ime_prezime, ko.email"
                    + ", ko.jmbg, ko.status, ko.broj_aktivnih_iznajmljivanja from rezervacija r "
                    + "join knjiga k on r.isbn_knjige = k.isbn join korisnik ko on r.korisnicko_ime_korisnika = ko.korisnicko_ime "
                    + "join bibliotekar b on k.vlasnik = b.korisnicko_ime";
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            while(rs.next()){
                //Rezervacija
                Date datum_od = rs.getDate("r.datum_od");
                Date datum_do = rs.getDate("r.datum_do");
                StatusRezervacije statusRezervacije = StatusRezervacije.valueOf(rs.getString("r.status"));
                
                //Knjiga
                Long isbn = rs.getLong("k.isbn");
                String naslov = rs.getString("k.naslov");
                String autor = rs.getString("k.autor");
                String izdavac = rs.getString("k.izdavac");
                String jezik = rs.getString("k.jezik");
                String opis = rs.getString("k.opis");
                int brojStrana = rs.getInt("k.broj_strana");
                int ukupanBrojKnjiga = rs.getInt("k.ukupan_broj_knjiga");
                int raspolozivBrojKnjiga = rs.getInt("k.raspoloziv_broj_knjiga");
                double prosecnaOcena = rs.getDouble("k.prosecna_ocena");
                
                //Bibliotekar
                String korisnickoImeBibliotekara = rs.getString("b.korisnicko_ime");
                String sifraBibliotekara = rs.getString("b.sifra");
                String imePrezimeBibliotekara = rs.getString("b.ime_prezime");
                String emailBibliotekara = rs.getString("b.email");
                String jmbgBibliotekara = rs.getString("b.jmbg");
                Long sifraZaposlenog = rs.getLong("b.sifra_zaposlenog");
                String brojTelefona = rs.getString("b.broj_telefona");
                
                Bibliotekar bibliotekar = new Bibliotekar(sifraZaposlenog, brojTelefona, korisnickoImeBibliotekara, sifraBibliotekara, imePrezimeBibliotekara, emailBibliotekara, jmbgBibliotekara);
                
                Knjiga knjiga = new Knjiga(naslov, autor, izdavac, isbn, jezik, opis, brojStrana, ukupanBrojKnjiga, raspolozivBrojKnjiga, prosecnaOcena, bibliotekar);
                
                //Korisnik
                String korisnickoImeKorisnika = rs.getString("ko.korisnicko_ime");
                String sifraKorisnika = rs.getString("ko.korisnicko_ime");
                String imePrezimeKorisnika = rs.getString("ko.ime_prezime");
                String emailKorisnika = rs.getString("ko.email");
                String jmbgKorisnika = rs.getString("ko.jmbg");
                Status statusKorisnika = Status.valueOf(rs.getString("ko.status"));
                int brojAktivnihIznajmljivanja = rs.getInt("ko.broj_aktivnih_iznajmljivanja");
                
                Korisnik korisnik = new Korisnik(statusKorisnika, brojAktivnihIznajmljivanja, korisnickoImeKorisnika, sifraKorisnika, imePrezimeKorisnika, emailKorisnika, jmbgKorisnika);
                
                
                Rezervacija rezervacija = new Rezervacija(datum_od, datum_do, statusRezervacije, knjiga, korisnik);
                
                lista.add(rezervacija);
            }
            
            rs.close();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }

    @Override
    public Rezervacija save(Rezervacija rezervacija) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "insert into rezervacija (isbn_knjige, korisnicko_ime_korisnika, datum_od, datum_do, status) "
                        + "values (?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setLong(1, rezervacija.getKnjiga().getIsbn());
            preparedStatement.setString(2, rezervacija.getKorisnik().getKorisnickoIme());
            preparedStatement.setDate(3, new Date(rezervacija.getDatumOD().getTime()));
            preparedStatement.setDate(4, new Date(rezervacija.getDatumDo().getTime()));
            preparedStatement.setString(5, String.valueOf(rezervacija.getStatusRezervacije()));
            preparedStatement.executeUpdate();
            
            connection.commit();
            preparedStatement.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rezervacija;
    }

    @Override
    public Rezervacija update(Rezervacija rezervacija) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "update rezervacija set datum_do = ?, status = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setDate(1, new Date(rezervacija.getDatumDo().getTime()));
            preparedStatement.setString(2, String.valueOf(rezervacija.getStatusRezervacije()));
            preparedStatement.executeUpdate();
            
            connection.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rezervacija;
    }
    
}
