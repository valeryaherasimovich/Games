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
import java.util.ArrayList;

public class Character
{
	private BufferedImage character = null;
	private int x;
	private int y;
	private ArrayList<Attack1> attacks1;
	private ArrayList<Attack2> attacks2;
	private ArrayList<Attack3> attacks3;
	private ArrayList<Attack4> attacks4;
	
	public Character(int x, int y)
	{
		this.x = x;
		this.y = y;
		try
        {
        	character = ImageIO.read(new File("MainCharacter.jpg"));
        }
        catch(IOException ex)
        {}
        attacks1 = new ArrayList<Attack1>();
        attacks2 = new ArrayList<Attack2>();
        attacks3 = new ArrayList<Attack3>();
        attacks4 = new ArrayList<Attack4>();
	}
	
	public void drawCharacter(Graphics g)
	{
		g.drawImage(character, x, y, null); 
	}
	
	public ArrayList<Attack1> getAttacks1()
	{
		return attacks1;
	}
	
	public ArrayList<Attack2> getAttacks2()
	{
		return attacks2;
	}
	
	public ArrayList<Attack3> getAttacks3()
	{
		return attacks3;
	}
	
	public ArrayList<Attack4> getAttacks4()
	{
		return attacks4;
	}
	
	public void fire1()
    {
    	if(attacks1.size()<1)
    	{
    		attacks1.add(new Attack1(x+character.getWidth(null), y+character.getHeight(null)/2));
    	}
    }
    
    public void fire2()
    {
    	if(attacks2.size()<1)
    	{
    		attacks2.add(new Attack2(x+character.getWidth(null), y+character.getHeight(null)/2));
    	}	
    }
    
    public void fire3()
    {
    	if(attacks3.size()<1)
    	{
    		attacks3.add(new Attack3(x+character.getWidth(null), y+character.getHeight(null)/2));
    	}
    }
    
    public void fire4()
    {
    	if(attacks4.size()<1)
    	{
    		attacks4.add(new Attack4(x+character.getWidth(null), y+character.getHeight(null)/2));
    	}
    }
    
	public void moveLeft()
	{
		x-=5;
	}
	
	public void moveRight()
	{
		x+=5;
	}
	
	public void moveUp()
	{
		y-=5;
	}
	
	public void moveDown()
	{
		y+=5;
	}
	public int getX()
	{	
		return x;
	}
	public int getY()
	{
		return y;
	}
}
