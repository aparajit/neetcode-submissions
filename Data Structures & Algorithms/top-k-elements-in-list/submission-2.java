

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count how many times each number appears
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 2. Create buckets where the index represents the frequency
        // We use an array of Lists (e.g., freq[3] contains numbers that appeared 3 times)
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // 3. Move numbers from the map into the corresponding frequency bucket
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            freq[c].add(num);
        }

        // 4. Build the result array by walking backward through the buckets
        int[] result = new int[k];
        int index = 0;

        // Start from the highest possible frequency (end of the array)
        for (int i = freq.length - 1; i > 0; i--) {
            for (int num : freq[i]) {
                result[index++] = num;
                
                // Once we've found 'k' elements, we are done
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}