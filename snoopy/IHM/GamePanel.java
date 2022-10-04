package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
//https://zetcode.com/javagames/snake/
public class GamePanel extends JPanel{
    public GamePanel() {
        super();
        this.setUp();
    }
    
    private void setUp(){
        GridLayout e = new GridLayout(9,9);
        this.setLayout(e);
        File pic = new File("../galery/dog.jpeg");
        ImageIcon r = new ImageIcon("../galery/dog.jpeg");

        for(int i = 0;i<(9*9);i++){
            JLabel x = new JLabel("i: "+i);
            BufferedImage myPicture = null;
            try {
                
                myPicture = ImageIO.read(new File("galery/dog2.jpg"));//path start form the package?
                
                ImageResizer.resize("galery/dog copy.jpeg", "galery/R.jpeg", 0.5);
 
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            add(picLabel);
            this.createImage(i, i);
        }
        
        this.setBorder(BorderFactory.createLineBorder(Color.black, 5));

    }
    //https://stackoverflow.com/questions/9417356/bufferedimage-resize
    
      
}
