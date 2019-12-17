/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Knjiga;
import domain.Ocena;
import java.util.List;

/**
 *
 * @author Nikola
 */
public interface StorageOcena {
    Ocena save(Ocena ocena);
    List<Ocena> getAll(Knjiga knjiga);
}
