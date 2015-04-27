/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Agenda1 extends javax.swing.JFrame {

    /**
     * Creates new form Agenda1
     */
    public Agenda1() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializarLista();
    }

    private void inicializarLista() {
        modeloLista = (DefaultListModel) lista.getModel();
        String fileName = "agenda.txt";
        File fichero = new File(fileName);
        if (fichero.exists() == false) {
            JOptionPane.showMessageDialog(this, "El fichero agenda.txt no existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                BufferedReader agenda = new BufferedReader(new FileReader(fichero));
                String nombre, direccion;
                int telefono;
                Entrada e;
                nombre = agenda.readLine();
                modeloLista.clear();
                while (nombre != null) {
                    direccion = agenda.readLine();
                    telefono = Integer.parseInt(agenda.readLine());
                    e = new Entrada(nombre, direccion, telefono);
                    modeloLista.addElement(e);
                    nombre = agenda.readLine();
                }
                agenda.close();
            } catch (IOException e) {

            }
        }
    }//

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");

        lista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lista.setModel(new DefaultListModel());
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lista);

        btnVer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEntrada(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verEntrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEntrada
        Entrada e = (Entrada) lista.getSelectedValue();
        String datos = "Nombre   =" + e.getNombre() + "\n";
        datos = datos + "Direccion=" + e.getDireccion() + "\n";
        datos = datos + "Teléfono =" + e.getTelefono() + "\n";
        JOptionPane.showMessageDialog(this, datos, "Ver entrada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_verEntrada

    

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
            java.util.logging.Logger.getLogger(Agenda1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel modeloLista;

}
