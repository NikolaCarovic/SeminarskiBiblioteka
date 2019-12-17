/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import database.connection.ConnectionFactory;
import domain.Korisnik;
import domain.Status;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageKorisnik;

/**
 *
 * @author Nikola
 */
public class DatabaseStroageKorisnik implements StorageKorisnik{

    @Override
    public List<Korisnik> getAll() {
        List<Korisnik> lista = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "select * from korisnik";
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            while(rs.next()){
                String korisnickoIme = rs.getString("korisnicko_ime");
                String sifra = rs.getString("sifra");
                String imePrezime = rs.getString("ime_prezime");
                String email = rs.getString("email");
                String jmbg = rs.getString("jmbg");
                Status status = Status.valueOf(rs.getString("status"));
                int broj = rs.getInt("broj_aktivnih_iznajmljivanja");
                
                Korisnik k = new Korisnik(status, broj, korisnickoIme, sifra, imePrezime, email, jmbg);
                lista.add(k);
            }
            
            rs.close();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStroageKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return lista;
    }
    
}
