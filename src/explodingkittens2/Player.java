/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 *
 * @author Jenn
 */
public class Player {
    private Hand playerHand;
    private String playerName;
    private String playerIcon;
    
    public Player(String playerName,String playerIcon){
        this.playerName = playerName;
        this.playerIcon = playerIcon;
        playerHand = new Hand();
    }
    
    //setter methods
    
    public void setHand(ArrayList<Card> newHand){
        //playerHand.setHandList(newHand);
        //Collections.copy(playerHand,newHand);
        playerHand.setHand(newHand);
        System.out.println("in player class, setPlayerHand");
    }
    
    
    public void peekThroughCards(){
        Card cardToPeek;
        for (int i=0; i<playerHand.getSize();i++){
            cardToPeek = playerHand.peek(i);
            System.out.println("Card"+i+": "+cardToPeek.toString());
        }
    }
    
    //getter methods
    public String getName(){
        return playerName;
    }
        
    public String getIcon(){
        return playerIcon;
    }
    
    public ArrayList<Card> getHand(){
        return playerHand.getHand();
    }
    
    //retrieve informations from other classes
    
    //Hand class
    public ArrayList getHandList(){
        return playerHand.getHand();
    }

    
    public int getCardCount(){
        return playerHand.getSize();       
    }
    
    public void loadCardButtons(JPanel scrollerPanel){
        for (int i=0;i<playerHand.getSize();i++){
            playerHand.getCardButton(i);
            scrollerPanel.add(playerHand.getCardButton(i));
            BoxLayout scrollerLayout;
            scrollerLayout = new BoxLayout(scrollerPanel, 0);
            scrollerPanel.setLayout(scrollerLayout);
       }
    }
}
 