class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> match = new HashMap<>();

        for (String s : strs) {
            int[] arr = new int[26];

            for (char c : s.toCharArray()) {
                arr[c - 'a']++;   // count frequency (important)
            }

            String key = Arrays.toString(arr);

            match.putIfAbsent(key, new ArrayList<>());
            match.get(key).add(s);
        }

        return new ArrayList<>(match.values());
    }
}