import java.io.IOException;

public class BlackJackSecond {

	int[] kartendeck = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	private Player player1;
	private Dealer dealer;
	private String input;
	
	public BlackJackSecond(Dealer dealer, Player player) {
		this.player1 = player;
		this.dealer = dealer;
		wantAnotherCard();
	}
	
	public void startGame(Dealer dealer, Player player) {
		this.player1 = player;
		this.dealer = dealer;
		wantAnotherCard();
	}
	
	public void playAgain() {
		System.out.println("Do you want to play again? (Y/n)");
		String yn = new java.util.Scanner(System.in).next();
		if(yn.equalsIgnoreCase("Y")) {
			startGame(new Dealer(), new Player());
		}else if (yn.equalsIgnoreCase("N")) {
			return;
		}
	}
	
	public void wantAnotherCard() {
		if (player1.winorbust.matches("win|busted"))
			playAgain();
		else {
			System.out.println("Do you want another card? (y/N)");
			input = new java.util.Scanner(System.in).next();
			if (input.equalsIgnoreCase("y")) {
				player1.giveCard(1);
				wantAnotherCard();
			} else if (input.equalsIgnoreCase("n")) {
				dealer.showAllCards();

			}
		}
	}
	
	
}
