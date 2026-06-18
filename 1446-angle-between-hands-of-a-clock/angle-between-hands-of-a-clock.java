class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = 0;
        double minAngle = 0;

        if(hour != 12) {
            hourAngle = (hour * 30) % 360;
        }

        if(minutes != 0) {
            minAngle = (minutes * 6) % 360;
        }

        hourAngle += minutes * 0.5;

        double min = Math.abs(hourAngle - minAngle);

        min = Math.min(min,360 - min);

        return min;
    }
}