/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Jenn
 */
public final class CardButton extends JToggleButton{

    private JToggleButton cardButton = new JToggleButton();
    
    public CardButton(String cardType, int count){
        //cardButton = spawnButton(cardType, count);
        cardButton=new JToggleButton();
    }
    
    //action performed by button
    private void cardHolderActionPerformed(java.awt.event.ActionEvent evt){
        System.out.println("CARD PRESSED IN HAND CLASS");
    }
    
    public void spawnButton(String cardType, int count){
        //JToggleButton cardButton = new JToggleButton();
        
        //basic button properties
        cardButton.setName(cardType+"_"+count);
        cardButton.setText(cardType+"_"+count);
        //ie names look like: diffuse_3 or cat3_4 
        cardButton.setPreferredSize(new Dimension(309, 223));
        
        cardButton.setMinimumSize(new Dimension(234, 223));
        cardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/"+cardType+".png")));
        cardButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/select.png")));
        cardButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/selected.png")));
        
        //more properties
        cardButton.setBackground(new java.awt.Color(0, 255, 0));
        cardButton.setFont(new java.awt.Font("AR CHRISTY", 1, 48));
        cardButton.setForeground(new java.awt.Color(255, 0, 0));
        cardButton.setAutoscrolls(true);
        cardButton.setBorder(null);
        cardButton.setBorderPainted(false);
        cardButton.setContentAreaFilled(false);
        cardButton.setFocusPainted(false);
        cardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cardButton.setSize(new Dimension(234, 223));
        //add action to button
        cardButton.addActionListener(this::cardHolderActionPerformed);
        //return cardButton;
    }
    
    
    public void addButton(JPanel scrollerPanel){
        scrollerPanel.add(cardButton);
    }
}
