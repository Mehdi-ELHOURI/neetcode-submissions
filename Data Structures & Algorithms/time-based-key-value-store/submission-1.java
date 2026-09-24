class TimeMap {
    private Map<String, Map<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        var val = map.getOrDefault(key, new HashMap<>());
        val.put(timestamp, value);
        map.put(key, val);
    }

    public String get(String key, int timestamp) {
        var timeValueMap = map.getOrDefault(key, new HashMap<>());
        return timeValueMap.keySet()
            .stream()
            .filter(prevTs -> prevTs <= timestamp)
            .max(Integer::compareTo)
            .map(prevTs -> map.get(key).get(prevTs))
            .orElse("");
    }
}
