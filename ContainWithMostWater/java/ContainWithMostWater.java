public class ContainWithMostWater {
    public int maxArea(int[] height) {
        // We have to find two such lines so that the overall area is maximized
        // We can do this by using two pointers
        // First start both the pointers at the end
        // This area will have the maximum overall area initially
        // Check how much water this area can retain
        // Now move inwards and check if there is anything bigger
        if (height.length == 0) return 0;
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        // Run the loop till these pointers don't overlap
        while (i < j){
            // Take the minimum of both length since it needs to retain the water
            int l = Math.min(height[i], height[j]);
            // Width will be difference in the index
            int b = j - i;
            // We have to maximize the area.
            // Hence take the maximum of this area or whatever we already have
            maxArea = Math.max(maxArea, l * b);
            // Now we have to search for better
            // Check which one is lower in the low lengths
            // Try to improve that and hence move the pointer with lower length
            if (l == height[i]) i++;
            else j--;
        }
        return maxArea;
    }
}
