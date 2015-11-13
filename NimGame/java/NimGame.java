public class NimGame {
	public boolean canWinNim(int n) {
		// A can lose only if the number is divisible by 4
		// In such a case no matter what path A follows, he will lose.
		// In any other case, strategically there are chances to win
		//  but for divisible by 4 it's impossible.
		return (n % 4 != 0);

	}
}
