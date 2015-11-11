public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        // Keep a start and end
        // the increment should always be 1
        // else update start and end
        List<String> summary = new ArrayList<String>();
        if (nums.length <= 0) return summary;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i-1] == 1){
                end = nums[i];
            }else{
                // Add the current start and end to the list
                if(start != end){
                    summary.add(start+"->"+end);
                }else{
                    summary.add(""+start);
                }
                // Update the start and end to current pointer
                start = nums[i];
                end = nums[i];
            }
        }
        // The last pair of start and end doesn't get accounted for in the loop
        // Add it to the list
        if(start != end){
                    summary.add(start+"->"+end);
        }else{
            summary.add(""+start);
        }
        return summary;
    }
}