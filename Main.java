package Snake;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import java.io.*; 
import java.applet.Applet; 
import java.awt.Frame; 
import java.net.MalformedURLException; 
import java.net.URL; 

import javax.swing.JFrame;

public class Main extends Frame {
	public Main(){ 
		super(); 
		} 
	
    public static void main(String[] args) {
    	

        JFrame frame = new JFrame();
        frame.setBounds(0,0,620,695);
        Start SG = new Start();
        frame.add(SG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        try { 
        	URL cb; 
        	File f = new File("C:\\Users/aa/eclipse-workspace/Snake/src/Snake/2.wav"); 
        	cb = f.toURL(); 
        	AudioClip aau; 
        	aau = Applet.newAudioClip(cb); 
        	aau.loop();        	
        	} catch (MalformedURLException e) { 
        	e.printStackTrace(); 
        	} 
        	} 

    }

