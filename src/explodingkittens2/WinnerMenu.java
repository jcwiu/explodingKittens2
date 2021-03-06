/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

//

import java.awt.Color;

/**
 *
 * @author Jenn
 */
public class WinnerMenu extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     * @param winnerName
     */

    
    public WinnerMenu(String winnerName) {
        
        initComponents();
        
        winnerLabel.setText(winnerName);
        winnerLabel.setForeground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winnerLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 755));
        setMinimumSize(new java.awt.Dimension(1280, 755));
        setPreferredSize(new java.awt.Dimension(1280, 755));
        setResizable(false);
        getContentPane().setLayout(null);

        winnerLabel.setFont(new java.awt.Font("AR DESTINE", 0, 72)); // NOI18N
        winnerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winnerLabel.setText("Sarah");
        getContentPane().add(winnerLabel);
        winnerLabel.setBounds(430, 220, 410, 70);

        startButton.setFont(new java.awt.Font("AR CHRISTY", 1, 28)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/buttonBG.png"))); // NOI18N
        startButton.setText("RESET");
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(1130, 630, 150, 80);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/winner3.png"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("\nSTART BUTTON PRESSED\n");
        StartMenu s = new StartMenu();
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WinnerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinnerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinnerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinnerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new WinnerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel winnerLabel;
    // End of variables declaration//GEN-END:variables
}
