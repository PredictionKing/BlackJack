
public class BlackJackSecond {

	int[] kartendeck = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	private Player player1;
	private Dealer dealer;
	
	public BlackJackSecond(Player player, Dealer dealer) {
		this.dealer = dealer;
		this.player1 = player;
		this.player1.giveCard(2);
	}
	
	
	
	
}
