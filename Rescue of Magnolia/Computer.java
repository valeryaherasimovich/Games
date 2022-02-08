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
public class Computer
{
	private BufferedImage computer = null;
	private int x;
	private int y;
	public Computer(String picture, int x, int y)
	{
		this.x = x;
		this.y = y;
		try
        {
        	computer = ImageIO.read(new File(picture));
        }
        catch(IOException ex)
        {}
	}
	public void drawComputer(Graphics g)
	{
        g.drawImage(computer, x, y, null); 
	}
}