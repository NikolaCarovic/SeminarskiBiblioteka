/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Korisnik;
import java.util.List;
import service.ServiceKorisnik;
import storage.StorageKorisnik;
import storage.database.DatabaseStroageKorisnik;

/**
 *
 * @author Nikola
 */
public class ServiceKorisnikImpl implements ServiceKorisnik{

    private final StorageKorisnik storageKorisnik;
    
    

    public ServiceKorisnikImpl() {
        storageKorisnik = new DatabaseStroageKorisnik();
    }
    
    @Override
    public List<Korisnik> getAll() {
        return storageKorisnik.getAll();
    }
    
}
