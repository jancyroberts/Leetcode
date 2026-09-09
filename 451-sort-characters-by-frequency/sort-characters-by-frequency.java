class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        String result = "";
        Map<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, 
                        LinkedHashMap::new               
                ));
        for(char key : sortedMap.keySet()){
            result+=String.valueOf(key).repeat(sortedMap.get(key));
        }
        return result;
    }
}