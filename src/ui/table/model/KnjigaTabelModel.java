/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.table.model;

import domain.Knjiga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class KnjigaTabelModel extends AbstractTableModel{
    
    private final List<Knjiga> lista;
    private String[] columnNames = new String[]{"Naslov","Autor","Izdavac","ISBN","Jezik","Broj Strana","Raspoloziv broj","Ocena"};
    private Class[] columnClass = new Class[]{String.class, String.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Double.class};

    public KnjigaTabelModel(List<Knjiga> lista) {
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
        Knjiga knjiga = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return knjiga.getNaslov();
            case 1:
                return knjiga.getAutor();
            case 2:
                return knjiga.getIzdavac();
            case 3:
                return knjiga.getIsbn();
            case 4:
                return knjiga.getJezik();
            case 5:
                return knjiga.getBrojStrana();
            case 6:
                return knjiga.getRaspolozivBrojKnjiga();
            case 7:
                return knjiga.getProsecnaOcena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public void addKnjiga(Knjiga knjiga){
        lista.add(knjiga);
        fireTableDataChanged();
    }
    
    public Knjiga getKnjiga(int row){
        return lista.get(row);
    }
    
    public void removeKnjiga(int row){
        lista.remove(row);
        fireTableDataChanged();
    }
    
   
}
