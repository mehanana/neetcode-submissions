/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
        overlap = false
        no overlap = true
        */
        if (intervals.isEmpty()) {
            return true;
        }
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Interval toCompare = intervals.getFirst();
        for (int i = 1; i < intervals.size(); i++) {
            if (toCompare.end > intervals.get(i).start) {
                return false;
            } else {
                toCompare = intervals.get(i);
            }
        }
        return true;

    }
}
