/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.table.model;

import domain.Rezervacija;
import domain.StatusRezervacije;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class RezervacijaTableModel extends AbstractTableModel{

    private final List<Rezervacija> lista;
    private String[] columnNames = new String[]{"Knjiga","Korisnik","Status","Datum Od","Datum Do"};
    private Class[] columnClass = new Class[]{String.class, String.class, StatusRezervacije.class, Date.class, Date.class};

    public RezervacijaTableModel(List<Rezervacija> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija rez = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rez.getKnjiga().getNaslov();
            case 1:
                return rez.getKorisnik().getKorisnickoIme();
            case 2:
                return rez.getStatusRezervacije();
            case 3:
                return rez.getDatumOD();
            case 4:
                return rez.getDatumDo();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public void addRezervacija(Rezervacija rez){
        lista.add(rez);
        fireTableDataChanged();
    }
    
    
    
    
}
