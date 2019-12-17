/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Rezervacija;
import java.util.List;

/**
 *
 * @author Nikola
 */
public interface ServiceRezervacija {
    List<Rezervacija> getAll();
    Rezervacija save(Rezervacija rezervacija);
    Rezervacija update(Rezervacija rezervacija);
}
