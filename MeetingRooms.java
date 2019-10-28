class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // if a person could attend all the meetings
       if (intervals == null || intervals.length == 0) {
           return false;
       }

       if (intervals.length == 1) {
           return true;
       }
       
       Arrays.sort(intervals, new Comparator<int[]>(){
           @Override
           public int compare(int[] i1, int[] i2) {
               return i1[0] - i2[0];
           }
       });
       
       // for (int i = 0; i < intervals.length; i++) {
       //     System.out.println(intervals[i][0]);
       // }

       for (int i = 0; i < intervals.length-1; i++) {
           if (intervals[i][1] > intervals[i+1][0]) {
               return false;
           }
       }
       return true;
   }
}
