/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Bibliotekar;
import java.util.List;
import service.ServiceBibliotekar;
import storage.StorageBibliotekar;
import storage.database.DatabaseStorageBibliotekar;

/**
 *
 * @author Nikola
 */
public class ServiceBibliotekarImpl implements ServiceBibliotekar{

    private final StorageBibliotekar storageBibliotekar;

    public ServiceBibliotekarImpl() {
        storageBibliotekar = new DatabaseStorageBibliotekar();
    }
    
    @Override
    public List<Bibliotekar> getAll() {
        return storageBibliotekar.getAll();
    }
    
}
