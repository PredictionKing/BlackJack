import java.io.IOException;

public class BlackJackSecond {

	//int[] kartendeck = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	private Player player1;
	private Dealer dealer;
	private String input;

	double Highscore = 0;


	public BlackJackSecond(Dealer dealer, Player player) {
		this.player1 = player;
		this.dealer = dealer;
		wantAnotherCard();
		drawDealer();
	}

	public void startGame(Dealer dealer, Player player) {
		this.player1 = player;
		this.dealer = dealer;
		wantAnotherCard();
		drawDealer();
	}

	public void playAgain() {
		System.out.println("Do you want to play again? (Y/n)");
		String yn = new java.util.Scanner(System.in).next();
		if (yn.equalsIgnoreCase("Y")) {
			startGame(new Dealer(), new Player());
		} else if (yn.equalsIgnoreCase("N")) {
			return;
		}
	}

	public void wantAnotherCard() {
		if (player1.winorbust.matches("win|busted")) //TODO: Change Blackjack win mit Gewinnerkennung (WinOrLose)
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


	public void drawDealer() {
		dealer.bustedDealer();

		if (dealer.busted) {
			System.out.println("Dealer got busted!");
			dealer.showAllCards();
			Highscore++;
			System.out.println("Dein Highscore ist: " + Highscore);
			playAgain();
		}
		else if (dealer.resultDealer <= 21 && dealer.resultDealer > 16){
			WinOrLose();}
		else {
			dealer.giveCard(1);
			// drawDealer();
			dealer.resultDealer = 0;
			dealer.sumDealer();
			drawDealer();
		}
	}

	public void WinOrLose() {
		if (dealer.resultDealer > player1.resultplayer) {
			System.out.println("Dealer has won.");
			Highscore--;
			System.out.println("Dein Highscore ist: " + Highscore);
			dealer.showAllCards();
			playAgain();
		} else if (dealer.resultDealer < player1.resultplayer) {
			System.out.println("Player has won.");
			dealer.showAllCards();
			Highscore++;
			System.out.println("Dein Highscore ist: " + Highscore);
			playAgain();
		} else {
			System.out.println("It's even.");
			Highscore = Highscore + 0.5;
			System.out.println("Dein Highscore ist: " + Highscore);
			playAgain();

		}
	}
}

