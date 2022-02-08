import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class Screen extends JPanel implements ActionListener, KeyListener
{
    int level;
    int score;
    int enemies;
    int projectiles;
    double time;
    Ball b1;
    Boss b2;
    JTextField angle;
    JTextField magnitude;
    JButton launch;
    JButton repeat;
    Enemy enemy;
    Obstacle obstacle;
    BufferedImage img = null;
    Enemy[] enemyArray;
    Obstacle[] obstacleArray;
    int y;
    boolean levelSwitch = false;
    boolean cheat = false;
    boolean repeatVisible;
    boolean visible;
    public Screen()
    {
        setLayout(null);
        addKeyListener(this);
        visible = true;
        repeatVisible = false;
        level = 1;
        score = 0;
        projectiles = 10;
        b1 = new Ball(50,500);
        b1.setVelocity(80,30);
        time = 200;
        
        //if(visible == true)
        //{
        	angle = new JTextField(4);
        	angle.setBounds(50,20,50,30);
        	add(angle);
        	magnitude = new JTextField(4);
        	magnitude.setBounds(200,20,50,30);
        	add(magnitude);
        	launch = new JButton("Launch");
        	launch.setBounds(250,20,100,30);
        	add(launch);
        	launch.addActionListener(this);
        //}
        //if(repeatVisible == true)
        //{
        	repeat = new JButton("Play Again");
        	repeat.setBounds(250,50,100,30);
        	add(repeat);
        	repeat.addActionListener(this);
        //}
        //else
        //{
        	//repeatVisible = false;
        //}
        enemy = new Enemy(700,300);
        b2 = new Boss(500, 300);
        if(level == 1)
        {
    		enemies = 4;
    		enemyArray = new Enemy[4];
        	for(int i = 0; i<enemyArray.length; i++)
        	{
        		enemyArray[i] = new Enemy(((int)(Math.random()*201 + 500)),((int)(Math.random()*301 + 200)));
        	}
        	obstacle = new Obstacle(200,500);
        	obstacleArray = new Obstacle[2];
        	int n = (int)(Math.random()*101 + 150);
        	for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i] = new Obstacle(n + i*(int)(Math.random()*51 + 100), 300);
        	}
        }
    }
    public Dimension getPreferredSize() 
    {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);   
        if(level == 1)
        {
        	try
        	{
        		img = ImageIO.read(new File("Level1.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 0, 0, null);
        	b1.drawMe( g );
        	Color white = new Color(255,255,255);
        	g.setColor(white);
        	visible = true;
        	g.drawString("Angle: ", 0, 38);
        	g.drawString("Magnitude: ", 120,38);
        	g.drawString("Level: " + level, 350, 38);
        	g.drawString("Score: " + score, 450, 38);
        	g.drawString("Enemies: " + enemies, 550, 38);
        	g.drawString("Projectiles: " + projectiles, 650, 38);
        	g.drawString("Time Left: " + (int)time, 650, 75);
        	try
        	{
        		img = ImageIO.read(new File("LaunchPad.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 30, 480, null);
        	for(int i = 0; i<enemyArray.length; i++)
        	{
        		enemyArray[i].drawEnemy(g);
        	}
        	for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i].drawObstacle(g);
        	}
        }
        /*
        if(projectiles == 0)
        {
        	level = 1;
        	projectiles = 10;
        	score = 0;
        }
        */
        if((enemies == 0 && score == 4) || (cheat == true && level == 1))
        {
        	level = 2;
        	projectiles = 10;
        	score = 0;
        	levelSwitch = true;
        	cheat = false;
        }
        if(level == 2)
        {
        	level = 2;
        	try
        	{
        		img = ImageIO.read(new File("Level2.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 0, 0, null);
        	if(levelSwitch)
        	{
        		enemies = 6;
        		enemyArray = new Enemy[6];
        		for(int i = 0; i<enemyArray.length; i++)
        		{
        			enemyArray[i] = new Enemy(((int)(Math.random()*201 + 500)),((int)(Math.random()*301 + 200)));
        		}
        		obstacle = new Obstacle(200,500);
        		obstacleArray = new Obstacle[3];
        		int n = (int)(Math.random()*101 + 150);
        		for(int i = 0; i<obstacleArray.length; i++)
        		{
        			obstacleArray[i] = new Obstacle(n + i*(int)(Math.random()*51 + 100), 300);
        		}
        		levelSwitch = false;
        	}
        	b1.drawMe( g );
        	Color white = new Color(255,255,255);
        	g.setColor(white);
        	visible = true;
        	g.drawString("Angle: ", 0, 38);
        	g.drawString("Magnitude: ", 120,38);
        	g.drawString("Level: " + level, 350, 38);
        	g.drawString("Score: " + score, 450, 38);
        	g.drawString("Enemies: " + enemies, 550, 38);
        	g.drawString("Projectiles: " + projectiles, 650, 38);
        	g.drawString("Time Left: " + (int)time, 650, 75);
        	try
        	{
        		img = ImageIO.read(new File("LaunchPad.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 30, 480, null);
        	for(int i = 0; i<enemyArray.length; i++)
        	{
        		enemyArray[i].drawEnemy(g);
        	}
        	for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i].drawObstacle(g);
        	}
        }
        /*
        if(projectiles == 0)
        {
        	level = 1;
        	projectiles = 10;
        	score = 0;
        }
        */
        if((enemies == 0 && score == 6) || (cheat == true && level == 2))
        {
        	level = 3;
        	projectiles = 10;
        	score = 0;
        	levelSwitch = true;
        	cheat = false;
        }
        if(level == 3)
        {
        	level = 3;
        	try
        	{
        		img = ImageIO.read(new File("Level3.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 0, 0, null);
        	if(levelSwitch)
        	{
        		enemies = 8;
        		enemyArray = new Enemy[8];
        		for(int i = 0; i<enemyArray.length; i++)
        		{
        			enemyArray[i] = new Enemy(((int)(Math.random()*201 + 500)),((int)(Math.random()*301 + 200)));
        		}
        		obstacle = new Obstacle(200,500);
        		obstacleArray = new Obstacle[4];
        		int n = (int)(Math.random()*51 + 150);
        		for(int i = 0; i<obstacleArray.length; i++)
        		{
        			obstacleArray[i] = new Obstacle(n + i*(int)(Math.random()*51 + 70), 300);
        		}
        		levelSwitch = false;	
        	}
        	b1.drawMe( g );
        	Color white = new Color(255,255,255);
        	g.setColor(white);
        	visible = true;
        	g.drawString("Angle: ", 0, 38);
        	g.drawString("Magnitude: ", 120,38);
        	g.drawString("Level: " + level, 350, 38);
        	g.drawString("Score: " + score, 450, 38);
        	g.drawString("Enemies: " + enemies, 550, 38);
        	g.drawString("Projectiles: " + projectiles, 650, 38);
        	g.drawString("Time Left: " + (int)time, 650, 75);
        	try
        	{
        		img = ImageIO.read(new File("LaunchPad.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 30, 480, null);
        	for(int i = 0; i<enemyArray.length; i++)
        	{
        		enemyArray[i].drawEnemy(g);
        	}
        	for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i].drawObstacle(g);
        	}
        }
        /*
        if(projectiles == 0)
        {
        	level = 1;
        	projectiles = 10;
        	score = 0;
        }
        */
        if((enemies == 0 && score == 8) || (cheat == true && level == 3))
        {
        	level = 4;
        	projectiles = 10;
        	score = 0;
        	levelSwitch = true;
        	cheat = false;
        }
        if(level == 4)
        {
        	level = 4;
        	//int bossLives = 5;
        	try
        	{
        		img = ImageIO.read(new File("Boss.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 0, 0, null);
        	if(levelSwitch)
        	{
        		obstacle = new Obstacle(200,500);
        		obstacleArray = new Obstacle[4];
        		int n = (int)(Math.random()*51 + 150);
        		for(int i = 0; i<obstacleArray.length; i++)
        		{
        			obstacleArray[i] = new Obstacle(n + i*(int)(Math.random()*51 + 70), 300);
        		}	
        		levelSwitch = false;	
        	}
        	b1.drawMe( g );
        	Color white = new Color(255,255,255);
        	g.setColor(white);
        	visible = true;
        	g.drawString("Angle: ", 0, 38);
        	g.drawString("Magnitude: ", 120,38);
        	g.drawString("Level: Boss Level", 350, 38);
        	g.drawString("Projectiles: " + projectiles, 480, 38);
        	g.drawString("Boss Lives: " + b2.getBossLives(), 610, 38);
        	g.drawString("Time Left: " + (int)time, 700, 38);
        	try
        	{
        		img = ImageIO.read(new File("LaunchPad.jpg"));
        	}
        	catch(IOException ex)
        	{}
        	g.drawImage(img, 30, 480, null);
        	b2.drawBoss(g);
        	for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i].drawObstacle(g);
        	}
        }
        /*
        if(projectiles == 0)
        {
        	level = 1;
        	projectiles = 10;
        	score = 0;
        }
        */
        int bossLives = 5;
        if((bossLives == 0) || (cheat == true && level == 4))
        {
        	level = 5;
        	levelSwitch = true;
        	cheat = false;
        }
        if(level == 5)
        {
        	level = 5;
        	repeatVisible = true;
        	visible = false;
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
	public void playLaunch()
	{
	 	try
	 	{
			URL url = this.getClass().getClassLoader().getResource("launching.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
	 	}
	 	catch (Exception exc)
	 	{
		 	exc.printStackTrace(System.out);
	 	}
	}
   public void actionPerformed(ActionEvent e)
   {
        if( e.getActionCommand().equals("Launch"))
        {
        	String angleText = angle.getText();
            double angle = Double.parseDouble(angleText);//convert the string to an int
            String magnitudeText = magnitude.getText();
            double magnitude = Double.parseDouble(magnitudeText);//convert the string to an int
            b1.setVelocity(angle, magnitude);
            b1.launch();
            playLaunch();
            requestFocus();
        } 
        if( e.getActionCommand().equals("Play Again"))
        {
        	level = 1;
        	time = 60;
        	enemies = 4;
        	for(int i = 0; i<enemyArray.length; i++)
        	{
        		enemyArray[i].reset();
        	}
        } 
        repaint();
    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e)
    {
    	System.out.println(e.getKeyCode());
    	if( e.getKeyCode() == 80 )
    	{
    		//level++;
    		cheat = true;
    	}
    }
    public void keyReleased(KeyEvent e){} 
    public void animate()
    {
        while( true )
        {
            //wait for .1 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            for(int i = 0; i<enemyArray.length; i++)
       		{
            	enemyArray[i].checkCollision(b1);
            	if(enemyArray[i].getCollision() == true)
            	{
            		score = score + 1;
            		enemies = enemies - 1;
            		projectiles = projectiles - 1;
            		playCannon();
            	}
            	enemyArray[i].setCollision(false);		
            }
            for(int i = 0; i<obstacleArray.length; i++)
       		{
            	if(obstacleArray[i].checkCollision(b1) == true)
            	{
    					//b1.setLaunch(false);
    					b1.reset();
    					projectiles = projectiles - 1;
    					playCannon();
            	}
            	//enemyArray[i].setCollision(false);		
            }
            for(int i = 0; i<obstacleArray.length; i++)
        	{
        		obstacleArray[i].move();
        	}
            b1.move();
            b2.move();
            
            if(level == 4 )
            {
            	b2.checkCollision(b1);
            }
            if(projectiles == 0)
            {
            	level = 1;
            	enemies = 4;
            	projectiles = 10;
            }
            if(time < 0)
            {
            	level = 1;
            	time = 60;
            	enemies = 4;
            	projectiles = 10;
            }
            time -= .01;
            repaint();
        }
    }
}