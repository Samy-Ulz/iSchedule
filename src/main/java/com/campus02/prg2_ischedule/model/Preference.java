/*
 * ISchedule
 * Model class for the Preference entity
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Room room;

    private LocalTime start;
    private LocalTime end;
    private String reason;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public LocalTime getStart() {
        return start;
    }
    public void setStart(LocalTime start) {
        this.start = start;
    }
    public LocalTime getEnd() {
        return end;
    }
    public void setEnd(LocalTime end) {
        this.end = end;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}
