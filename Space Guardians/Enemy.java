import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.logging.Level;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.net.URL;
public class Enemy
{
    int x;
    int y;
    int width;
    int height;
    Color blue;
    Color white;
    boolean visible;
    boolean collision = false;
    BufferedImage img = null;
    public Enemy(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 60;
        this.blue = new Color(9,0,255);
        this.white = new Color(255,255,255);   
        visible = true; 
    }
    public void drawEnemy(Graphics g)
    {
        if( visible )
        {
        	//enemy
        	//g.drawImage(img, 700, 300, null);
        	g.setColor(blue);
        	g.fillOval(x,y,width,height);
        	g.setColor(white);
        	g.fillOval(x+10,y+10,width-20,height-20);
        	g.setColor(blue);
        	g.fillOval(x+20,y+20,width-40,height-40);
        }
        /*
        else
        {
        	try
        	{
        		img = ImageIO.read(new File("Dead.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 700, 300, null);
        }
        */
    }
    public void checkCollision(Ball b)
    {
    	if( visible == true && b.getVisible() == true)
    	{
    		
    		int bX = b.getX();
    		int bY = b.getY();
    		int bWidth = b.getWidth();
    		int bHeight = b.getHeight();
    		if( bX + bWidth >= x && bX <= x + width 
                && bY + bHeight >= y && bY <= y + height )
    		{
    			System.out.println("collision");
    			visible = false;
    			collision = true;	
    		}
    	}
    }
    public boolean getVisible()
    {
    	return visible;
    }
    public boolean getCollision()
    {
    	return collision;
    }
    public void setCollision(boolean collision)
    {
    	this.collision = collision;
    }
    public void reset()
    {
    	visible = true;
    	collision = false;
    }
}