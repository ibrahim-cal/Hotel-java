
package presentation;

import beans.Client;
import beans.Pays;
import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.PaysDao;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class JDClientInsert extends javax.swing.JDialog {
   
    private ClientDao cliDao = DaoFactory.getInstance().getDAOClient();
    private PaysDao paysDao = DaoFactory.getInstance().getDAOPays();
    private int verif;
    
    public JDClientInsert(java.awt.Frame parent, boolean modal) {
        //super(parent, true);
        super(parent, "Insertion Client", modal);
        initComponents();
        fillcomponents();
        getRootPane().setDefaultButton(jButtonok);
           
        setLocation(parent.getX()+parent.getWidth()/3, parent.getY()+parent.getHeight()/3);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextFieldNom = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPrenom = new javax.swing.JFormattedTextField();
        jFormattedTextFieldAdresse = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCP = new javax.swing.JFormattedTextField();
        jFormattedTextFieldVille = new javax.swing.JFormattedTextField();
        jComboBoxPays = new javax.swing.JComboBox();
        jDateChooserNaiss = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonok = new javax.swing.JButton();
        jButtonannuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFormattedTextFieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldNomActionPerformed(evt);
            }
        });

        jFormattedTextFieldPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldPrenomActionPerformed(evt);
            }
        });

        jFormattedTextFieldCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPActionPerformed(evt);
            }
        });

        jFormattedTextFieldVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldVilleActionPerformed(evt);
            }
        });

        jLabel1.setText("nom (que des lettres)");

        jLabel2.setText("prenom (que des lettres)");

        jLabel3.setText("adresse");

        jLabel4.setText("cp (que des chiffres)");

        jLabel5.setText("ville (que des lettres)");

        jLabel6.setText("pays");

        jLabel7.setText("date naiss");

        jButtonok.setText("ok");
        jButtonok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonokActionPerformed(evt);
            }
        });

        jButtonannuler.setText("annuler");
        jButtonannuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonannulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jButtonok)
                .addGap(18, 18, 18)
                .addComponent(jButtonannuler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldCP)
                    .addComponent(jFormattedTextFieldVille)
                    .addComponent(jFormattedTextFieldPrenom)
                    .addComponent(jFormattedTextFieldAdresse)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jDateChooserNaiss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(jComboBoxPays, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonannuler)
                    .addComponent(jButtonok))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldNomActionPerformed
  
    }//GEN-LAST:event_jFormattedTextFieldNomActionPerformed

    private void jFormattedTextFieldCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPActionPerformed

        
    }//GEN-LAST:event_jFormattedTextFieldCPActionPerformed

    private void jButtonokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonokActionPerformed
             
      if     ((jFormattedTextFieldNom.getText().matches("[a-zA-Z]+")) && 
              (jFormattedTextFieldCP.getText().matches("[0-9]*"))   &&
              (jFormattedTextFieldPrenom.getText().matches("[a-zA-Z]+")) &&
              (jFormattedTextFieldVille.getText().matches("[a-zA-Z]+")))
      { 
        Client cli = new Client();
        cli.setCl_Nom(jFormattedTextFieldNom.getText());
        cli.setCl_Prenom(jFormattedTextFieldPrenom.getText());
        cli.setCl_Adresse(jFormattedTextFieldAdresse.getText());
        cli.setCl_CP(jFormattedTextFieldCP.getText());   
        cli.setCl_Ville(jFormattedTextFieldVille.getText());
        cli.setPaysCli((Pays)jComboBoxPays.getSelectedItem());
        cli.setCl_Naiss(jDateChooserNaiss.getDate());
        
        try {
          
            cliDao.insertClient(cli);
            
            } 
        
        catch (DaoException e) 
        {
            JOptionPane.showMessageDialog(null,"Insertion impossible ! \n" + e.getMessage(),"Avertissement",JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }
      else 
        {
             JOptionPane.showMessageDialog(this, "Veuillez verifier la validite des champs");
        }
                                    
    
    }//GEN-LAST:event_jButtonokActionPerformed

    private void jFormattedTextFieldPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPrenomActionPerformed
       
    }//GEN-LAST:event_jFormattedTextFieldPrenomActionPerformed

    private void jButtonannulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonannulerActionPerformed
        this.dispose();     
    }//GEN-LAST:event_jButtonannulerActionPerformed

    private void jFormattedTextFieldVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldVilleActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldVilleActionPerformed

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
            java.util.logging.Logger.getLogger(JDClientInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDClientInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDClientInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDClientInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDClientInsert dialog = new JDClientInsert(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonannuler;
    private javax.swing.JButton jButtonok;
    private javax.swing.JComboBox jComboBoxPays;
    private com.toedter.calendar.JDateChooser jDateChooserNaiss;
    private javax.swing.JFormattedTextField jFormattedTextFieldAdresse;
    private javax.swing.JFormattedTextField jFormattedTextFieldCP;
    private javax.swing.JFormattedTextField jFormattedTextFieldNom;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrenom;
    private javax.swing.JFormattedTextField jFormattedTextFieldVille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    private void fillcomponents() {
        
        ArrayList <Pays> listPays = paysDao.selectPays();
     
        for (int i=0;i<listPays.size();i++)
            
            jComboBoxPays.addItem(listPays.get(i));
         
        Date now = new Date();
        jDateChooserNaiss.setDate(now);
    }
}
