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
		System.out.println("\nYou have:");
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(hand.get(i));
			if (i < hand.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();



		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			switch (hand.get(i)){
				case "K":
					sum = 10 + sum;
					break;
				case "Q":
					sum = 10 + sum;
					break;
				case "B":
					sum = 10 + sum;
					break;
				case "10":
					sum = 10 + sum;
					break;
				case "9":
					sum = 9 + sum;
					break;
				case "8":
					sum = 8 + sum;
					break;
				case "7":
					sum = 7 + sum;
					break;
				case "6":
					sum = 6 + sum;
					break;
				case "5":
					sum = 5 + sum;
					break;
				case "4":
					sum = 4 + sum;
					break;
				case "3":
					sum = 3 + sum;
					break;
				case "2":
					sum = 2 + sum;
					break;
				case "1":
					sum = 1 + sum;
					break;
				case "Ass":
					if (sum <= 11) {
						sum = sum + 11; }
					else
						sum = sum + 1;
					break;
			}
		}
		if (sum == 13) {
			System.out.println("Oh! Lucky "+sum+"!");
		}
		else
			System.out.println("A total of: " + sum);


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
