class TimeMap {
    private Map<String, Map<Integer, String>> map = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new HashMap<>())
           .put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        return map.getOrDefault(key, new HashMap<>())
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getKey() <= timestamp)
                  .max((a, b) -> Integer.compare(a.getKey(), b.getKey()))
                  .map(Map.Entry::getValue)
                  .orElse("");
    }
}
