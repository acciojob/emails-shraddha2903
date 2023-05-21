package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar=new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        this.calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        List<Meeting> sortedCalender = new ArrayList<>(List.copyOf(calendar));
        Collections.sort(sortedCalender,(x,y)->x.getEndTime().compareTo(y.getEndTime())
                );
        List<Meeting> maxMeeting = new ArrayList<>();
        LocalTime time_limit = sortedCalender.get(0).getEndTime();
        maxMeeting.add(sortedCalender.get(0));
        for(Meeting meeting : sortedCalender)
        {
            if(meeting.getStartTime().compareTo(time_limit)>0){
                maxMeeting.add(meeting);
                time_limit = meeting.getEndTime();
            }
        }

        return maxMeeting.size();
    }
}
