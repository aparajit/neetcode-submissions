class Solution {
    public int[] twoSum(int[] nums, int target) {

        int index[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length;i++){
            int check = target - nums[i];
            if(map.containsKey(check)){
                index[0] = map.get(check);
                index[1] = i;
                return index;
            }
            map.put(nums[i], i);
        }
        return index;

        
    }
}