boolean areFollowingPatterns(String[] strings, String[] patterns) {
    Map<String, String> map = new HashMap<>();
    for (int i=0; i<patterns.length; ++i){
        if (map.containsKey(patterns[i])){
            if (!map.get(patterns[i]).equals(strings[i]))
                return false;
        }
        else if (map.containsValue(strings[i])){
            return false;
        }
            
        map.put(patterns[i], strings[i]);
    }
    return true;
}