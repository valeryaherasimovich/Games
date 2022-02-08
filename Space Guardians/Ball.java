import java.awt.Graphics;
import java.awt.Color;
public class Ball
{
    double x;
    double y;
    double initX;
    double initY;
    double xVel;
    double yVel;
    double gravity;
    double time;
    double angle;
    double magnitude;
    boolean launch = false;
    boolean visible;
    int width;
    int height;
    Color white;
    public Ball(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.angle = 0;
        this.magnitude = 0;
        this.time = 0;
        this.xVel = 0;
        this.yVel = 0;
        this.gravity = -9.8;
        this.visible = true;
        this.width = 20;
        this.height = 20;
        white = new Color(255,255,255);
    }
    public void move()
    {
    	//System.out.println("Launch" + launch);
    	if(launch == true)
    	{
    		//x = yt + x0
    		x = xVel * time + initX;
    		//y = -.5gt ^ 2 - yt + y0 
    		y = -0.5*gravity*Math.pow(time,2) - yVel*time + initY;
    		if(y>600 || x>800)
    		{
    			launch = false;
    			x = initX;
    			y = initY;
    		}
    		time = time + .1;
    	}
    }
    public void setVelocity(double angle, double magnitude)
    {
    	this.angle = angle;
    	this.magnitude = magnitude;
    	this.xVel = this.magnitude * Math.cos( Math.toRadians(this.angle) );
    	this.yVel = this.magnitude * Math.sin( Math.toRadians(this.angle) );
    }
    public void launch()
    {
    	//System.out.println("SettingLaunchTrue");
    	launch = true;
    	time = 0;
    }
    public void drawMe(Graphics g)
    {
        g.setColor(white);
        g.fillOval((int) Math.round(x), (int) Math.round(y), width, height);
    }
    public void InputAngle(int InputAngle)
    {
    	angle = InputAngle;
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
    public void setX(int x)
    {
    	this.x = x;
    }
    public void reset()
    {
    	System.out.println("reset ball");
    	launch = false;
    	x = initX;
    	y = initY;
    	time = 0;
    }
    public void setY(int y)
    {
    	this.y = y;
    }
}