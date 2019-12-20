import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {

	
	String name;
	List<Integer> hand = new ArrayList<Integer>();
	boolean busted = false;
	
	public Dealer() {
		giveCard(2);
		showCards();
	}
	
	public void giveCard(int anzahl) {
		for(int i = 0; i<anzahl; i++) {
			hand.add(ThreadLocalRandom.current().nextInt(1, 14));
		}
		
	}
	
	public void showCards() {
		System.out.println("The Dealer shows:");
		System.out.println(hand.get(0));
	}
	
	public void showAllCards() {
		System.out.println("The Dealer shows:");
		for(int i=0;i<hand.size();i++) {	
			System.out.print(hand.get(i));
			if(i<hand.size()-1) {
				System.out.print(", ");
			}
	}
	System.out.println();
	}
}
