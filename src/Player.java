import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

	String name;
	List<Integer> hand = new ArrayList<Integer>();
	boolean busted = false;
	
	public Player() {
		
	}
	
	public void giveCard(int anzahl) {
		for(int i = 0; i<anzahl; i++) {
			hand.add(ThreadLocalRandom.current().nextInt(1, 14));
		}
		System.out.println(hand);
	}
	
}
