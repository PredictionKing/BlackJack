import java.io.*;
import java.util.Properties;

public class BlackJackMain {
    public static void main(String [] args) {

        double Highscore = 0;

        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            Highscore = Double.valueOf(prop.getProperty("Highscore")) ;
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        try (OutputStream output = new FileOutputStream("config.properties")) {
            Properties prop = new Properties();
            System.out.println("old " + Highscore);
            System.out.println("Do you want to start the game? (y/N)");
            String yn = new java.util.Scanner(System.in).next();

            if(yn.equalsIgnoreCase("y")) {
                BlackJackSecond game = new BlackJackSecond(new Dealer(), new Player(), Highscore);
                System.out.println(game.Highscore);
                prop.setProperty("Highscore",String.valueOf(game.Highscore));
                prop.store(output,null);
            }
            else if(yn.equalsIgnoreCase("n")) {
                return;
            }

        } catch (IOException io) {
            io.printStackTrace();
        }



    }
}
