
package presentation;

import dao.DaoFactory;
import beans.Reservation;
import beans.Chambre;
import beans.Client;
import dao.*;
import javax.swing.*;
import java.util.*;

public class JIFReservation extends javax.swing.JInternalFrame {

   private DaoFactory factory = DaoFactory.getInstance();
    private ReservationDao daoRes = factory.getDAOReservation();
    private ChambDao daoCh = factory.getDAOChamb();
    private TableModelReservation myResModel = new TableModelReservation(daoRes.selectReservation());
    
    public JIFReservation() {
        initComponents();
        fillComponents();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRes = new JTable (myResModel);
        jComboBoxNum = new javax.swing.JComboBox();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jFormattedTextFieldFiltreNom = new javax.swing.JFormattedTextField();
        jRadioButtonCh = new javax.swing.JRadioButton();
        jRadioButtonCli = new javax.swing.JRadioButton();
        jRadioButtonDate = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonAucun = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Reservation"));
        setVisible(true);

        jScrollPane1.setViewportView(jTableRes);

        jComboBoxNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNumActionPerformed(evt);
            }
        });

        jButtonAjouter.setText("ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setText("modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jFormattedTextFieldFiltreNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFiltreNomActionPerformed(evt);
            }
        });

        jRadioButtonCh.setText("chambre");
        jRadioButtonCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonChActionPerformed(evt);
            }
        });

        jRadioButtonCli.setText("nom");
        jRadioButtonCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCliActionPerformed(evt);
            }
        });

        jRadioButtonDate.setText("date");

        jLabel1.setText("FILTRE :");

        jRadioButtonAucun.setText("aucun");
        jRadioButtonAucun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAucunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonAucun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCh)
                    .addComponent(jComboBoxNum, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldFiltreNom, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonDate)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAjouter)
                .addGap(18, 18, 18)
                .addComponent(jButtonSupprimer)
                .addGap(18, 18, 18)
                .addComponent(jButtonModifier)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCh)
                    .addComponent(jRadioButtonCli)
                    .addComponent(jRadioButtonDate)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonAucun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldFiltreNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonModifier)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNumActionPerformed
        Chambre selectedCh = (Chambre)jComboBoxNum.getSelectedItem();
        myResModel.setMyList(daoRes.selectReservationParNumeroChambre(selectedCh.getCh_Num()));       
    
        
     
    }//GEN-LAST:event_jComboBoxNumActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        
         if (jTableRes.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null,"Sélectionnez d'abord une ligne svp ","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer la ligne reservation ID reservation n° " +
                    myResModel.getValueAt(jTableRes.convertRowIndexToModel(jTableRes.getSelectedRow()), 0) + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
                try {    
                    daoRes.deleteReservation((int)myResModel.getValueAt(jTableRes.convertRowIndexToModel(jTableRes.getSelectedRow()), 0));
                }
                catch (DaoException e) {
                    JOptionPane.showMessageDialog(null,"Suppression impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
                }
        }
        // après la suppression : rafraîchir les données en relisant la BD
        myResModel.setMyList(daoRes.selectReservation()); 
        
        
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
   
        
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDReservationInsert(parent, "insertion reservation");
        myResModel.setMyList(daoRes.selectReservation());     
        
        
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
 
              if (jTableRes.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord une ligne svp ","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            // renvoie l'objet client à passer en paramètre
            Reservation res = myResModel.getMyList(jTableRes.convertRowIndexToModel(jTableRes.getSelectedRow()));
                      
            // récupère la JFrame parente
            JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
           new JDReservationModif(parent, "modification reservation", res);
            
            // après la modification : rafraîchir les données en relisant la BD
            myResModel.setMyList(daoRes.selectReservation()); 
        }
    }                                               


        
     /*
    }//GEN-LAST:event_jButtonModifierActionPerformed
*/
    private void jFormattedTextFieldFiltreNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFiltreNomActionPerformed
       // Client selectedCli = (Client)jFormattedTextFieldFiltreNom.getSelectedText();
        myResModel.setMyList(daoRes.selectReservationParNom(jFormattedTextFieldFiltreNom.getSelectedText()));   
        
    }//GEN-LAST:event_jFormattedTextFieldFiltreNomActionPerformed

    private void jRadioButtonCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCliActionPerformed
        
        jComboBoxNum.setEnabled(false);
        jFormattedTextFieldFiltreNom.setEnabled(true);
        
        
    }//GEN-LAST:event_jRadioButtonCliActionPerformed

    private void jRadioButtonAucunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAucunActionPerformed
  
        jComboBoxNum.setEnabled(false);
        jFormattedTextFieldFiltreNom.setEnabled(false);
    
        myResModel.setMyList(daoRes.selectReservation());
        
    }//GEN-LAST:event_jRadioButtonAucunActionPerformed

    private void jRadioButtonChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonChActionPerformed
       
         jComboBoxNum.setEnabled(true);
  
         jFormattedTextFieldFiltreNom.setEnabled(false);
        
    }//GEN-LAST:event_jRadioButtonChActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxNum;
    private javax.swing.JFormattedTextField jFormattedTextFieldFiltreNom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonAucun;
    private javax.swing.JRadioButton jRadioButtonCh;
    private javax.swing.JRadioButton jRadioButtonCli;
    private javax.swing.JRadioButton jRadioButtonDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRes;
    // End of variables declaration//GEN-END:variables

    private void fillComponents() {
      
        ArrayList<Chambre> listeChambre = daoCh.selectChambres();
        listeChambre.add(0, new Chambre(-1)); 
        
        
        for (Chambre chamb : listeChambre) {
            jComboBoxNum.addItem(chamb);  
        }
       
    }


}

