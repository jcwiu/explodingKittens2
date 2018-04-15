/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jenn
 */
abstract public class DeckAbstract {
    
    private ArrayList<Card> deck;

    public DeckAbstract(){
        deck = new ArrayList<>();
    }
    
    private void clear(){
        deck.clear();
    }
    
    public Card drawCard(){
        int atIndex = deck.size()-1;
        Card drawnCard = deck.get(atIndex);
        deck.remove(atIndex);
        return drawnCard;
    }
    
    public void addCard(Card card){
        deck.add(card);
    }
    
    //public void shuffle(){
    //    Collections.shuffle(deck);
    //}
    
    public int getSize(){
        return deck.size();
    }
    
    /*public Card peek(int i){
        int atIndex = deck.size()-(i+1);
        Card drawnCard = deck.get(atIndex);
        return drawnCard;
    }
    
    public void print(){
        Card cardToPeek;
        for (int i=0; i<getSize();i++){
            cardToPeek = peek(i);
            System.out.println("Card"+i+": "+cardToPeek.toString());
        }
    }*/
}
