class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String q : queries) {
            for (String d : dictionary) {
                int edit = getEdit(q,d);
                if (edit <= 2) {
                    ans.add(q);
                    break;
                }
            }
        }

        return ans;
    }


    private int getEdit(String q, String d) {
        int edit = 0;
        for (int i = 0; i < q.length(); i++) {
            if (q.charAt(i) != d.charAt(i)) {
                edit++;
            }
        }

        return edit;
    }
}