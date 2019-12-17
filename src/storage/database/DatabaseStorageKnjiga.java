/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import database.connection.ConnectionFactory;
import domain.Bibliotekar;
import domain.Knjiga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageKnjiga;

/**
 *
 * @author Nikola
 */
public class DatabaseStorageKnjiga implements StorageKnjiga {

    @Override
    public List<Knjiga> getAll() {
        List<Knjiga> knjige = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "select k.isbn, k.naslov, k.autor, k.izdavac, k.jezik, k.opis, k.broj_strana, k.ukupan_broj_knjiga"
                    + ", raspoloziv_broj_knjiga, k.prosecna_ocena, b.korisnicko_ime, b.sifra, b.ime_prezime, b.email"
                    + ", b.jmbg, b.sifra_zaposlenog, b.broj_telefona from knjiga k join bibliotekar b on k.vlasnik = b.korisnicko_ime";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
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
                String korisnickoIme = rs.getString("b.korisnicko_ime");
                String sifra = rs.getString("b.sifra");
                String imePrezime = rs.getString("b.ime_prezime");
                String email = rs.getString("b.email");
                String jmbg = rs.getString("b.jmbg");
                Long sifraZap = rs.getLong("b.sifra_zaposlenog");
                String brojTelefona = rs.getString("b.broj_telefona");

                Bibliotekar b = new Bibliotekar(sifraZap, brojTelefona, korisnickoIme, sifra, imePrezime, email, jmbg);
                Knjiga k = new Knjiga(naslov, autor, izdavac, isbn, jezik, opis, brojStrana, ukupanBrojKnjiga, raspolozivBrojKnjiga, prosecnaOcena, b);

                knjige.add(k);

            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageKnjiga.class.getName()).log(Level.SEVERE, null, ex);
        }

        return knjige;
    }

    @Override
    public Knjiga save(Knjiga knjiga) throws SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String upit = "insert into knjiga (isbn,naslov,autor,izdavac,jezik,opis,"
                + "broj_strana,ukupan_broj_knjiga,raspoloziv_broj_knjiga,prosecna_ocena,vlasnik)"
                + " values (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(upit);
        preparedStatement.setLong(1, knjiga.getIsbn());
        preparedStatement.setString(2, knjiga.getNaslov());
        preparedStatement.setString(3, knjiga.getAutor());
        preparedStatement.setString(4, knjiga.getIzdavac());
        preparedStatement.setString(5, knjiga.getJezik());
        preparedStatement.setString(6, knjiga.getOpis());
        preparedStatement.setInt(7, knjiga.getBrojStrana());
        preparedStatement.setInt(8, knjiga.getUkupanBrojKnjiga());
        preparedStatement.setInt(9, knjiga.getRaspolozivBrojKnjiga());
        preparedStatement.setDouble(10, knjiga.getProsecnaOcena());
        preparedStatement.setString(11, knjiga.getBibliotekar().getKorisnickoIme());
        preparedStatement.executeUpdate();

        connection.commit();
        preparedStatement.close();

        return knjiga;
    }

    @Override
    public Knjiga update(Knjiga knjiga) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "update knjiga set naslov = ?, autor = ?, izdavac = ?, jezik = ?, opis = ?,"
                    + " broj_strana = ?, ukupan_broj_knjiga = ?, raspoloziv_broj_knjiga = ?, ocena = ?, vlasnik = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setString(1, knjiga.getNaslov());
            preparedStatement.setString(2, knjiga.getAutor());
            preparedStatement.setString(3, knjiga.getIzdavac());
            preparedStatement.setString(4, knjiga.getJezik());
            preparedStatement.setString(5, knjiga.getOpis());
            preparedStatement.setInt(6, knjiga.getBrojStrana());
            preparedStatement.setInt(7, knjiga.getUkupanBrojKnjiga());
            preparedStatement.setInt(8, knjiga.getRaspolozivBrojKnjiga());
            preparedStatement.setDouble(9, knjiga.getProsecnaOcena());
            preparedStatement.setString(10, knjiga.getBibliotekar().getKorisnickoIme());
            preparedStatement.executeUpdate();
            
            connection.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageKnjiga.class.getName()).log(Level.SEVERE, null, ex);
        }

        return knjiga;
    }

    @Override
    public Knjiga delete(Knjiga knjiga) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String upit = "delete from knjiga where isbn = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setLong(1, knjiga.getIsbn());
            preparedStatement.executeUpdate();
            
            connection.commit();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseStorageKnjiga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return knjiga;
    }

}
