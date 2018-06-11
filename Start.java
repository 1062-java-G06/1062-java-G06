package Snake;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JPanel  implements ActionListener{

	private int b;
	public int Speed;
	
	private JButton easy;
	private JButton normal;
	private JButton difficult;
	private JLabel  title;
	
	private JPanel selectPanel;
	
	public Start() {
	
		this.setLayout(new BorderLayout());
		selectPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
	    title = new JLabel("SNAKE");
		title.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		selectPanel.add(title,gbc);
		
		easy = new JButton("EASY");
		//easy.setBounds(300, 100,100 ,100);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		easy.addActionListener(this);
		selectPanel.add(easy,gbc);
	    
	    normal = new JButton("NORMAL");
	    //easy.setBounds(300, 300,100 ,100);
	    gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
	    normal.addActionListener(this);
	    selectPanel.add(normal,gbc);
	    
	    difficult = new JButton("DIFFICULT");
	    //easy.setBounds(300, 500,100 ,100);
	    gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
	    difficult.addActionListener(this);
	    selectPanel.add(difficult,gbc);
	    
	    add(selectPanel,BorderLayout.CENTER);
	    selectPanel.setBackground(Color.BLACK);
        
	}
	
	
	public void execute()  {
		
		switch(b) {
		
		case 1:
			
			Speed = 1000;
			break;
			
        case 2:
			
			Speed = 500;
			break;
			
        case 3:
	
	        Speed = 100;
	        break;
		}
		
	
		JFrame frame2 = new JFrame();
        frame2.setBounds(0,0,620,695);
        Map.setspeed(Speed);
        System.out.println("123"+ Speed );
        Map SG = new Map();
        frame2.add(SG);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        
        
        try { 
        	URL cb; 
        	File f = new File("C:\\Users/aa/eclipse-workspace/Snake/src/Snake/3.wav"); 
        	cb = f.toURL(); 
        	AudioClip aau; 
        	aau = Applet.newAudioClip(cb); 
        	aau.loop();        	
        	} catch (MalformedURLException e) { 
        	e.printStackTrace(); 
        	} 
        
        	} 
	
	
	
 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == easy ) {
			
			b = 1;
			execute();
			
		}else if (e.getSource() == normal ) {
			
			b = 2;
			execute();
			
		}else if(e.getSource() == difficult ) {
			
			b = 3;
			execute();
			
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
