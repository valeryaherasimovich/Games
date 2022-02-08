import java.awt.Graphics;
import java.awt.Color;
public class Obstacle
{
	int x;
	int y;
	int width;
	int height;
	Color white;
	boolean collision = false;
	boolean moveUp;
	public Obstacle(int x, int y)
	{
		this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 100;
        this.white = new Color(255,255,255); 
        boolean moveUp = true;
    }
    public void drawObstacle(Graphics g)
    {
    	//obstacle
        g.setColor(white);
        g.fillRect(x,y,width,height);
    }
    public boolean checkCollision(Ball b)
    {
    		int bX = b.getX();
    		int bY = b.getY();
    		int bWidth = b.getWidth();
    		int bHeight = b.getHeight();
    		if( bX + bWidth >= x && bX <= x + width 
                && bY + bHeight >= y && bY <= y + height )
    		{
    			return true;	
    		}
    		else
    		{
    			return false;
    		}
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
    	else if(y > 500)
    	{
    		moveUp = true;
    	}
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