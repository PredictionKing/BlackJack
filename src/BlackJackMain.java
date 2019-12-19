public class BlackJackMain {
    public static void main(String [] args) {

    System.out.println("Do you want to start the game? (y/N)");
    String yn = new java.util.Scanner(System.in).next();
    
    if(yn.equalsIgnoreCase("y")){
    	BlackJackSecond game = new BlackJackSecond(new Player(), new Dealer());
    }else if(yn.equalsIgnoreCase("n")) {
		return;
	}

    
    }
     
}
