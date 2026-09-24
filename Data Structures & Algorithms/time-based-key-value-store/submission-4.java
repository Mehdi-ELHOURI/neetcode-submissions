class TimeMap {
    private Map<String, List<TimestampValue>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimestampValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        var tsVals = map.getOrDefault(key, new ArrayList<>());
        int l = 0, r = tsVals.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (tsVals.get(m).timestamp() == timestamp) return tsVals.get(m).value();
            if (tsVals.get(m).timestamp() < timestamp) {
                res = tsVals.get(m).value();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private record TimestampValue(int timestamp, String value) {}
}
