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
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Boss
{
    int x;
    int y;
    int width;
    int height;
    boolean visible;
    boolean collision = false;
    BufferedImage img = null;
    boolean moveUp;
    int bossLives = 5;
    public Boss(int x, int y)
    {
        this.x = x;
        this.y = y;  
        this.width = 317;
        this.height = 254;
        visible = true; 
        moveUp = false;
        try
        	{
        		img = ImageIO.read(new File("BossE.png"));
        	}
        	catch(IOException ex)
        	{}
    }
    public void drawBoss(Graphics g)
    {
        if( visible )
        {
        	g.drawImage(img, 500, y, null);
        }
        if(bossLives == 0)
    	{
    		try
        	{
        		img = ImageIO.read(new File("GameOver.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 0, 0, null);
        	Font font = new Font("Plantagenet Cherokee",Font.PLAIN,85);
 			g.setFont(font);
        	Color white = new Color(255,255,255);
       		g.setColor(white);
        	g.drawString("Game Over",150,300);
    	}
    }
    public void checkCollision(Ball b)
    {
    	if( visible == true && b.getVisible() == true)
    	{
    		System.out.println(visible);
    		int bX = b.getX();
    		int bY = b.getY();
    		int bWidth = b.getWidth();
    		int bHeight = b.getHeight();
    		if( bX + bWidth >= x && bX <= x + width 
                && bY + bHeight >= y && bY <= y + height )
    		{
    			collision = true;
    			bossLives = bossLives - 1;
    			playCannon();
    			b.reset();	
    		}
    		if(bossLives == 0)
    		{
    			visible = false;
    		}
    	}
    }
    public void playCannon()
	{
	 	try
	 	{
			URL url = this.getClass().getClassLoader().getResource("cannon.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
	 	}
	 	catch (Exception exc)
	 	{
		 	exc.printStackTrace(System.out);
	 	}
	}
    public int getBossLives()
    {
    	return bossLives;
    }
    public void move()
    {
    	if(moveUp == false)
    	{
    		y +=2;
    	}
    	else
    	{
    		y -=2;
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
}