class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map with FixedSize[26] array as key (but can't store array objects as common key due to obj reference change for each new int[] creation)

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];

            int[] arr = new int[26];

            for(char ch : str.toCharArray()){
                arr[ch - 'a']++;
            }

            String key = Arrays.toString(arr); //int[] array to string
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(String key : map.keySet()){
            List<String> anagrams = map.get(key);
            result.add(anagrams);
        }

        return result;
    }
}
