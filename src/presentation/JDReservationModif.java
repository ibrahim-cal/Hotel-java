/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import beans.Chambre;
import beans.Client;
import beans.Planning;
import beans.Reservation;
import dao.ChambDao;
import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.PlanningDao;
import dao.ReservationDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class JDReservationModif extends javax.swing.JDialog {

    private ClientDao daoCli = DaoFactory.getInstance().getDAOClient();
    private ChambDao daoCh = DaoFactory.getInstance().getDAOChamb();
    private PlanningDao daoPl = DaoFactory.getInstance().getDAOPlanning();
    private ReservationDao daoRes = DaoFactory.getInstance().getDAOReservation();
    
    
    public JDReservationModif(java.awt.Frame parent, String titre, Reservation res) {
        super(parent, titre, true);
        initComponents();
        fillcomponents(res);
        getRootPane().setDefaultButton(jButtonok);
           
        setLocation(parent.getX()+parent.getWidth()/3, parent.getY()+parent.getHeight()/3);
         setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxNumCh = new javax.swing.JComboBox();
        jComboBoxDate = new javax.swing.JComboBox();
        jButtonok = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jComboBoxNbpers = new javax.swing.JComboBox();
        jComboBoxNom = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldResId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("nom");

        jLabel2.setText("num chambre");

        jLabel3.setText("date");

        jLabel4.setText("nb pers");

        jButtonok.setText("ok");
        jButtonok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonokActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jComboBoxNbpers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jComboBoxNom.setEnabled(false);

        jLabel6.setText("id res");

        jTextFieldResId.setEditable(false);
        jTextFieldResId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldResId, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxNom, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNumCh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(40, 40, 40)
                        .addComponent(jComboBoxNbpers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnnuler)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldResId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNumCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNbpers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonok)
                    .addComponent(jButtonAnnuler)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
            this.dispose();       
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonokActionPerformed
            
        
              Chambre ch = (Chambre)jComboBoxNumCh.getSelectedItem();
              int nbP = jComboBoxNbpers.getSelectedIndex() +1 ;        
        
           Reservation res = new Reservation();
        
         res.setRes_Id(Integer.parseInt(jTextFieldResId.getText()));
       // res.setResCli((Client)jComboBoxClId.getSelectedItem());
        res.setResCli((Client)jComboBoxNom.getSelectedItem());
        res.setResCh((Chambre)jComboBoxNumCh.getSelectedItem());
        res.setResPl((Planning)jComboBoxDate.getSelectedItem());
        res.setNbPers(Integer.parseInt(jComboBoxNbpers.getSelectedItem() + ""));
        
        try {
            
            if (  nbP <= ch.getCh_Couchage() )
            {
            daoRes.updateReservation(res);
             this.dispose();
            }
            else  
            {
            JOptionPane.showMessageDialog(this , "La chambre peut acceuillir maximum " + ch.getCh_Couchage()+ " personnes" ) ;
            }
            }
            
            catch (DaoException e) {
            JOptionPane.showMessageDialog(null,"Insertion impossible : il y a deja une reservation pour cette date et chambre, veuillez changer de date ou chambre" , "Avertissement",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
                                   }
        
        
        
    }//GEN-LAST:event_jButtonokActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDReservationModif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDReservationModif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDReservationModif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDReservationModif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDReservationModif dialog = new JDReservationModif(new javax.swing.JFrame(), "modification reservation", Reservation res);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        */        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonok;
    private javax.swing.JComboBox jComboBoxDate;
    private javax.swing.JComboBox jComboBoxNbpers;
    private javax.swing.JComboBox jComboBoxNom;
    private javax.swing.JComboBox jComboBoxNumCh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldResId;
    // End of variables declaration//GEN-END:variables

    private void fillcomponents(Reservation res) {
 
         jTextFieldResId.setText(Integer.toString(res.getRes_Id()));
        
       /*    int ClId = res.getResCli().getCl_Id();
           ArrayList <Client> listCli = daoCli.selectClient();
     
        for (int i=0;i<listCli.size();i++)
        {  
            jComboBoxClId.addItem(listCli.get(i));
           
            if (listCli.get(i).getCl_Id()== ClId)
               
            jComboBoxClId.setSelectedIndex(i);
         }
    */
     
              String nomCli = res.getResCli().getCl_Nom();
           ArrayList <Client> listNom = daoCli.selectClient();
     
        for (int i=0;i<listNom.size();i++)
        {  
            jComboBoxNom.addItem(listNom.get(i));
           
            if (listNom.get(i).getCl_Nom().equals(nomCli))
               
            jComboBoxNom.setSelectedIndex(i);
         }

   
                int numCh = res.getResCh().getCh_Num();
           ArrayList <Chambre> listCh = daoCh.selectChambres();
     
        for (int i=0;i<listCh.size();i++)
        {  
            jComboBoxNumCh.addItem(listCh.get(i));
           
            if (listCh.get(i).getCh_Num()== numCh)
               
            jComboBoxNumCh.setSelectedIndex(i);
         }
    
           
        int numPl = res.getResPl().getPl_Id();
          ArrayList <Planning> ListPlanning = daoPl.selectPlanning();
       
          for (int i=0;i<ListPlanning.size();i++)
          {
              jComboBoxDate.addItem(ListPlanning.get(i));
          
              if (ListPlanning.get(i).getPl_Id()== numPl)
               
            jComboBoxDate.setSelectedIndex(i);
          }
          
          jComboBoxNbpers.getSelectedIndex();
           
    }
}
