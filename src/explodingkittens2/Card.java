/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import javax.swing.JPanel;

/**
 *
 * @author Jenn
 */
public class Card {
    private String typeString;
    private int type, count; //type and count uniquely id the card
    private String imageName; 
    private CardButton cardButton; //button to "hold" card
    
    private String[] types={"diffuse","explode","nope","STF","attack","skip","favor","shuffle","cat","cat1","cat2","cat3","cat4"};
    
    public Card(int type, int count){
        this.type=type;
        this.count=count;
        typeString = types[type];
        imageName = "/images/cards/"+types[type]+".png";
        cardButton = new CardButton(types[type],count);
    }
    
    //Class get methods
    public int getType(){
        return type;
    }
    
    public int getCount(){
        return count;
    }
    
    public String getImage(){
        return imageName;
    }
    
    public CardButton getCardButton(){
        return cardButton;
    }
    
    public void loadCardButtonTo(JPanel scrollerPanel){
        cardButton.addButton(scrollerPanel);
    }
    
    
    //String method
    @Override
    public String toString(){
        return typeString;
    }
    
}
