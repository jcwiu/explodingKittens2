/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/**
 *
 * @author Jenn
 */
public class Hand /*extends DeckAbstract*/ extends ArrayList{
    
    private ArrayList<Card> playerHand;
    
    public Hand(){
        playerHand = new ArrayList<>();
        
    }
    
    public ArrayList<Card> getHand(){
        return playerHand;
    }
    
    public void addCard(Card card){
        playerHand.add(card);
    }
    
    public void setHand(ArrayList<Card> newHand){
        playerHand.addAll(newHand);
    }
    
    public CardButton getCardButton(int i){
        //return playerHand.get(i).getCardButton();
        return playerHand.get(i).getCardButton();
    }
    
    public void loadCardButtons(JPanel scrollerPanel){
        for(int i=0; i<playerHand.size();i++){
            Card tempCard = playerHand.get(i);
            tempCard.loadCardButtonTo(scrollerPanel);
        }
    }
    
    
    
    /////
    //@Override
    public int getSize(){
        return playerHand.size();
    }  
    
    
    //@Override
    public Card peek(int i){
        int atIndex = playerHand.size()-(i+1);
        Card drawnCard = playerHand.get(atIndex);
        return drawnCard;
    }
    
    public void shuffle(){
        Collections.shuffle(playerHand);
    }
    
    //@Override
    public void print(){
        Card cardToPeek;
        for (int i=0; i<getSize();i++){
            cardToPeek = peek(i);
            System.out.println("Card"+i+": "+cardToPeek.toString());
        }
    }
    
}
