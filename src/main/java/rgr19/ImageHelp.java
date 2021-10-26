package rgr26;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ImageHelp extends JComponent{
    BufferedImage image;
    public ImageHelp(){

        try{
        	  image= ImageIO.read(new URL("https://sun9-28.userapi.com/impf/NKASrA_iAVsd0mDYJ4g8V1GXej0r328ezViuFQ/dK433C-sGxA.jpg?size=2560x1275&quality=96&sign=85788a4e004685598f798d4fda1f1da6&type=album"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void paint(Graphics g){
    	
   	 if(image==null) return;
        g.drawImage(image,0, 0,200,100, null);      
    }
 
}

