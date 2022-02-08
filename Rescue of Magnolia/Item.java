import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Item 
{
    private String picture;
    private int x;
    private int y;
    private BufferedImage image = null;
    private String name;

    public Item(String name, String picture, int x, int y)
    {
        this.picture = picture;
        this.x = x;
        this.y = y;
        this.name = name;
        try
        {
            image = ImageIO.read(new File(picture));
        }
        catch(IOException ex)
        {}
    }
    
    public void drawItem(Graphics g)
    {
        
        g.drawImage(image, x, y, null);

    }
    
    public String getName()
    {
    	return name;
    }
}
