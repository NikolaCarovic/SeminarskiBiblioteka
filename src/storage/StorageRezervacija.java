/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Rezervacija;
import java.util.List;

/**
 *
 * @author Nikola
 */
public interface StorageRezervacija {
    List<Rezervacija> getAll();
    Rezervacija save(Rezervacija rezervacija);
    Rezervacija update(Rezervacija rezervacija);
}
