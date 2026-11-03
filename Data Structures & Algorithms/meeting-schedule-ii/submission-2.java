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
    public int minMeetingRooms(List<Interval> intervals) {
        /*
        - look at interval
        - if it overlaps with any existing ones in list, then put in new room
        - if it doesn't overlap, then put in current room

        - hashmap of room key to the list of intervals it can hold

        Sort intervals by start.
        Keep a min-heap of end times, one per room in use.
        For each meeting, compare its start to the heap’s smallest end time and either reuse that room or open a new one.
        */


        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (Interval i : intervals) {
            if (!endTimes.isEmpty() && endTimes.peek() <= i.start) {
                endTimes.poll();
            }
            endTimes.add(i.end);
        }

        return endTimes.size();
    }
}
