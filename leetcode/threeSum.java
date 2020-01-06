class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<String> uniqueTriplet = new TreeSet<String>();
  
        for (int i = 0; i < nums.length - 1; i++)  
        { 
            
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < nums.length; j++)  
            { 
                int x = -(nums[i] + nums[j]); 
                if (s.contains(x))  
                { 
                    List<Integer> newTriplet = createNewTriplet(x, nums[i], nums[j]);
                    String tripletHash = createHashCode(newTriplet);
                    if (!uniqueTriplet.contains(tripletHash)) {
                        uniqueTriplet.add(tripletHash);
                        result.add(newTriplet);    
                    }
                }  
                else 
                { 
                    s.add(nums[j]); 
                } 
            } 
        } 
  
        
        return result;
    }
    
    private String createHashCode(List<Integer> triplet) {
        return triplet.get(0) + ":" + triplet.get(1) + ":" + triplet.get(2);
    }
   
    private List<Integer> createNewTriplet(int n1, int n2, int n3) {
        int max1 = n1;
        int max2 = 0;
        int max3 = 0;
        if (n2 >= n1 && n2 >= n3){
            max1 = n2;
            if (n1 >= n3) {
                max2 = n1;
                max3 = n3;
            } else {
                max2 = n3;
                max3 = n1;
            }
        }
        else if (n3 >= n1 && n3 >= n2) {
            max1 = n3;
            if (n1 >= n2) {
                max2 = n1;
                max3 = n2;
            } else {
                max2 = n2;
                max3 = n1;
            }
        } else {
             if (n2 >= n3) {
                max2 = n2;
                max3 = n3;
            } else {
                max2 = n3;
                max3 = n2;
            }
        }
            
        return new ArrayList<Integer>(Arrays.asList(max3, max2, max1));
         
    }
    
}