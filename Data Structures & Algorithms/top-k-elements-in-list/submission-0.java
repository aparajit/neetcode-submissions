

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        count.forEach((num, c) -> freq[c].add(num));

        List<Integer> result = new ArrayList<>();
        

        for (int i = freq.length - 1; i > 0 && result.size() < k; i--) {
            freq[i].stream()
                   .limit(k - result.size())
                   .forEach(result::add);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}