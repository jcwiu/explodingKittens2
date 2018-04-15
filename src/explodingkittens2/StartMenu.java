/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
//
/**
 *
 * @author Jenn
 */
public class StartMenu extends javax.swing.JFrame {

    /**
     * Creates new form startMenu
     *///
    
    String[] playerNames = {"bob", "joe", "Anna", "Sarah"};
    String[] playerIcons = {"pugcorn","avacado","nopeCat","chainsaw" };
    ArrayList<Player> players = new ArrayList();
    int playerCount=playerNames.length;
    
    private void spawnPlayers(){
        for(int i=0;i<playerCount;i++){
           Player player = new Player(playerNames[i],playerIcons[i]);
           players.add(player);
       }
    }
    
    public StartMenu() {
        initComponents();
        spawnPlayers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setResizable(false);
        getContentPane().setLayout(null);

        startButton.setFont(new java.awt.Font("AR CHRISTY", 1, 28)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/buttonBG.png"))); // NOI18N
        startButton.setText("START");
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
        startButton.setBounds(980, 510, 150, 80);

        settingsButton.setFont(new java.awt.Font("AR CHRISTY", 1, 24)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/buttonBG.png"))); // NOI18N
        settingsButton.setText("SETTINGS");
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settingsButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        settingsButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        settingsButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        settingsButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(settingsButton);
        settingsButton.setBounds(980, 600, 150, 80);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/startMenu.png"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("\nSTART BUTTON PRESSED\n");
        GameMenu g;
        try {
            g = new GameMenu(players);
            g.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_startButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        // TODO add your handling code here:
        SettingsMenu g = new SettingsMenu();
        g.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_settingsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
