
class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a);

        int days = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            days += duration;
            pq.add(duration);

            if (lastDay < days) {
                days -= pq.poll();
            }
        }
        return pq.size();
    }
}