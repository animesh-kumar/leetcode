public class PalindromeNumber {
    public boolean isPalindrome(int x) {
	// Find the reverse of the number
	// and do an equality check.
	// If they match it's a palindrom else not
        int reverse = 0;
        int n = x;
        while (n > 0){
            reverse = reverse * 10 + (n % 10);
            n = n / 10;
        }
        return (reverse - x == 0)? true:false;
    }
}