/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import database.connection.ConnectionFactory;
import domain.Knjiga;
import domain.Korisnik;
import domain.Ocena;
import domain.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageOcena;

/**
 *
 * @author Nikola
 */
public class DatabaseStorageOcena implements StorageOcena{

    @Override
    public Ocena save(Ocena ocena) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "insert into ocena (isbn_knjige, korisnicko_ime_korisnika, konacna_ocena, opis)"
                    + "values (?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setLong(1, ocena.getKnjiga().getIsbn());
            preparedStatement.setString(2, ocena.getKorisnik().getKorisnickoIme());
            preparedStatement.setDouble(3, ocena.getOcena());
            preparedStatement.setString(4, ocena.getOpis());
            preparedStatement.executeUpdate();
            
            connection.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageOcena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ocena;
    }

    @Override
    public List<Ocena> getAll(Knjiga knjiga) {
        List<Ocena> lista = new ArrayList<>();
        
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "select o.isbn_knjige, o.konacna_ocena, o.opis, ko.korisnicko_ime, ko.sifra, ko.ime_prezime, ko.email"
                    + ", ko.jmbg, ko.status, ko.broj_aktivnih_iznajmljivanja from ocena o "
                    + "join korisnik ko on o.korisnicko_ime_korisnika = ko.korisnicko_ime "
                    + "where o.isbn_knjige = ?;";
            
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setLong(1, knjiga.getIsbn());
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Double ocena = rs.getDouble("o.konacna_ocena");
                String opis = rs.getString("o.opis");
                
                //Korisnik
                String korisnickoImeKorisnika = rs.getString("ko.korisnicko_ime");
                String sifraKorisnika = rs.getString("ko.korisnicko_ime");
                String imePrezimeKorisnika = rs.getString("ko.ime_prezime");
                String emailKorisnika = rs.getString("ko.email");
                String jmbgKorisnika = rs.getString("ko.jmbg");
                Status statusKorisnika = Status.valueOf(rs.getString("ko.status"));
                int brojAktivnihIznajmljivanja = rs.getInt("ko.broj_aktivnih_iznajmljivanja");
                
                Korisnik korisnik = new Korisnik(statusKorisnika, brojAktivnihIznajmljivanja, korisnickoImeKorisnika, sifraKorisnika, imePrezimeKorisnika, emailKorisnika, jmbgKorisnika);
                
                Ocena o = new Ocena(ocena, opis, knjiga, korisnik);
                
                lista.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageOcena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
