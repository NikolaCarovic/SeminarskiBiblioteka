/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Knjiga;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import service.ServiceKnjiga;
import service.impl.ServiceKnjigaImpl;
import ui.form.FKnjiga;
import ui.form.FLogin;
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
    private boolean aktivanNalog;
    private ServiceKnjiga serviceKnjiga;

    public Controller() {
        aktivanNalog = false;
        serviceKnjiga = new ServiceKnjigaImpl();
    }
    
    
    
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public void formaNovaKnjiga(){
        view = new FKnjiga();
        view.setVisible(true);
    }
    
    public void formaPretraziKnjige(){
        view = new FPretraziKnjige();
        view.setVisible(true);
    }
    
    public void formaLogin(){
        view = new FLogin();
        view.setVisible(true);
    }
    
    public boolean validacija(String username, String password){
        return true;
    }

    public boolean isAktivanNalog() {
        return aktivanNalog;
    }
    
    public void omoguci(){
        aktivanNalog = true;
    }
    
    public void formaNovaRezervacija(){
        view = new FRezervacija();
        view.setVisible(true);
    }
    
    public void formaPretragaRezervacija(){
        view = new FPretraziRezervacije();
        view.setVisible(true);
    }
    
    public List<Knjiga> getAll(){
        return serviceKnjiga.getAll();
    }
    
    public Knjiga sacuvajKnjigu(Knjiga knjiga) throws SQLException{
        return serviceKnjiga.save(knjiga);
    }
}
