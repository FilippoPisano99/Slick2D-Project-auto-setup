import java.util.*;
import java.io.*;
import org.newdawn.slick.*;
import java.net.*;


public class Main extends BasicGame
{    
    private static void setLibrary()
    {
        String ProjectPath = System.getProperties().getProperty("user.dir");       
        String dllPath = ProjectPath + File.separator + File.separator + "dll";
        System.setProperty("java.library.path", ".");
        System.setProperty("org.lwjgl.librarypath", dllPath);
    }

    public static void main(String[] args) 
    {
        setLibrary();
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new Main("Game"));
            appgc.setDisplayMode(500, 500, false);
            appgc.setTargetFrameRate(59);
            appgc.start();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public void update(GameContainer gc, int d) throws SlickException {
       
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        
    }

}