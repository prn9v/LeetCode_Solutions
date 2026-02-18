class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, turnedOn, 0, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    private void backtrack(List<String> ans, int turnedOn, int idx, int hours, int minutes) {
        if (turnedOn == 0) {
            if (hours < 12 && minutes < 60) {
                ans.add(hours + ":" + (minutes < 10 ? "0" + minutes : minutes));
            }
            return;
        }

        for (int i = idx; i < 10; i++) {
            if (i < 4) {
                backtrack(ans, turnedOn - 1, i + 1, hours + (1 << i), minutes);
            } else {
                backtrack(ans, turnedOn - 1, i + 1, hours, minutes + (1 << (i - 4)));
            }
        }
    }
}