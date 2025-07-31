/*
 * ISchedule
 * This class is responsible for Course data transfer from the frontend to the backend
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.dto;

public class CourseRequest {
    private String title;
    private String date;
    private String start;
    private String end;
    private String roomId;

    // Getter und Setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
}
