package audioplayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundTest {

	public static void main(String[] args){
		
		System.out.println(System.getProperty("user.dir"));
		
		System.out.println("sample.au is playing...");
        Sound.play("resource/audio/sample.au");
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


       System.out.println(System.getProperty("user.dir"));
//		//System.setProperty("user.dir", System.getProperty("user.dir")+"\\Resources\\");
        System.out.println("ColdSteel.wav is playing...");
        Sound.play("resource/audio/ColdSteel.wav");
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        try {
            FileInputStream fileInputStream = new FileInputStream("resource/audio/song.mp3");
            Player mp3player = new Player(fileInputStream);
            System.out.println("Song.mp3 is playing...");
            mp3player.play();
          } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (JavaLayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
         
	}

}