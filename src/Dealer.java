import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dealer {

	
	String name;
	List<Integer> hand = new ArrayList<Integer>();
	boolean busted = false;
	
	public Dealer() {
		giveCard(2);
		System.out.println("[" + hand.get(0) + "]");
	}
	
	public void giveCard(int anzahl) {
		for(int i = 0; i<anzahl; i++) {
			hand.add(ThreadLocalRandom.current().nextInt(1, 14));
		}
		
	}
}
