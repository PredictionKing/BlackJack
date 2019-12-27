import javax.swing.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

	String name;
	List<String> hand = new ArrayList<String>();
	public String winorbust = "";
	int resultplayer=0;

	public Player() {
		giveCard(2);
	}

	public void giveCard(int anzahl) {
		for (int i = 0; i < anzahl; i++) {
			hand.add(Integer.toString(ThreadLocalRandom.current().nextInt(1, 14)));
			for (int j = 0; j < hand.size(); j++) {
				if (hand.get(j).equals("11")) {
					hand.set(j, "B");
				} else if (hand.get(j).equals("12")) {
					hand.set(j, "Q");
				} else if (hand.get(j).equals("13")) {
					hand.set(j, "K");
				} else if (hand.get(j).equals("1")) {
					hand.set(j, "Ass");
				}
			}
		}
		showCards();
		bustedPlayer();
	}

	public void showCards() {
		System.out.println("You have:");
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(hand.get(i));
			if (i < hand.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public void bustedPlayer() {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).matches("B|Q|K")) {
				resultplayer += 10;
			} else if (hand.get(i).matches("Ass")) {
				resultplayer += 11;
			} else {
				resultplayer += Integer.parseInt(hand.get(i));
			}
		}

		if (resultplayer > 21) {
			System.out.println("You got busted");
			System.out.println("You have:\n" + resultplayer);
			winorbust = "busted";
		}
		else if (resultplayer == 21) {
			System.out.println("Blackjack!");
			winorbust = "win";
		}
		else
			resultplayer = 0;
	}
}
