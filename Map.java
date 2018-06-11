package Snake;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends Start implements ActionListener{
	
	private int Direction;
    private int Long;
    private int a;
    public static int c;
    
    private final int height = 30;
    private final int width = 30;
    private final int unit = 20;
    
    private JButton up;
    private JButton down;
    private JButton right;
    private JButton left;
    private JPanel ControlPanel;
    
    private ArrayList<SnakeBody> snake = new ArrayList<>();
    private SnakeBody newBody = new SnakeBody(1,1,Color.WHITE);
    
    
    Timer time = new Timer(c,new ThingsListener());

    
    public Map() {
    	
        snake.add(new SnakeBody(width/2,height/2,Color.WHITE));
        snake.add(new SnakeBody(width/2,height/2+1,Color.WHITE));
        snake.add(new SnakeBody(width/2,height/2+2,Color.WHITE));

        Direction = 1;
        Long = 3;
        food();
        time.start();

        this.setLayout(new BorderLayout());
        ControlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        up = new JButton ("UP");
        gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
        up.addActionListener(this);
		ControlPanel.add(up,gbc);
		
		down = new JButton ("Down");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
        down.addActionListener(this);
		ControlPanel.add(down,gbc);
		
		right = new JButton ("RIGHT");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		right.addActionListener(this);
		ControlPanel.add(right,gbc);
		
		left = new JButton ("LEFT");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		left.addActionListener(this);
		ControlPanel.add(left,gbc);
		
		this.add(ControlPanel,BorderLayout.SOUTH);
		
		JFrame frame2 = new JFrame();
        frame2.setBounds(0,0,620,695);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);		
		
    }
    
     public int getspeed() {
    	 return Speed;
     }
        
     public static void setspeed(int Speed) {
    	  c = Speed;
     }
     
     public void run() {
            int direction = 0;
            
            switch(a) {
                case 1:
                    direction = 1;
                    break;
                case -1:
                    direction = -1;
                    break;
                case 2:
                    direction = 2;
                    break;
                case -2:
                    direction = -2;
                    break;
                default:
                    break;
            }
            
            if(direction + Direction !=0) {
                Direction = direction;
                Move(direction);
                repaint();
            }
        }
   

		
    public void Move(int direction) {
    	
        int FirstX = snake.get(0).getX();
        int FirstY = snake.get(0).getY();
        
        switch(direction) {
        
            case 1:
                FirstY--;
                break;
            case -1:
                FirstY++;
                break;
            case 2:
                FirstX--;
                break;
            case -2:
                FirstX++;
                break;
            default:
                break;
        }
        if(FirstX == newBody.getX() && FirstY == newBody.getY()) {
        	
            eat();
            return;       
        }
        for(int i = 0; i < Long; i++) {
        	
            if((FirstX == snake.get(i).getX()) && (FirstY == snake.get(i).getY())) {
            	
                Dead("你屎了");
                
            }
            
        }
        if(FirstX < 0 || FirstX > width-1  || FirstY < 0 || FirstY > height -1) {
        	
            Dead("你屎了");           
        }

        for(int i = Long - 1; i > 0; i--) {
        	
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());            
        }       
        snake.get(0).setX(FirstX);
        snake.get(0).setY(FirstY);
        repaint();    
        
    }

    
    public void food() {
    	
        int newX = 0;
        int newY = 0;
        Boolean egg = true;
        
        while(egg) {
        	
        newX = new Random().nextInt(width);
        newY = new Random().nextInt(height);

        for(int i = 0; i < Long; i++) {
            if(snake.get(i).getX() == newX && snake.get(i).getY() == newY) {
            	
                egg = true;
                break;          
            }
                egg= false;
            }
        
        }

        Color color = Color.WHITE;
        newBody.setX(newX);
        newBody.setY(newY);
        newBody.setColor(color);
        this.setBackground(Color.BLACK);       
    }


    public void eat() {
    	
        snake.add(new SnakeBody());
        Long++;
        
        for(int i = Long-1; i >0; i--) {
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());
            snake.get(i).setColor(snake.get(i-1).getColor());
        }    
        snake.get(0).setX(newBody.getX());
        snake.get(0).setY(newBody.getY());
        snake.get(0).setColor(newBody.getColor());
        
        food();      
        repaint();
    }

    
    public void Dead(String s) {
    	
        String str = s +"\n" +"再練練吧~";
        JOptionPane.showMessageDialog(this,  "\n" + str   );
        System.exit(0);        
    }

    

    class ThingsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           Move(Direction);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        g.setColor(newBody.getColor());
        g.fillOval(newBody.getX()*unit, newBody.getY()*unit, unit, unit);
        g.setColor(newBody.getColor());
        g.drawRect(0, 0, width*unit, height*unit);
        for(int x = 0; x < Long; x++) {
            g.setColor(snake.get(x).getColor());
            g.fillOval(snake.get(x).getX()*unit, snake.get(x).getY()*unit, unit, unit);            
        }

    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == up) {
            a = 1;
            run();
		}	
		else if(e.getSource() == down) {		
			a = -1;
			run();
        }	
		else if(e.getSource() == right) {		
			a = -2;
			run();
		}
        else if(e.getSource() == left) {		
        	a = 2;
        	run();
        }
		try { 
	    	URL cb; 
	    	File f = new File("C:\\Users/aa/eclipse-workspace/Snake/src/Snake/4.wav"); 
	    	cb = f.toURL(); 
	    	AudioClip aau; 
	    	aau = Applet.newAudioClip(cb); 
	    	aau.play();        	
	    	} catch (MalformedURLException e1) { 
	    	e1.printStackTrace(); 
	    	} 
   }
	
		
}
	

