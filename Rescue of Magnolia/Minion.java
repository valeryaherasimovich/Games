import java.awt.Graphics;
import java.awt.Color;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.logging.Level;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.net.URL;

public class Minion
{
	private BufferedImage m1 = null;
	private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private boolean collision = false;
    private boolean moveUp;
	
	public Minion(String picture, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 100;
		visible = true; 
        moveUp = false;
		try
        {
        	m1 = ImageIO.read(new File(picture));
        }
        catch(IOException ex)
        {}
	}
	public void drawMinion(Graphics g)
	{
        if(visible)
        {
        	g.drawImage(m1, x, y, null);
        }
         
	}
	
	public boolean checkCollision(Attack a)
    {
    	if( visible == true && a.getVisible() == true)
    	{
    		int aX = a.getX();
    		int aY = a.getY();
    		int aWidth = a.getWidth();
    		int aHeight = a.getHeight();
    		if( aX + aWidth >= x && aX <= x + width && aY + aHeight >= y && aY <= y + height )
    		{
    			collision = true;
    			//visible = false;
    			return true;
    		}
    	}
    	return false;
    }
    
    public void move()
    {
    	if(moveUp == false)
    	{
    		y +=2;
    		x+=2;
    	}
    	else
    	{
    		y -=2;
    		x-=2;
    	}
    	if(y < 150)
    	{
    		moveUp = false;
    	}
    	else if(y > 350)
    	{
    		moveUp = true;
    	}
    }
    
    public void setVisible(boolean visible)
    {
    	this.visible = visible;
    }
    	
}