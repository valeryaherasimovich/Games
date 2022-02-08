import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements ActionListener, KeyListener 
{
    private JButton start;
    private JButton next;
    private JButton playAgain;
    private int dialogue = 1;
    private int nextChapt = 0;
    private int bossLives;
    private boolean portal = false;
    private boolean map = true;
    private boolean compass = true;
    private boolean ring = true;
    private boolean necklace = true;
    private boolean bracelet = true;
    private boolean potion = true;
    private boolean key = true;
    private boolean staffPart1 = true;
    private boolean staffPart2 = true;
    private boolean staffPart3 = true;
    private boolean staffFull = false;
    private boolean compassItem = false;
    private boolean mapItem = false;
    private boolean visible = false;
    private boolean keyPressed = false;  
    private BufferedImage startScreen = null;
    private BufferedImage q1 = null;
    private BufferedImage mForest = null;
    private BufferedImage dForest = null;
    private BufferedImage road = null;
    private BufferedImage oV = null;
    private BufferedImage oC = null;
    private BufferedImage oP = null;
    private BufferedImage tR = null;
    private BufferedImage end = null;
    private BufferedImage staffMake = null;
    private BufferedImage gloom = null;
    private BufferedImage portalImage = null;
    private BufferedImage mapImage = null;
    private BufferedImage compassImage = null;
    private BufferedImage ringImage = null;
    private BufferedImage necklaceImage = null;
    private BufferedImage braceletImage = null;
    private BufferedImage staffFullImage = null;
    private BufferedImage potionImage = null;
    private BufferedImage keyImage = null;
    private BufferedImage sPart1 = null;
    private BufferedImage sPart2 = null;
    private BufferedImage sPart3 = null;
    private BufferedImage ghost1 = null;
    private BufferedImage ghost2 = null;
    private Character c;
    private Computer1 c1;
    private Computer2 c2;
    private Computer3 c3;
    private Computer4 c4;
    private Computer5 c5;
    private Minion1 m1;
    private Minion2 m2;
    private Minion3 m3;
    private Minion4 m4;
    private Minion5 m5;
    private Attack a1;
    private Graphics g;
    private Input input;
    private Sound sound1;
    private Sound sound2;
    private Sound sound3;
    private Sound sound4;
    private Sound sound5;
    private Sound sound6;
    private Sound sound7;
    private Sound sound8;
    private Sound sound9;
    private Sound sound10;
    private Sound sound11;
    private Sound sound12;
    private Sound sound13;
    private Sound sound14;
    private Sound sound15;
    private Sound sound16;
    private List<Item> items;

    public Screen() 
    {
        setLayout(null);
        addKeyListener(this);
        c = new Character(10, 350);
        c1 = new Computer1();
        c2 = new Computer2();
        c3 = new Computer3();
        c4 = new Computer4();
        c5 = new Computer5();
        m1 = new Minion1(200,350);
        m2 = new Minion2(800,350);
        m3 = new Minion3(800,300);
        m4 = new Minion4(680,350);
        m5 = new Minion5(700,350);
        input = new Input(this);
        next = new JButton("Next");
        next.setBounds(250, 360, 100, 30);
        start = new JButton("Start Adventure!");
        start.setBounds(250, 360, 160, 30);
        playAgain = new JButton("Play Again!");
        playAgain.setBounds(250, 360, 160, 30);
        items = new ArrayList<Item>();
        sound1 = new Sound("Opening.wav");
        sound2 = new Sound("Computer2Talk.wav");
        sound3 = new Sound("Minion1Fight.wav");
        sound4 = new Sound("Computer3Talk.wav");
        sound5 = new Sound("Minion2Fight.wav");
        sound6 = new Sound("Computer3Talk.wav");
        sound7 = new Sound("Computer4Talk.wav");
        sound8 = new Sound("Minion4Fight.wav");
        sound9 = new Sound("StaffMakeSong.wav");
        sound10 = new Sound("FinalBossFight.wav");
        sound11 = new Sound("End.wav");
        sound12 = new Sound("cannon.wav");
        sound13 = new Sound("PortalEnter.wav");
        sound14 = new Sound("ItemPickUp.wav");
        sound15 = new Sound("ItemDrop.wav");
        sound16 = new Sound("SpellCast.wav");
        try 
        	{
                startScreen = ImageIO.read(new File("StartScreen.jpg"));
                q1 = ImageIO.read(new File("Commons.jpg"));
                ghost1 = ImageIO.read(new File("Ghost1.jpg"));
                ghost2 = ImageIO.read(new File("Ghost2.jpg"));
                portalImage = ImageIO.read(new File("Portal.jpg"));
                mForest = ImageIO.read(new File("Magic.jpg"));
                dForest = ImageIO.read(new File("Minion1Fight.jpg"));
                road = ImageIO.read(new File("Yay.jpg"));
                compassImage = ImageIO.read(new File("Compass.jpg"));
                mapImage = ImageIO.read(new File("Map.jpg"));
                ringImage = ImageIO.read(new File("Ring.jpg"));
                sPart1 = ImageIO.read(new File("SPart1.jpg"));
                oV = ImageIO.read(new File("Minion2Fight.jpg"));
                necklaceImage = ImageIO.read(new File("Necklace.jpg"));
                sPart2 = ImageIO.read(new File("SPart2.jpg"));
                gloom = ImageIO.read(new File("Gloom.jpg"));
                oC = ImageIO.read(new File("OutsideCastle.jpg"));
                braceletImage = ImageIO.read(new File("Bracelet.jpg"));
                keyImage = ImageIO.read(new File("Key.jpg"));
                oP = ImageIO.read(new File("InsideCastle.jpg"));
                sPart3 = ImageIO.read(new File("SPart3.jpg"));
                staffMake = ImageIO.read(new File("StaffMake.jpg"));
                potionImage = ImageIO.read(new File("Potion.jpg"));
                staffFullImage = ImageIO.read(new File("StaffFull.jpg"));
                tR = ImageIO.read(new File("ThroneRoom.jpg"));
                end = ImageIO.read(new File("End.jpg"));
            } 
        catch (IOException ex) 
        {}
    }
    
    public Dimension getPreferredSize() 
    {
        return new Dimension(1000, 600);
    }
    
    public void paintComponent(Graphics g) 
    {
        Color white = new Color(255, 255, 255);
        g.setColor(white);
        if (nextChapt == 0)
        {
            if (!sound1.isPlaying())
			{
				sound1.play();
			}
            g.drawImage(startScreen, 0, 0, null);
            if (visible == false) 
            {
                g.drawString("A long time ago, there was a village by the name of Magnolia. ", 250, 200);
                g.drawString("The civilians of Magnolia lived happily ever after, until an evil sorcerer invaded ", 250, 220);
                g.drawString("their peaceful homes and transformed all of the villegers into ghosts. ", 250, 240);
                g.drawString("You must stop the evil sorcerer and break his spell to ", 250, 260);
                g.drawString("bring the villegers back to normal. ", 250, 280);
                g.drawString("Along the way you shall receive help from wizards who were ", 250, 300);
                g.drawString("not affected by the evil sorcerer's curse. ", 250, 320);
                g.drawString("Best of luck! ", 250, 340);
                add(next);
                next.addActionListener(this);
            }
            if (visible == true) 
            {
                g.drawString("Useful tips: ", 250, 200);
                g.drawString("1) To move, use arrow keys. ", 250, 220);
                g.drawString("2) Walk up to NPC's to interact. ", 250, 240);
                g.drawString("3) Walk over items in order to pick them up. ", 250, 260);
                g.drawString("3) Aim for the head area when fighting a boss. ", 250, 280);
                g.drawString("4) Collect all items before going into portal. ", 250, 300);
                g.drawString("5) Look out for the boss lives in the upper right corner! ", 250, 320);
                add(start);
                start.addActionListener(this);
            }
        }

        if (nextChapt==1) 
        {		
            if (!sound1.isPlaying())
			{
				sound1.play();
			}
            g.drawImage(q1, 0, 0, null);
            c.drawCharacter(g);
            c1.drawComputer(g);
            g.drawString("INVENTORY: ", 10, 50);
            g.drawString("QUEST 1 ", 750, 50);
            g.drawImage(ghost1, 430, 300, null);
            g.drawImage(ghost2, 200, 470, null);
            if (c.getX() >= 130 && !portal) 
            {
                dialogue = 1;
            }
            if (c.getX() >= 230 && !portal) 
            {
                dialogue = 2;
            }
            if (c.getX() >= 430 && !portal) 
            {
                dialogue = 3;
            }
            if (dialogue == 1) 
            {
                g.drawString("Hmm...I wonder ", 169, 310);
                g.drawString("what's going on in ", 169, 330);
                g.drawString("this village..?", 169, 350);
            }
            if (dialogue == 2) 
            {
                g.drawString("Look! There's someone ", 290, 310);
                g.drawString("up ahead. Maybe they can ", 290, 330);
                g.drawString("help us! ", 290, 350);
            }
            if (dialogue == 3) 
            {
                g.drawString("An evil sorcerer ", 650, 270);
                g.drawString("by the name of Alexander ", 650, 290);
                g.drawString("attacked our village and ", 650, 310);
                g.drawString("turned all of the villagers ", 650, 330);
                g.drawString("into ghosts. Go into the portal ", 650, 350);
                g.drawString("and find Malika. She should ", 650, 370);
                g.drawString("be able to help you! ", 650, 390);
                portal = true;
            }
            if(portal)
            {
                
                g.drawImage(portalImage, 20, 320, null);
                if (c.getX() < 130)
                {
                    sound13.play();
                    portal = false;
                    dialogue = 0;
                    nextChapt = 2;
                }
            }
        }

        if (nextChapt==2) 
        {
            if (sound1.isPlaying())
			{
				sound1.stop();
			}
            if (!sound2.isPlaying())
			{
				sound2.play();
			}
            g.drawImage(mForest, 0, 0, null);
            c.drawCharacter(g);
            c2.drawComputer(g);
            g.drawString("INVENTORY: ", 10, 50);
            g.drawString("QUEST 1 ", 750, 50);
            if (c.getX() >= 50 && !portal) 
            {
                dialogue = 1;
            }
            if (c.getX() >= 150 && !portal) 
            {
                dialogue = 2;
            }
            if (c.getX() >= 250 && !portal) 
            {
                dialogue = 3;
            }
            if (dialogue == 1) 
            {
                g.drawString("There she is! ", 100, 310);
                g.drawString("Go talk to her! ", 100, 330);

            }
            if (dialogue == 2) 
            {
                g.drawString("I've been expecting you! ", 230, 250);
                g.drawString("In order to defeat Alexander ", 230, 270);
                g.drawString("and turn the villagers back ",230, 290);
                g.drawString("to normal, you must defeat his ", 230, 310);
                g.drawString("minions that drop parts to a staff ",230, 330);
                g.drawString("that will help you defeat him and ",230, 350);
                g.drawString("break his spell.",230, 370);
            }
            if (dialogue == 3) 
            {
                g.drawString("Take this map and ", 390, 310);
                g.drawString("compass, it will help you ",390, 330);
                g.drawString("find the minions. ",390, 350);
                portal = true;
            }
                
            if(compass && nextChapt == 2)
            {
                g.drawImage(compassImage, 630, 330, null);
                sound15.play();
            }

            if(map && nextChapt == 2)
            {
                g.drawImage(mapImage, 670, 330, null);
                sound15.play();
            }
            if(portal && nextChapt == 2)
            {
            	g.drawImage(portalImage, 750, 200, null);
            	if (c.getX() > 750 && c.getY() < 300)
                {
                    sound13.play();
                    nextChapt = 3;
                    portal = false;
                    dialogue = 0;
                    bossLives = 2;
                }
            }
        }
        
        if(nextChapt==3)
        {
            if (sound2.isPlaying())
			{
				sound2.stop();
			}
            if (!sound3.isPlaying())
			{
				sound3.play();
			}
            g.drawImage(dForest, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
            g.drawString("QUEST 1 ", 750, 50);
            g.drawString("BOSS LIVES: " + bossLives, 850, 50);
            c.drawCharacter(g);
        	m1.drawMinion(g);
        	ArrayList<Attack1> attacks1 = c.getAttacks1();
        	for (int i=0; i<attacks1.size(); i++)
        	{
        		attacks1.get(i).drawAttack(g);
        		sound16.play();
        	}
        	if(dialogue == 0)
        	{
        		g.drawString("Look! There's one right there! ", 700, 310);
        		g.drawString("In order to attack, press 1! ", 700, 330);
        	}
        }
        if(nextChapt==4)
        {
        	g.drawImage(dForest, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
            g.drawString("QUEST 1 ", 750, 50);
            c.drawCharacter(g);
        	
            if(ring && nextChapt == 4)
            {
                g.drawImage(ringImage, 600, 500, null);
                sound15.play();
            }
            if(staffPart1 && nextChapt == 4)
            {
            	g.drawImage(sPart1, 650, 500, null);
            	sound15.play();
            }
            if(dialogue==1 && c.getX() >= 450)
            {
            	g.drawString("Congratulations! You defeated ", 550, 270);
        		g.drawString("a minion. He dropped two items. ", 550, 290);
        		g.drawString("Go into the portal, and find someone ", 550, 310);
        		g.drawString("who can help you understand what ", 550, 330);
        		g.drawString("they are. ", 550, 350);
            }
            if(portal)
            {
            	g.drawImage(portalImage, 20, 290, null);
            	if (c.getX() < 130)
                {
                    sound13.play();
                    portal = false;
                    dialogue = 0;
                    nextChapt = 5;
                }
            }
        
        }
        if(nextChapt==5)
        {
        	if (sound3.isPlaying())
			{
				sound3.stop();
			}
        	if (!sound4.isPlaying())
			{
				sound4.play();
			}
            g.drawImage(road, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 2 ", 750, 50);
        	c.drawCharacter(g);
        	c3.drawComputer(g);
        	if(dialogue == 1 && !portal)
        	{
        		g.drawString("Maybe that person up there can ", 169 , 310 );
        		g.drawString("help us. ", 169, 330);
        	}
        	if(dialogue == 2 && !portal)
        	{
        		g.drawString("Excuse me, do you know ", 290 , 310);
        		g.drawString("what these items are? ", 290 , 330);
        	}
        	if(dialogue == 3)
        	{
        		g.drawString("Yes, in fact, that stick ",750 , 230 );
        		g.drawString("is a part of the staff, and " , 750 , 250);
        		g.drawString("that ring will now allow you to " , 750, 270 );
        		g.drawString("use water powers to fight minions ", 750 , 290 );
        		g.drawString("by pressing key 2. ", 750 , 310);
        		g.drawString("Hop into the portal and use " ,750, 330);
        		g.drawString("the map and compass to find the ", 750, 350);
        		g.drawString("second minion. ", 750, 370 );
        		portal = true;
        	}
        	if (c.getX() >= 130) 
            {
                dialogue = 1;
            }
            if (c.getX() >= 230) 
            {
                dialogue = 2;
            }
            if (c.getX() >= 450) 
            {
                dialogue = 3;
            }
            if(portal)
            {
            	g.drawImage(portalImage, 20, 300, null);
            	if (c.getX() < 130)
                {
                    sound13.play();
                    nextChapt = 6;
                    portal = false;
                    dialogue = 0;
                    bossLives = 4;
                }
            }
        
        }
    	if(nextChapt==6)
    	{
    		if (sound4.isPlaying())
			{
				sound4.stop();
			}
    		if (!sound5.isPlaying())
			{
				sound5.play();
			}
    		
            g.drawImage(oV, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 2 ", 750, 50);
        	g.drawString("BOSS LIVES: " + bossLives, 850, 50);
        	c.drawCharacter(g);
        	m2.drawMinion(g);
        	ArrayList<Attack1> attacks1 = c.getAttacks1();
        	for (Attack1 attack:attacks1)
        	{
        		attack.drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack2> attacks2 = c.getAttacks2();
        	for (int i=0; i<attacks2.size(); i++)
        	{
        		attacks2.get(i).drawAttack(g);
        		sound16.play();
        	}
        }
        if(nextChapt==7)
        {
        	g.drawImage(oV, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 2 ", 750, 50);
        	c.drawCharacter(g);
        	
            if(necklace && nextChapt == 7)
            {
                g.drawImage(necklaceImage, 890, 500, null);
                sound15.play();
            }
            if(staffPart2 && nextChapt == 7)
            {
            	g.drawImage(sPart2, 700, 500, null);
            	sound15.play();
            }
            if(c.getX() >= 450)
            {
            	g.drawString("Congratulations! You defeated ", 750, 270);
        		g.drawString("a minion. She dropped two items. ", 750, 290);
        		g.drawString("Go into the portal, and find someone ", 750, 310);
        		g.drawString("who can help you understand what ", 750, 330);
        		g.drawString("they are. ", 750, 350);
            }
            if(portal)
            {
            	g.drawImage(portalImage, 200, 170, null);
            	if (c.getX() < 300)
                {
                    sound13.play();
                    nextChapt = 8;
                    portal = false;
                    dialogue = 0;
                }
            }
        }
        if(nextChapt==8)
        {
    		if (sound5.isPlaying())
			{
				sound5.stop();
			}
    		if (!sound6.isPlaying())
			{
				sound6.play();
			}
    		
            g.drawImage(gloom, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 3 ", 750, 50);
        	c.drawCharacter(g);
        	c4.drawComputer(g);
        	if(dialogue == 1 && !portal)
        	{
        		g.drawString("Hey! Over here! ", 750 , 310 );
        	}
        	if(dialogue == 2 && !portal)
        	{
        		g.drawString("Hey. Do you know what ", 350 , 310);
        		g.drawString("these items are? ", 350 , 330);
        	}
        	if(dialogue == 3)
        	{
        		g.drawString("Yeah! That's another ",750 , 200 );
        		g.drawString("part of the staff, and " , 750 , 220);
        		g.drawString("that necklace lets you use lighting powers " , 750, 240 );
        		g.drawString("by pressing key 3.  ", 750 , 260 );
        		g.drawString("You're getting closer to Alexander's ", 750 , 280);
        		g.drawString("castle. The next minion " ,750, 300);
        		g.drawString("guards the key to it. ", 750, 320);
        		g.drawString("Good luck! ", 750, 340 );
        		portal = true;
        	}
        	if (c.getX() >= 30) 
            {
                dialogue = 1;
            }
            if (c.getX() >= 330) 
            {
                dialogue = 2;
            }
            if (c.getX() >= 650) 
            {
                dialogue = 3;
            }
            if(portal)
            {
            	g.drawImage(portalImage, 20, 300, null);
            	if (c.getX() < 130)
                {
                    sound13.play();
                    nextChapt = 9;
                    portal = false;
                    dialogue = 0;
                    bossLives = 6;
                }
            }
        }
        if(nextChapt==9)
        {
        	if (sound6.isPlaying())
			{
				sound6.stop();
			}
        	if (!sound7.isPlaying())
			{
				sound7.play();
			}
        	
            g.drawImage(oC, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 3 ", 750, 50);
        	g.drawString("BOSS LIVES: " + bossLives, 850, 50);
        	c.drawCharacter(g);
        	m3.drawMinion(g);
        	ArrayList<Attack1> attacks1 = c.getAttacks1();
        	for (Attack1 attack:attacks1)
        	{
        		attack.drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack2> attacks2 = c.getAttacks2();
        	for (int i=0; i<attacks2.size(); i++)
        	{
        		attacks2.get(i).drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack3> attacks3 = c.getAttacks3();
        	for (int i=0; i<attacks3.size(); i++)
        	{
        		attacks3.get(i).drawAttack(g);
        		sound16.play();
        	}
        }
        if(nextChapt==10)
        {
            g.drawImage(oC, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 3 ", 750, 50);
        	c.drawCharacter(g);
            if(bracelet && nextChapt == 10)
            {
                g.drawImage(braceletImage, 400, 200, null);
                sound15.play();
            }
            if(key && nextChapt == 10)
            {
            	g.drawImage(keyImage, 600, 500, null);
            	sound15.play();
            }
            if(dialogue==1 && c.getX() >= 450)
            {
            	g.drawString("Yay! We got the key! ", 550, 270);
        		g.drawString("We also got a bracelet. ", 550, 290);
        		g.drawString("By the looks of it, the ", 550, 310);
        		g.drawString("bracelet will allow us to use ", 550, 330);
        		g.drawString("dark magic by pressing key 4! ", 550, 350);
            }
            if(portal)
            {
            	g.drawImage(portalImage, 20, 300, null);
            	if (c.getX() < 130)
                {
                    sound13.play();
                    nextChapt = 11;
                    portal = false;
                    dialogue = 0;
                    bossLives = 8;
                }
            }
        }
        if(nextChapt==11)
        {
        	if (sound7.isPlaying())
			{
				sound7.stop();
			}
        	if (!sound8.isPlaying())
			{
				sound8.play();
			}
        	
            for(int i=0; i<items.size();i++)
            {
            	if(items.get(i).getName()=="key")
            	{
            		items.remove(i);
            		break;
            	}
            }
            g.drawImage(oP, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 4 ", 750, 50);
        	g.drawString("BOSS LIVES: " + bossLives, 850, 50);
        	c.drawCharacter(g);
        	m4.drawMinion(g);
        	ArrayList<Attack1> attacks1 = c.getAttacks1();
        	for (Attack1 attack:attacks1)
        	{
        		attack.drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack2> attacks2 = c.getAttacks2();
        	for (int i=0; i<attacks2.size(); i++)
        	{
        		attacks2.get(i).drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack3> attacks3 = c.getAttacks3();
        	for (int i=0; i<attacks3.size(); i++)
        	{
        		attacks3.get(i).drawAttack(g);
        		sound16.play();
        	}
        	ArrayList<Attack4> attacks4 = c.getAttacks4();
        	for (int i=0; i<attacks4.size(); i++)
        	{
        		attacks4.get(i).drawAttack(g);
        		sound16.play();
        	}
        	if(dialogue == 1)
        	{
        		g.drawString("She should have the ", 130, 270);
        		g.drawString("last staff part! ", 130, 290);
        		g.drawString("Kill her! ", 130, 310);
        	}
        	if (c.getX() < 130)
            {
                dialogue = 1;
            }
        }
        if(nextChapt==12)
        {
        	
            g.drawImage(oP, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 4 ", 750, 50);
        	c.drawCharacter(g);
            if(staffPart3 && nextChapt==12)
            {
                g.drawImage(sPart3, 600, 500, null);
                sound15.play();
            }
            if(dialogue==1 && c.getX() >= 500)
            {
            	g.drawString("We got the last ", 550, 270);
        		g.drawString("part of the staff! ", 550, 290);
        		g.drawString("The portal will take ", 550, 310);
        		g.drawString("us to a place where ", 550, 330);
        		g.drawString("we can mend the 3 parts! ", 550, 350);
            }
            if(portal)
            {
            	g.drawImage(portalImage, 20, 300, null);
            	if (c.getX() < 130)
                {
                    sound13.play();
                    nextChapt=13;
                    portal = false;
                    dialogue = 0;
                }
            }
        }
        if(nextChapt==13)
        {
        	if (sound8.isPlaying())
			{
				sound8.stop();
			}
        	if (!sound9.isPlaying())
			{
				sound9.play();
			}
        	
            g.drawImage(staffMake, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 5 ", 750, 50);
        	c.drawCharacter(g);
        	c5.drawComputer(g);
        	if(dialogue == 1)
            {
            	g.drawString("There's someone up there. ", 130, 270);
        		g.drawString("Go ask how we can ", 130, 290);
        		g.drawString("mend the staff.  ", 130, 310);
            }
            if(dialogue == 2)
            {
            	g.drawString("Take this potion ", 400, 270);
        		g.drawString("and press the key M!  ", 400, 290);
        	}
        	if (c.getX() > 30)
            {
                dialogue = 1;
            }
            if (c.getX() > 340)
            {
                dialogue = 2;
                if(potion && nextChapt==13)
            	{
                	g.drawImage(potionImage, 800, 500, null);
                	sound15.play();
            	}
            }
            if(staffFull)
            {
            	for(int i=0; i<items.size();i++)
            	{
            		if(items.get(i).getName()=="staff1")
            		{
            			items.remove(i);
            		}
            		if(items.get(i).getName()=="staff2")
            		{
            			items.remove(i);
            		}
            		if(items.get(i).getName()=="staff3")
            		{
            			items.remove(i);
            		}
            		if(items.get(i).getName()=="potion")
            		{
            			items.remove(i);
            		}
            	
            	}
            	g.drawImage(staffFullImage, 10, 100, null);
            	sound14.play();
            	portal = true;
            	dialogue = 0;
            	if(portal)
            	{
            		g.drawImage(portalImage, 200, 170, null);
            		if (c.getX()>200 && c.getX() < 300)
                	{
                    	sound13.play();
                    	nextChapt=14;
                    	portal = false;
                    	dialogue = 0;
                    	bossLives = 10;
                	}
            	} 
            }
            
        }
        if(nextChapt==14)
        {
        	if (sound9.isPlaying())
			{
				sound9.stop();
			}
        	if (!sound10.isPlaying())
			{
				sound10.play();
			}
        	
            g.drawImage(tR, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 5 ", 750, 50);
        	g.drawString("BOSS LIVES: " + bossLives, 850, 50);
        	c.drawCharacter(g);
        	m5.drawMinion(g);
        	ArrayList<Attack1> attacks1 = c.getAttacks1();
        	for (Attack1 attack:attacks1)
        	{
        		attack.drawAttack(g);
        	}
        	ArrayList<Attack2> attacks2 = c.getAttacks2();
        	for (int i=0; i<attacks2.size(); i++)
        	{
        		attacks2.get(i).drawAttack(g);
        	}
        	ArrayList<Attack3> attacks3 = c.getAttacks3();
        	for (int i=0; i<attacks3.size(); i++)
        	{
        		attacks3.get(i).drawAttack(g);
        	}
        	ArrayList<Attack4> attacks4 = c.getAttacks4();
        	for (int i=0; i<attacks4.size(); i++)
        	{
        		attacks4.get(i).drawAttack(g);
        	}
        	
        }
        if(nextChapt==15)
        {
            g.drawImage(tR, 0, 0, null);
            g.drawString("INVENTORY: ", 10, 50);
        	g.drawString("QUEST 5 ", 750, 50);
        	c.drawCharacter(g);
        	g.drawString("We killed him! ", 330, 270);
        	g.drawString("Let's get out of here! ", 330, 290);
        	if(portal)
            {
            	g.drawImage(portalImage, 20, 300, null);
            	if (c.getX() < 130)
                {
                    sound16.play();
                    nextChapt=16;
                    portal = false;
                    items.clear();
                }
            }
        }
        if(nextChapt==16)
        {
        	if (sound10.isPlaying())
			{
				sound10.stop();
			}
        	if (!sound11.isPlaying())
			{
				sound11.play();
			}
        	
            g.drawImage(end, 0, 0, null);
            g.drawString("Thanks to your help, Alexander was defeated ", 250, 200);
            g.drawString("and all of the villagers were turned back to normal. ", 250, 220);
            g.drawString("The peaceful village of Magnolia lived happily ever after ", 250, 240);
            g.drawString("since.  ", 250, 260);
            //add(playAgain);
            //playAgain.addActionListener(this);
            
        }
        for (int i =0; i<items.size(); i++)
        {
            items.get(i).drawItem(g);
        }
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Next")) 
        {
            visible = true;
            remove(next);
        }
        if (e.getActionCommand().equals("Start Adventure!")) 
        {
            nextChapt = 1;
            remove(start);
            requestFocus();
        }
        if (e.getActionCommand().equals("Play Again!")) 
        {
            nextChapt = 1;
            remove(playAgain);
            sound11.stop();
            sound1.play();
        }
        
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) 
    {
        
        if (c.getX() > 600 && map && nextChapt==2)
        {
            items.add(new Map(10, 60));
            sound14.play();
            map = false;
        }
        if (c.getX() > 560 && compass && nextChapt==2)
        {
            items.add(new Compass(50, 60));
            sound14.play();
            compass = false; 
            portal = true;        
        }
        if(c.getX() > 550 && ring && nextChapt==4)
        {
        	items.add(new Ring(90, 60));
        	sound14.play();
        	ring = false;
        }
        if(c.getX() > 600 && staffPart1 && nextChapt==4)
        {
        	items.add(new sPart1(10, 100));
        	staffPart1 = false;
        	sound14.play();
        	portal = true;
        }
        if(c.getX() > 760 && necklace && nextChapt==7)
        {
        	items.add(new Necklace(130, 60));
        	necklace = false;
        	sound14.play();
        	portal = true;
        }
        if(c.getX() > 660 && staffPart2 && nextChapt==7)
        {
        	items.add(new sPart2(50, 100));
        	staffPart2 = false;
        	sound14.play();
        }
        if(c.getX() > 350 && bracelet && nextChapt==10)
        {
        	items.add(new Bracelet(170, 40));
        	bracelet = false;
        	sound14.play();
        }
        if(c.getX() > 550 && key && nextChapt==10)
        {
        	items.add(new Key(10, 140));
        	key = false;
        	sound14.play();
        	portal = true;
        }
        if(c.getX() > 560 && staffPart3 && nextChapt==12)
        {
        	items.add(new sPart3(90, 100));
        	staffPart3 = false;
        	sound14.play();
        	portal = true;
        }
        if(c.getX() > 760 && potion && nextChapt==13)
        {
        	items.add(new Potion(190, 100));
        	potion = false;
        	sound14.play();
        }
        if (c.getX() < 130 && nextChapt==2 && map == false && compass == false && portal == true)
        {
            nextChapt = 3;
            portal = false;
            dialogue = 0;
        }
        
        repaint();
    }

    public void keyReleased(KeyEvent e)
    {
    	keyPressed = false;
    }
    
    public void cheatKey()
    {
    	
    			if(nextChapt<16)
    			{
    				nextChapt = nextChapt+1;
    			}
    			if(nextChapt == 3)
    			{
    				bossLives = 2;
    				items.add(new Map(10, 60));
    				items.add(new Compass(50, 60));
    			}
    			if(nextChapt == 5)
    			{
    				items.add(new Ring(90, 60));
    				items.add(new sPart1(10, 100));
    			}
    			if(nextChapt == 6)
    			{
    				bossLives = 4;
    			}
    			if(nextChapt == 8)
    			{
    				items.add(new Necklace(130, 60));
    				items.add(new sPart2(50, 100));
    			}
    			if(nextChapt == 9)
    			{
    				bossLives = 6;
    			}
    			if(nextChapt == 11)
    			{
    				bossLives = 8;
    				items.add(new Bracelet(170, 40));
    				items.add(new Key(10, 140));
    			}
    		
    			if(nextChapt == 13)
    			{
    				items.add(new sPart3(90, 100));
    				items.add(new Potion(190, 100));
    				staffFull = true;

    			}
    			if(nextChapt == 14)
    			{
    				bossLives = 10;
    			}
    			
    			if(nextChapt == 16)
    			{
    				items.clear();	
    			}
    
    }
    
    
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
            if(Input.keyboard[37])
            {
            	c.moveLeft();
            }
            if(Input.keyboard[39])
            {
            	c.moveRight();
            }
            if(Input.keyboard[40])
            {
            	c.moveDown();
            }
            if(Input.keyboard[38])
            {
            	c.moveUp();
            }
            if(Input.keyboard[49])
            {
            	c.fire1();
            	dialogue = 1;
            	sound16.play();
            }
            if(Input.keyboard[50])
            {
            	c.fire2();
            	sound16.play();
            }
            if(Input.keyboard[51])
            {
            	c.fire3();
            	sound16.play();
            }
            if(Input.keyboard[52])
            {
            	c.fire4();
            	sound16.play();
            }
            if(Input.keyboard[77])
            {
            	staffFull = true;
            }
            if(Input.keyboard[80])
            {
            	if(!keyPressed)
            	{
            		cheatKey();
            		keyPressed = true;
            	}
            	
            }
            m1.move();
            m2.move();
            m3.move();
            m4.move();
            m5.move();
            ArrayList<Attack1> attacks1 = c.getAttacks1();
            for(int i = 0; i<attacks1.size();i++)
            {
            	if(attacks1.get(i).getVisible())
            	{
            		
            		if(nextChapt == 3)
            		{
            			attacks1.get(i).moveLeft();
            			if(m1.checkCollision(attacks1.get(i)))
            			{
            			
            				attacks1.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m1.setVisible(false);
            					nextChapt = 4;
            				}
            			
            			}
            		}
            		
            		if(nextChapt == 6)
            		{
            			attacks1.get(i).moveRight();
            			if(m2.checkCollision(attacks1.get(i)))
            			{
            				attacks1.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m2.setVisible(false);
            					nextChapt = 7;
            				}
            			}
            		}
            		
            		if(nextChapt == 9)
            		{
            			attacks1.get(i).moveRight();
            			if(m3.checkCollision(attacks1.get(i)))
            			{
            				attacks1.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m3.setVisible(false);
            					nextChapt = 10;
            				}
            			}
            		}
            		if(nextChapt == 11)
            		{
            			attacks1.get(i).moveRight();
            			if(m4.checkCollision(attacks1.get(i)))
            			{
            				attacks1.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m4.setVisible(false);
            					nextChapt = 12;
            				}
            			}
            		}
            		if(nextChapt == 14)
            		{
            			attacks1.get(i).moveRight();
            			if(m5.checkCollision(attacks1.get(i)))
            			{
            				attacks1.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m5.setVisible(false);
            					nextChapt = 15;
            					portal = true;
            				}
            			}
            		}
            		
            	}
            	else
            	{
            		attacks1.remove(i);
            	}
            	
            }
            ArrayList<Attack2> attacks2 = c.getAttacks2();
            for(int i = 0; i<attacks2.size();i++)
            {
            	if(attacks2.get(i).getVisible())
            	{	
            		if(nextChapt == 6)
            		{
            			attacks2.get(i).moveRight();
            			if(m2.checkCollision(attacks2.get(i)))
            			{
            				attacks2.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m2.setVisible(false);
            					nextChapt = 7;
            				}
            			}
            		}
            		
            		if(nextChapt == 9)
            		{
            			attacks2.get(i).moveRight();
            			if(m3.checkCollision(attacks2.get(i)))
            			{
            				attacks2.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m3.setVisible(false);
            					nextChapt = 10;
            				}
            			}
            		}
            		if(nextChapt == 11)
            		{
            			attacks2.get(i).moveRight();
            			if(m4.checkCollision(attacks2.get(i)))
            			{
            				attacks2.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m4.setVisible(false);
            					nextChapt = 12;
            				}
            			}
            		}
            		if(nextChapt == 14)
            		{
            			attacks2.get(i).moveRight();
            			if(m5.checkCollision(attacks2.get(i)))
            			{
            				attacks2.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m5.setVisible(false);
            					nextChapt = 15;
            					portal = true;
            				}
            			}
            		}
            		
            	}
            	else
            	{
            		attacks2.remove(i);
            	}
            }
            ArrayList<Attack3> attacks3 = c.getAttacks3();
            for(int i = 0; i<attacks3.size();i++)
            {
            	if(attacks3.get(i).getVisible())
            	{	            		
            		if(nextChapt == 9)
            		{
            			attacks3.get(i).moveRight();
            			if(m3.checkCollision(attacks3.get(i)))
            			{
            				attacks3.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m3.setVisible(false);
            					nextChapt = 10;
            				}
            			}
            		}
            		if(nextChapt == 11)
            		{
            			attacks3.get(i).moveRight();
            			if(m4.checkCollision(attacks3.get(i)))
            			{
            				attacks3.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m4.setVisible(false);
            					nextChapt = 12;
            				}
            			}
            		}
            		if(nextChapt == 14)
            		{
            			attacks3.get(i).moveRight();
            			if(m5.checkCollision(attacks3.get(i)))
            			{
            				attacks3.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m5.setVisible(false);
            					nextChapt = 15;
            					portal = true;
            				}
            			}
            		}
            		
            	}
            	else
            	{
            		attacks3.remove(i);
            	}
            }
            ArrayList<Attack4> attacks4 = c.getAttacks4();
            for(int i = 0; i<attacks4.size();i++)
            {
            	if(attacks4.get(i).getVisible())
            	{	            		
            		if(nextChapt == 11)
            		{
            			attacks4.get(i).moveRight();
            			if(m4.checkCollision(attacks4.get(i)))
            			{
            				attacks4.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m4.setVisible(false);
            					nextChapt = 12;
            				}
            			}
            		}
            		if(nextChapt == 14)
            		{
            			attacks4.get(i).moveRight();
            			if(m5.checkCollision(attacks4.get(i)))
            			{
            				attacks4.remove(i);
            				bossLives = bossLives-1;
            				sound12.play();
            				sound12.play();
            				if(bossLives == 0)
            				{
            					m5.setVisible(false);
            					nextChapt = 15;
            					portal = true;
            				}
            			}
            		}
            		
            	}
            	else
            	{
            		attacks4.remove(i);
            	}
            }
        	repaint();
        }
    }
}