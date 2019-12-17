/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Knjiga;
import domain.Ocena;
import java.util.List;
import service.ServiceOcena;
import storage.StorageOcena;
import storage.database.DatabaseStorageOcena;

/**
 *
 * @author Nikola
 */
public class ServiceOcenaImpl implements ServiceOcena{

    private final StorageOcena storageOcena;

    public ServiceOcenaImpl() {
        this.storageOcena = new DatabaseStorageOcena();
    }
    
    @Override
    public Ocena save(Ocena ocena) {
        return storageOcena.save(ocena);
    }

    @Override
    public List<Ocena> getAll(Knjiga knjiga) {
        return storageOcena.getAll(knjiga);
    }
    
}
