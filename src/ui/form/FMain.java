/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

/**
 *
 * @author Nikola
 */
public class FMain extends javax.swing.JFrame {

    /**
     * Creates new form FMain
     */
    public FMain() {
        initComponents();
        
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuKnjiga = new javax.swing.JMenu();
        jmenuNovaKnjiga = new javax.swing.JMenuItem();
        jmenuPretraziKnjige = new javax.swing.JMenuItem();
        jmenuRezervacija = new javax.swing.JMenu();
        jmenuNovaRezervacija = new javax.swing.JMenuItem();
        jmenuPretraziRezervacije = new javax.swing.JMenuItem();
        jmenuNalog = new javax.swing.JMenu();
        jmenuOdjaviSe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmenuKnjiga.setText("Knjiga");

        jmenuNovaKnjiga.setText("Nova Knjiga");
        jmenuKnjiga.add(jmenuNovaKnjiga);

        jmenuPretraziKnjige.setText("Pretrazi Knjige");
        jmenuKnjiga.add(jmenuPretraziKnjige);

        jMenuBar1.add(jmenuKnjiga);

        jmenuRezervacija.setText("Rezervacija");

        jmenuNovaRezervacija.setText("Nova Rezervacija");
        jmenuRezervacija.add(jmenuNovaRezervacija);

        jmenuPretraziRezervacije.setText("Pretrazi Rezervacije");
        jmenuPretraziRezervacije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuPretraziRezervacijeActionPerformed(evt);
            }
        });
        jmenuRezervacija.add(jmenuPretraziRezervacije);

        jMenuBar1.add(jmenuRezervacija);

        jmenuNalog.setText("Nalog");

        jmenuOdjaviSe.setText("Odjavi se");
        jmenuNalog.add(jmenuOdjaviSe);

        jMenuBar1.add(jmenuNalog);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuPretraziRezervacijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuPretraziRezervacijeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmenuPretraziRezervacijeActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenuKnjiga;
    private javax.swing.JMenu jmenuNalog;
    private javax.swing.JMenuItem jmenuNovaKnjiga;
    private javax.swing.JMenuItem jmenuNovaRezervacija;
    private javax.swing.JMenuItem jmenuOdjaviSe;
    private javax.swing.JMenuItem jmenuPretraziKnjige;
    private javax.swing.JMenuItem jmenuPretraziRezervacije;
    private javax.swing.JMenu jmenuRezervacija;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }
}