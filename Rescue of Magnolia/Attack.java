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
public class Attack
{
    private int x;
    private int y;
    private boolean visible;
    private int width;
    private int height;
    private BufferedImage ball = null;
    private String picture;

    public Attack(String picture, int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.width = width;
        this.height = height;
        this.picture = picture;
        try
        {
        	ball = ImageIO.read(new File(picture));
        }
        catch(IOException ex)
        {}
    }
    public void drawAttack(Graphics g)
    {
        if(visible)
        {
        	g.drawImage(ball, x, y, null); 
        }
        
    }
    public void moveRight()
    {
    	x = x+5;
    	if(x>1000)
    	{
    		visible = false;
    	}
    }
    public void moveLeft()
    {
    	x = x-5;
    	if(x<0)
    	{
    		visible = false;
    	}
    }
    
    public boolean getVisible()
    {
    	return visible;
    }
    public int getWidth()
    {
    	return width;
    }
    public int getHeight()
    {
    	return height;
    }
    public int getX()
    {
    	return (int)x;
    }
    public int getY()
    {
    	return (int)y;
    }
    public void reset()
    {
    }
    public void setY(int y)
    {
    	this.y = y;
    }
}