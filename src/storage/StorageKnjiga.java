/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Knjiga;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikola
 */
public interface StorageKnjiga {
    
    List<Knjiga> getAll();
    Knjiga save(Knjiga knjiga) throws SQLException;
}
