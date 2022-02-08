import java.net.URL;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound 
{
    private Clip clip;
    private URL url;
    
    public Sound(String fileName) 
    {
        try
	 	{
			url = this.getClass().getClassLoader().getResource(fileName);
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			
	 	}
	 	catch (Exception exc)
	 	{
		 	exc.printStackTrace(System.out);
	 	}
    }
    
    public void play()
    {
        clip.start();
    }
    
    public void stop()
    {
        clip.close();
    }
    
    public boolean isPlaying()
    {
    	return clip.isRunning();
    }
    
}
    
    
