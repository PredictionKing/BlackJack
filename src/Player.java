import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

	String name;
	List<Integer> hand = new ArrayList<Integer>();
	boolean busted = false;
	
	public Player() {
		giveCard(2);
	}
	
	public void giveCard(int anzahl) {
		for(int i = 0; i<anzahl; i++) {
			hand.add(ThreadLocalRandom.current().nextInt(1, 14));
		}
		showCards();
	}
	
	public void showCards() {
		System.out.println("You have:");
		for(int i=0;i<hand.size();i++) {	
				System.out.print(hand.get(i));
				if(i<hand.size()-1) {
					System.out.print(", ");
				}
		}
		System.out.println();
	}
}
