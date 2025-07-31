/*
 * ISchedule
 * This class is responsible for Preference data transfer from the frontend to the backend
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.dto;

public class PreferenceRequest {
    private String userId;
    private String courseId;
    private String roomId;
    private String start;
    private String end;
    private String reason;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }
    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
