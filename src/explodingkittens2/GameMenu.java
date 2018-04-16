/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodingkittens2;

import java.util.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jenn
 */
public class GameMenu extends javax.swing.JFrame {
        
    /**
     * Creates new form StartMenu
     * @param playerCount
     */
    
    
    private int playerCount;
    private int playerTurnCount;
    private int whoIsPlayer=0;
    
    private Deck drawPileDeck = new Deck();
    private Deck discardPileDeck = new Deck();
    
    private Deck regCards = new Deck();
    private Deck expCards = new Deck();
    private Deck diffuseCards  = new Deck();
    private ArrayList<Player> players = new ArrayList();
    private ArrayList<JPanel> playerCards=new ArrayList();
    
    
    
    
    private double kittChance;
    private double kittCount;
    
    public GameMenu(ArrayList players)throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        this.players.addAll(players);
        playerCount=players.size();
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        //init and deal regular cards
        regCards.regularCardsInit();
        regCards.shuffle(); //shuffle for random hand
        regCards.dealCards(4,this.players);//deal regular cards
        
        //init and deal diffuse cards
        diffuseCards.diffCardsInit(playerCount);
        diffuseCards.dealCards(1,this.players);
        
        //init exploding Kitten cards
        expCards.expCardsInit(playerCount);
       
        //Players should have full starting decks
        //combine left over initialized decks into drawPileDeck
        drawPileDeck.combineDecks(regCards, expCards, diffuseCards);
        drawPileDeck.shuffle();
        
        //System.out.println("\nPRINTING REG DECK:");
        //regCards.print();
        System.out.println("\n\nDrawPile Size: "+drawPileDeck.getSize());
        
        initComponents();
        playerCards.add(playerCard1);
        playerCards.add(playerCard2);
        playerCards.add(playerCard3);
        
        kittCount=playerCount-1;
        calcKittChance();
        
        refreshGUI();
    }
    
    
    void performCardAction(Card card){
        int cardType=card.getType();
        
        //diffuse
        if(cardType==0){
            //do nothing?
            //aka autoplay diffuse cards when explodingKitt encountered
            
        }//exploding kitt
        else if(cardType==1){
        //check to see player count:
        //if playercount == 2, then other player is winner
        //if playercount > 2, remove player
        //re add explod kitt card
        //next player turn
            
        }//nope
        else if(cardType==2){
        //not implemented?
        
        }//STF
        else if(cardType==3){
        //remove card from hand & handPanel
        //add card to discard
        //peek top 3 cards from drawpile onto STF panel
        //set STF panel visible
        //wait for "ok" button to be pressed
        //disable visability of STF panel
        //remove cards from STF panel
        
            
        }//atttack
        else if(cardType==4){
        //set selected player 
            
        }//skip
        else if(cardType==5){
        
        }//favor
        else if(cardType==6){
        
        }//shuffle
        else if(cardType==7){
        //removecard from hand
        //add card to discard
        
        //shuffle drawpiledeck
            
        }//cat
        else if(cardType==8){
        
            
        }//cat1
        else if(cardType==9){
        
        }//cat2
        else if(cardType==10){
        
        }//cat3
        else if(cardType==11){
        
        }//cat4
        else if(cardType==12){
        
        }//default
        else{
        
        }
        
        
    
    }
    
    ///////////////////////////////////////
    
    public void refreshGUI(){
        playerCount=players.size();
        setCurrentPlayerCard();
        setPlayerCards();
    }
    
    
    public void calcKittChance(){
       // System.out.println(players.size());
        //System.out.println(kittCount);
        
        double drawPileSize = drawPileDeck.getSize();
        
        double kittChance2;
        kittChance=0;
        kittChance2=0;
        
        kittChance = choose(drawPileSize, kittCount);
        kittChance2 = choose(drawPileSize, playerCount);
        kittChance= kittChance/kittChance2;
        kittChance=kittChance * (playerCount-1);
        
        kittChanceLabel.setText(String.valueOf(new BigDecimal(String.valueOf(kittChance*100)).setScale(0, BigDecimal.ROUND_HALF_UP))+"%");   
    }
    
    public static double choose(double total, double choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return choose(total-1,choose-1)+choose(total-1,choose);
    }
    
    public void setCurrentPlayerCard(){
        currentPlayerLabel.setText(players.get(0).getName());
        currentPlayerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/"+players.get(0).getIcon() +".png")));
        currentPlayerCardCount.setText("cards: "+players.get(0).getHand().size());
        players.get(0).loadCardButtons(scroller);
    }
    
    public void setPlayerCards(){
        if(players.size()>=2){
        player1Icon.setText(players.get(1).getName());
        player1Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/"+players.get(1).getIcon()+".png")));
        player1CardCount.setText("cards: "+players.get(1).getHand().size());
        }
        
        if(players.size()>=3){
        player2Icon.setText(players.get(2).getName());
        player2Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/"+players.get(2).getIcon() +".png")));
        player2CardCount.setText("cards: "+players.get(2).getHand().size());
        }
        
        if(players.size()==4){
        player3Icon.setText(players.get(3).getName());
        player3Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/"+players.get(3).getIcon() +".png")));
        player3CardCount.setText("cards: "+players.get(3).getHand().size());
        }
    }
    
    ///////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endTurnButton = new javax.swing.JButton();
        startMenuButton = new javax.swing.JButton();
        kittChanceLabel = new javax.swing.JLabel();
        ticker = new javax.swing.JLabel();
        phase = new javax.swing.JLabel();
        currentPlayerCard = new javax.swing.JPanel();
        handScroller = new javax.swing.JScrollPane();
        scroller = new javax.swing.JPanel();
        currentPlayerCardCount = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        handBG = new javax.swing.JLabel();
        currentPlayerLabel = new javax.swing.JLabel();
        currentPlayerIcon = new javax.swing.JButton();
        playerCard1 = new javax.swing.JPanel();
        player2Icon = new javax.swing.JButton();
        player2CardCount = new javax.swing.JLabel();
        playerCard2 = new javax.swing.JPanel();
        player3Icon = new javax.swing.JButton();
        player3CardCount = new javax.swing.JLabel();
        playerCard3 = new javax.swing.JPanel();
        player1Icon = new javax.swing.JButton();
        player1CardCount = new javax.swing.JLabel();
        deckButton = new javax.swing.JButton();
        discardDeckButton = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 755));
        setMinimumSize(new java.awt.Dimension(1280, 755));
        setPreferredSize(new java.awt.Dimension(1280, 755));
        setResizable(false);
        getContentPane().setLayout(null);

        endTurnButton.setFont(new java.awt.Font("AR CHRISTY", 1, 36)); // NOI18N
        endTurnButton.setForeground(new java.awt.Color(255, 51, 51));
        endTurnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/buttonBG.png"))); // NOI18N
        endTurnButton.setText("END");
        endTurnButton.setBorderPainted(false);
        endTurnButton.setContentAreaFilled(false);
        endTurnButton.setFocusPainted(false);
        endTurnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        endTurnButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        endTurnButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        endTurnButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        endTurnButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        endTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(endTurnButton);
        endTurnButton.setBounds(170, 640, 185, 80);

        startMenuButton.setFont(new java.awt.Font("AR CHRISTY", 1, 24)); // NOI18N
        startMenuButton.setForeground(new java.awt.Color(102, 102, 102));
        startMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/buttonBG.png"))); // NOI18N
        startMenuButton.setText("BACK");
        startMenuButton.setBorderPainted(false);
        startMenuButton.setContentAreaFilled(false);
        startMenuButton.setFocusPainted(false);
        startMenuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startMenuButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startMenuButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startMenuButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/pressedBG.png"))); // NOI18N
        startMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startMenuButton);
        startMenuButton.setBounds(0, 640, 160, 80);

        kittChanceLabel.setFont(new java.awt.Font("AR CHRISTY", 1, 24)); // NOI18N
        kittChanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kittChanceLabel.setText("CofKit");
        kittChanceLabel.setToolTipText("");
        kittChanceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(kittChanceLabel);
        kittChanceLabel.setBounds(1040, 630, 90, 30);

        ticker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/tickerSmall.png"))); // NOI18N
        getContentPane().add(ticker);
        ticker.setBounds(1010, 410, 270, 310);

        phase.setBackground(new java.awt.Color(51, 0, 0));
        phase.setFont(new java.awt.Font("AR CHRISTY", 1, 36)); // NOI18N
        phase.setForeground(new java.awt.Color(255, 255, 255));
        phase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phase.setText("ACTION PHASE");
        phase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        phase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        phase.setOpaque(true);
        getContentPane().add(phase);
        phase.setBounds(0, 670, 1280, 50);

        currentPlayerCard.setOpaque(false);
        currentPlayerCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        handScroller.setBackground(new java.awt.Color(0, 0, 0));
        handScroller.setBorder(null);
        handScroller.setForeground(new java.awt.Color(0, 0, 0));
        handScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        handScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        handScroller.setAutoscrolls(true);
        handScroller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        handScroller.setFont(new java.awt.Font("AR CHRISTY", 0, 18)); // NOI18N

        scroller.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scroller.setLayout(new javax.swing.BoxLayout(scroller, javax.swing.BoxLayout.LINE_AXIS));
        handScroller.setViewportView(scroller);

        currentPlayerCard.add(handScroller, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 500, 240));

        currentPlayerCardCount.setBackground(new java.awt.Color(255, 204, 51));
        currentPlayerCardCount.setFont(new java.awt.Font("AR CHRISTY", 0, 18)); // NOI18N
        currentPlayerCardCount.setForeground(new java.awt.Color(153, 153, 153));
        currentPlayerCardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentPlayerCardCount.setText("Cards: 31");
        currentPlayerCardCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        currentPlayerCardCount.setIconTextGap(0);
        currentPlayerCardCount.setInheritsPopupMenu(false);
        currentPlayerCard.add(currentPlayerCardCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 80, -1));

        infoLabel.setBackground(new java.awt.Color(0, 0, 0));
        infoLabel.setFont(new java.awt.Font("AR CHRISTY", 0, 14)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("Selected Info");
        infoLabel.setToolTipText("");
        infoLabel.setOpaque(true);
        currentPlayerCard.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 140, 20));

        handBG.setBackground(new java.awt.Color(0, 0, 0));
        handBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/handBG.png"))); // NOI18N
        handBG.setOpaque(true);
        currentPlayerCard.add(handBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 520, 260));

        currentPlayerLabel.setBackground(new java.awt.Color(204, 204, 204));
        currentPlayerLabel.setFont(new java.awt.Font("AR CHRISTY", 1, 24)); // NOI18N
        currentPlayerLabel.setForeground(new java.awt.Color(51, 51, 51));
        currentPlayerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentPlayerLabel.setText("PLAYER NAME");
        currentPlayerLabel.setToolTipText("");
        currentPlayerLabel.setOpaque(true);
        currentPlayerCard.add(currentPlayerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 220, -1));

        currentPlayerIcon.setFont(new java.awt.Font("AR CHRISTY", 1, 24)); // NOI18N
        currentPlayerIcon.setForeground(new java.awt.Color(255, 255, 255));
        currentPlayerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/chainSaw.png"))); // NOI18N
        currentPlayerIcon.setBorderPainted(false);
        currentPlayerIcon.setContentAreaFilled(false);
        currentPlayerIcon.setFocusPainted(false);
        currentPlayerIcon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        currentPlayerIcon.setIconTextGap(0);
        currentPlayerIcon.setMargin(new java.awt.Insets(0, 0, 0, 0));
        currentPlayerIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentPlayerIconActionPerformed(evt);
            }
        });
        currentPlayerCard.add(currentPlayerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 185, 150));

        getContentPane().add(currentPlayerCard);
        currentPlayerCard.setBounds(480, 0, 800, 320);

        playerCard1.setBackground(new java.awt.Color(51, 51, 51));
        playerCard1.setOpaque(false);

        player2Icon.setFont(new java.awt.Font("AR CHRISTY", 1, 20)); // NOI18N
        player2Icon.setForeground(new java.awt.Color(255, 255, 255));
        player2Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/avacado.png"))); // NOI18N
        player2Icon.setText("PLAYER NAME");
        player2Icon.setBorderPainted(false);
        player2Icon.setContentAreaFilled(false);
        player2Icon.setFocusPainted(false);
        player2Icon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        player2Icon.setIconTextGap(-40);
        player2Icon.setMargin(new java.awt.Insets(0, 0, 0, 0));
        player2Icon.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/avacado.png"))); // NOI18N
        player2Icon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/selectIcon.png"))); // NOI18N
        player2Icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2IconActionPerformed(evt);
            }
        });
        playerCard1.add(player2Icon);

        player2CardCount.setBackground(new java.awt.Color(51, 0, 0));
        player2CardCount.setFont(new java.awt.Font("AR CHRISTY", 0, 18)); // NOI18N
        player2CardCount.setForeground(new java.awt.Color(51, 0, 0));
        player2CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2CardCount.setText("[Cards: 3]");
        player2CardCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player2CardCount.setIconTextGap(0);
        player2CardCount.setInheritsPopupMenu(false);
        playerCard1.add(player2CardCount);

        getContentPane().add(playerCard1);
        playerCard1.setBounds(0, 240, 360, 190);

        playerCard2.setBackground(new java.awt.Color(51, 51, 51));
        playerCard2.setOpaque(false);

        player3Icon.setFont(new java.awt.Font("AR CHRISTY", 1, 20)); // NOI18N
        player3Icon.setForeground(new java.awt.Color(255, 255, 255));
        player3Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/nopeCat.png"))); // NOI18N
        player3Icon.setText("PLAYER NAME");
        player3Icon.setBorderPainted(false);
        player3Icon.setContentAreaFilled(false);
        player3Icon.setFocusPainted(false);
        player3Icon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        player3Icon.setIconTextGap(-40);
        player3Icon.setMargin(new java.awt.Insets(0, 0, 0, 0));
        player3Icon.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/nopeCat.png"))); // NOI18N
        player3Icon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/selectIcon.png"))); // NOI18N
        player3Icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3IconActionPerformed(evt);
            }
        });
        playerCard2.add(player3Icon);

        player3CardCount.setBackground(new java.awt.Color(51, 0, 0));
        player3CardCount.setFont(new java.awt.Font("AR CHRISTY", 0, 18)); // NOI18N
        player3CardCount.setForeground(new java.awt.Color(51, 0, 0));
        player3CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player3CardCount.setText("[Cards: 3]");
        player3CardCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player3CardCount.setIconTextGap(0);
        player3CardCount.setInheritsPopupMenu(false);
        playerCard2.add(player3CardCount);

        getContentPane().add(playerCard2);
        playerCard2.setBounds(0, 430, 360, 190);

        playerCard3.setBackground(new java.awt.Color(51, 51, 51));
        playerCard3.setOpaque(false);

        player1Icon.setFont(new java.awt.Font("AR CHRISTY", 1, 20)); // NOI18N
        player1Icon.setForeground(new java.awt.Color(255, 255, 255));
        player1Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/pugcorn.png"))); // NOI18N
        player1Icon.setText("PLAYER NAME");
        player1Icon.setBorderPainted(false);
        player1Icon.setContentAreaFilled(false);
        player1Icon.setFocusPainted(false);
        player1Icon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        player1Icon.setIconTextGap(-40);
        player1Icon.setMargin(new java.awt.Insets(0, 0, 0, 0));
        player1Icon.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/pugcorn.png"))); // NOI18N
        player1Icon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/playerIcons/selectIcon.png"))); // NOI18N
        player1Icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1IconActionPerformed(evt);
            }
        });
        playerCard3.add(player1Icon);

        player1CardCount.setBackground(new java.awt.Color(51, 0, 0));
        player1CardCount.setFont(new java.awt.Font("AR CHRISTY", 0, 18)); // NOI18N
        player1CardCount.setForeground(new java.awt.Color(51, 0, 0));
        player1CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1CardCount.setText("[Cards: 3]");
        player1CardCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        player1CardCount.setIconTextGap(0);
        player1CardCount.setInheritsPopupMenu(false);
        playerCard3.add(player1CardCount);

        getContentPane().add(playerCard3);
        playerCard3.setBounds(0, 50, 360, 190);

        deckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckInit.png"))); // NOI18N
        deckButton.setText("Deck");
        deckButton.setBorder(null);
        deckButton.setBorderPainted(false);
        deckButton.setContentAreaFilled(false);
        deckButton.setFocusPainted(false);
        deckButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deckButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckInit.png"))); // NOI18N
        deckButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckMess.png"))); // NOI18N
        deckButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckMess.png"))); // NOI18N
        deckButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckMess.png"))); // NOI18N
        deckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deckButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deckButton);
        deckButton.setBounds(440, 380, 290, 170);

        discardDeckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckBlankGray.png"))); // NOI18N
        discardDeckButton.setText("discardDeckButton");
        discardDeckButton.setBorderPainted(false);
        discardDeckButton.setContentAreaFilled(false);
        discardDeckButton.setFocusPainted(false);
        discardDeckButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        discardDeckButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckBlankDraw.png"))); // NOI18N
        discardDeckButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckBlankDraw.png"))); // NOI18N
        discardDeckButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckBlankDraw.png"))); // NOI18N
        discardDeckButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/deckBlankDraw.png"))); // NOI18N
        discardDeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardDeckButtonActionPerformed(evt);
            }
        });
        getContentPane().add(discardDeckButton);
        discardDeckButton.setBounds(730, 470, 250, 170);

        BG.setBackground(new java.awt.Color(255, 255, 255));
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/gameBG.png"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    ////////
    
    private void player1IconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1IconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player1IconActionPerformed

    private void player3IconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3IconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3IconActionPerformed

    private void player2IconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2IconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2IconActionPerformed

    private void discardDeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardDeckButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discardDeckButtonActionPerformed

    private void currentPlayerIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentPlayerIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentPlayerIconActionPerformed

    ////////
    private void startMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMenuButtonActionPerformed
        // TODO add your handling code here:
        StartMenu g = new StartMenu();
        g.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_startMenuButtonActionPerformed


    private void deckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deckButtonActionPerformed
        System.out.println("============================");
        System.out.println("CLICKED drawPile");
        for (int i=0;i<players.size();i++)
            System.out.println("playerArraylist: "+players.get(i).getName());
        
        Player tempPlayer = players.get(0);
        
        System.out.println(drawPileDeck.peek(0).getType()+drawPileDeck.peek(0).toString());
        
        //take a look at drawn card
        if (drawPileDeck.peek(0).getType()==1){
            if(playerCount==2){
                System.out.println(players.get(players.size()-1).getName());
                WinnerMenu w = new WinnerMenu(players.get(players.size()-1).getName());
                w.setVisible(true);
                this.setVisible(false);
            }else{
            
            //clean hand scroller of dead player's cards
            scroller.removeAll();
            scroller.revalidate();
            scroller.repaint();
            
            //remove dead player from players arraylist
             players.remove(players.get(0));
            
            //clean last player panel (where dead player would have rotated to)
            JPanel playerCardToRemove=playerCards.get(players.size()-2);
            playerCardToRemove.removeAll();
            playerCardToRemove.revalidate();
            playerCardToRemove.repaint();
            
           
            for (int i=0;i<players.size();i++)
            System.out.println("playerArraylist after explode: "+players.get(i).getName());
            }
        }else{
            drawPileDeck.takeCard(tempPlayer);
        }
        calcKittChance();
        refreshGUI();
        
         //for (int i=0;i<players.size();i++)
         //   System.out.println("playerArraylist at end of method: "+players.get(i).getName());
        System.out.println("");
    }//GEN-LAST:event_deckButtonActionPerformed

    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed
        // TODO add your handling code here:
        scroller.removeAll();
        scroller.revalidate();
        scroller.repaint();
        Collections.rotate(players, 1);
        calcKittChance();
        refreshGUI();
    }//GEN-LAST:event_endTurnButtonActionPerformed


    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JPanel currentPlayerCard;
    private javax.swing.JLabel currentPlayerCardCount;
    private javax.swing.JButton currentPlayerIcon;
    private javax.swing.JLabel currentPlayerLabel;
    private javax.swing.JButton deckButton;
    private javax.swing.JButton discardDeckButton;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JLabel handBG;
    private javax.swing.JScrollPane handScroller;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel kittChanceLabel;
    private javax.swing.JLabel phase;
    private javax.swing.JLabel player1CardCount;
    private javax.swing.JButton player1Icon;
    private javax.swing.JLabel player2CardCount;
    private javax.swing.JButton player2Icon;
    private javax.swing.JLabel player3CardCount;
    private javax.swing.JButton player3Icon;
    private javax.swing.JPanel playerCard1;
    private javax.swing.JPanel playerCard2;
    private javax.swing.JPanel playerCard3;
    private javax.swing.JPanel scroller;
    private javax.swing.JButton startMenuButton;
    private javax.swing.JLabel ticker;
    // End of variables declaration//GEN-END:variables






}
