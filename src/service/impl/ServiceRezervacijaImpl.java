/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Rezervacija;
import java.util.List;
import javax.imageio.spi.ServiceRegistry;
import service.ServiceRezervacija;
import storage.StorageRezervacija;
import storage.database.DatabaseStorageRezervacija;

/**
 *
 * @author Nikola
 */
public class ServiceRezervacijaImpl implements ServiceRezervacija{

    private final StorageRezervacija storageRezervacija;

    public ServiceRezervacijaImpl() {
        storageRezervacija = new DatabaseStorageRezervacija();
    }
    
    
    
    @Override
    public List<Rezervacija> getAll() {
        return storageRezervacija.getAll();
    }

    @Override
    public Rezervacija save(Rezervacija rezervacija) {
        return storageRezervacija.save(rezervacija);
    }

    @Override
    public Rezervacija update(Rezervacija rezervacija) {
        return storageRezervacija.update(rezervacija);
    }
    
}
