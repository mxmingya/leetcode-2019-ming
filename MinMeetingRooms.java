public class MinMeetingRooms {
        public int minMeetingRooms(int[][] intervals) {
            int res = 0;
            if (intervals == null || intervals.length == 0) {
                return res;
            }

            int size = intervals.length;
            int[] starts = new int[size];
            int[] ends = new int[size];
            for (int i = 0; i < size; i++) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
            }

            Arrays.sort(starts);
            Arrays.sort(ends);
            int endIndex = 0 ;
            

            for (int i = 0; i < size && endIndex < size; i++) {
                if (ends[endIndex] > starts[i]) {
                    res++;
                }
                else {
                    endIndex++;
                }
            }
            return res;
    }
}
