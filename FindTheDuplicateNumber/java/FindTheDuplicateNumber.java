public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
       // The numbers will always be from 1 to N in a array of length N +1
       // This represents that we can work on the indices of the array
       // Since there is one and only once duplicate
       // This makes our work easier
       // Parse each value and multiply it's index by -1
       // None of the numbers should be negative by default as its's out of range
       // After every multiplication check if the number turrned positive
       // Only one number will turn positive since it was already multiplied by -1
       // and the duplicate was encountered already
       for (int i = 0; i < nums.length; i++){
           nums[Math.abs(nums[i])] *= -1;
           if (nums[Math.abs(nums[i])] > 0){
               // Number is turned negative already
               // The original number should have been positive
               return Math.abs(nums[i]);
           }
       }
       return -1;
    }
}
