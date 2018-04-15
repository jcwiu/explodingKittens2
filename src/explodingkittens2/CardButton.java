package explodingkittens2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JToggleButton;

public class CardButton extends JToggleButton {
    
    //graphics vars
    private static final long serialVersionUID = 1L;
    private final Color circleColor = Color.BLACK;
    
    //actuall button attributes
    private final String cardType;
    private final int count;
    
    public CardButton(String cardType, int count) {
        //super(label);
        super("");
        
        //attributes set
        this.cardType=cardType;
        this.count=count;
        
        //basic button properties
        super.setName(cardType+"_"+count);
        super.setText(cardType);
        
        
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/"+cardType+".png")));
        super.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/select.png")));
        super.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/explodingkittens2/images/cards/selected.png")));
        
        
        //more properties
        super.setBackground(new java.awt.Color(0, 255, 0));
        super.setFont(new java.awt.Font("AR CHRISTY", 1, 48));
        super.setForeground(new java.awt.Color(255, 0, 0));
        super.setAutoscrolls(true);
        super.setBorder(null);
        super.setBorderPainted(false);
        super.setContentAreaFilled(false);
        super.setFocusPainted(false);
        super.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        
        super.setAlignmentY(0.5f);
        super.setAlignmentX(0.0f);

        
        //add action to button
        super.addActionListener(this::cardHolderActionPerformed);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension originalSize = super.getPreferredSize();
        int gap = (int) (originalSize.height * 0.2);
        int x = originalSize.width + gap;
        int y = gap;
        int diameter = originalSize.height - (gap * 2);

        g.setColor(circleColor);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }

    ////////////
    
    //action performed by button
    private void cardHolderActionPerformed(java.awt.event.ActionEvent evt){
        System.out.println("CARD"+cardType+"_"+count+" PRESSED IN HAND CLASS");
    }

}