
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
	
	public void wantAnotherCard() {
		if (player1.winorbust.matches("win|busted"))
			return;
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
