class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> match = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            match.putIfAbsent(key, new ArrayList<>());
            match.get(key).add(s);
        }

        return new ArrayList<>(match.values());
    }
}