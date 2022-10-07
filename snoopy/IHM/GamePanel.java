package IHM;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Tmp;

//https://zetcode.com/javagames/snake/
class GamePanel extends JPanel{
    Tmp t ;
    GamePanel(Tmp t) {
        super();
        this.t = t;
        this.setUp2();
    }
    
    private void setUp(){
        GridLayout e = new GridLayout(9,9);
        this.setLayout(e);
        //File pic = new File("../galery/dog.jpeg");
        //ImageIcon r = new ImageIcon("../galery/dog.jpeg");

        for(int i = 0;i<(9*9);i++){
            //JLabel x = new JLabel("i: "+i);
            BufferedImage myPicture = null;
            try {
                

                myPicture = ImageIO.read(new File("galery/RED.png"));//path start form the package?
                
 
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            //picLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));//bord de chaque image
            add(picLabel);
            this.createImage(i, i);
        }
        
        //this.setBorder(BorderFactory.createLineBorder(Color.black, 5));//bord du layout

    }
    
    private void setUp2(){
        int row = 2;
        int cols = 2;
        GridLayout e = new GridLayout(row,cols);
        this.setLayout(e);
        //File pic = new File("../galery/dog.jpeg");
        //ImageIcon r = new ImageIcon("../galery/dog.jpeg");
        
        for(int i = 0;i<(row*cols);i++){
            //JLabel x = new JLabel("i: "+i);
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File("galery/RED.png"));//path start form the package?
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                //picLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));//bord de chaque image
                add(picLabel);
                this.createImage(i, i);
            } catch (IOException e1) {
                e1.printStackTrace();
            }   
        }
    }
}
