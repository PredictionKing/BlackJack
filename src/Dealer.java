import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {

	
	String name;
	List<String> hand = new ArrayList<String>();
	boolean busted = false;
	
	public Dealer() {
		giveCard(2);
		showCards();
	}
	
	public void giveCard(int anzahl) {
		for(int i = 0; i<anzahl; i++) {
			hand.add(Integer.toString(ThreadLocalRandom.current().nextInt(1, 14)));
			for (int j = 0; j < hand.size(); j++) {
				if (hand.get(j).equals("11")) {
					hand.set(j, "B");
				} else if (hand.get(j).equals("12")) {
					hand.set(j, "D");
				} else if (hand.get(j).equals("13")) {
					hand.set(j, "K");
				}
			}
		}
	}
	
	public void showCards () {
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
