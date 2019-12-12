/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Knjiga;
import java.sql.SQLException;
import java.util.List;
import service.ServiceKnjiga;
import storage.database.DatabaseStorageKnjiga;
import storage.StorageKnjiga;

/**
 *
 * @author Nikola
 */
public class ServiceKnjigaImpl implements ServiceKnjiga{

    private StorageKnjiga storageKnjiga;

    public ServiceKnjigaImpl() {
        storageKnjiga = new DatabaseStorageKnjiga();
    }
    
    
    
    @Override
    public List<Knjiga> getAll() {
        return storageKnjiga.getAll();
    }

    @Override
    public Knjiga save(Knjiga knjiga) throws SQLException{
        return storageKnjiga.save(knjiga);
    }
    
}
