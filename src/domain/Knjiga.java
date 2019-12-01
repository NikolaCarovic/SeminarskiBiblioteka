/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author Nikola
 */
public class Knjiga {
    Long id;
    String naslov;
    String autor;
    String izdavac;
    int isbn;
    String jezik;
    String opis;
    int brojStrana;
    int ukupanBrojKnjiga;
    int raspolozivBrojKnjiga;
    List<Ocena> ocene;
    double prosecnaOcena;
    
}
