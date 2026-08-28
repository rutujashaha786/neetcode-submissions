class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map with SortedVersions as key
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(String key : map.keySet()){
            List<String> anagrams = map.get(key);
            result.add(anagrams);
        }

        return result;
    }
}
