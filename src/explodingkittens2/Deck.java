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
public class Deck {
    
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
    }
    
    public void combineDecks(Deck regCards, Deck expCards, Deck diffCards){
        deck.addAll(regCards.getList());
        deck.addAll(expCards.getList());
        deck.addAll(diffCards.getList());
    }
    
    public void regularCardsInit(){ 
        int count;
        int cardType=2; //regular card types start at "2"
           
        //nope & see the future cards have 5 cards total each
        
        for (int i=0;i<=1;i++){
            for(count=0;count<=4;count++){
                Card card1 = new Card(cardType, count);
                deck.add(card1);
                //System.out.println("Type: "+cardType+", Count: "+count+", DeckSize: "+deck.size());
            }
            cardType++; //nope >> 2, STF >> 3
        }
        
        //attack, skip, favor, and shuffle cards have 4 cards total each
         for(int i=0;i<=3;i++){   
            for(count=0;count<=3;count++){
                Card card = new Card(cardType, count);
                deck.add(deck.size(),card);
                //System.out.println("Type: "+cardType+", Count: "+count+", DeckSize: "+deck.size());
            }
            cardType++; //attack >> 4, skip >> 5, favor >> 6, shuffle >> 7
         }
         catCardsInit();
        
    }
    
    public void expCardsInit(int playerCount){
        int count;
        int cardType=1;

        //exploding Kitten cards, number depends on playerCount (one less than players playing)
            for(count=0;count<=(playerCount-2);count++){
                Card card = new Card(cardType, count);
                deck.add(deck.size(),card);
                System.out.println("Type: "+cardType+", Count: "+count+", DeckSize: "+deck.size());
            }    
    }
    
    public void catCardsInit(){
        int count;
        int cardType=8;//cat cards

        //there are 5 different types of cat cards ( 
        //all types function the same, they simply have diff images.
        //there are 4 of each type
        for (int i=0;i<=4;i++){
            for(count=0;count<=4;count++){
                Card card = new Card(cardType, count);
                deck.add(deck.size(),card);
                //System.out.println("Type: "+cardType+", Count: "+count);
            }
            cardType++;
        }
    }
    
    public void diffCardsInit(int playerCount){
        int cardType=0; // diffuse cards are type "0"
        int count;
            
        //diffuse cards, number depends on playerCount
        //for two person game only 4 diffuse cards ( 2 in deck after dealing)
        //else number of diffuse cards is 6. (number in deck after dealing = 6-playerCount)
        if(playerCount == 2){
            for(count=0;count<=3;count++){
                Card card = new Card(cardType,count);
                deck.add(deck.size(),card);
                //System.out.println("Type: "+cardType+", Count: "+count);;
            }
        }else{
            for(count=0;count<=5;count++){
                Card card = new Card(cardType, count);
                deck.add(getSize(),card);
                //System.out.println("Type: "+cardType+", Count: "+count);
            }
        }
    }
    
    public void dealCards(int cardsDealt, ArrayList<Player> players){
        
        //for x players deal y cards to each from the deck
        ArrayList<Card> newHand;
        for (int j=0;j<players.size();j++){
            newHand = new ArrayList();
            
            int atIndex;
            for (int i=cardsDealt;i>0;i--){
                atIndex = deck.size()-1;
                
                Card cardDealt = deck.get(atIndex);
                newHand.add(cardDealt);
                deck.remove(atIndex);
            }
            System.out.println("\nplayer j: "+j);
            System.out.println("\n\nNEW HAND:"+newHand+"\n\n");
            Player tempPlayer = players.get(j);
            System.out.println(tempPlayer.getName());
            tempPlayer.setHand(newHand);
        }
    }
    
    
    public int chanceOfKitten(int kittenCounter){
        int chanceOfKitten=kittenCounter/deck.size();
        return chanceOfKitten;
    }
    
    public ArrayList getList(){
        return deck;
    }
    
    //////////////////////
    
    public void takeCard(Player player){
        player.addCard(drawCard());
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

    //@Override
    public int getSize(){
        return deck.size();
    }  
    
    
    //@Override
    public Card peek(int i){
        int atIndex = deck.size()-(i+1);
        Card drawnCard = deck.get(atIndex);
        return drawnCard;
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
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
