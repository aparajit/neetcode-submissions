class Solution {
    public boolean isAnagram(String s, String t) {
      int sLength = s.length();
      int tLength = t.length();
      if(sLength!=tLength) {
        return false;
      }
      char s1[] = s.toCharArray();
      char t1[] = t.toCharArray();
      HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
      HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
      for (char c : s1) {
        sMap.put(c, sMap.getOrDefault(c, 0) + 1);
      }
      for (char c : t1) {
         tMap.put(c, tMap.getOrDefault(c, 0) + 1);
      }
      return sMap.equals(tMap);
    }
}
