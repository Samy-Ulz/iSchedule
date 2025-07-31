/*
 * ISchedule
 * Maps the fields of the DTOs to the model classes
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.mapper;

import com.campus02.prg2_ischedule.dto.CourseRequest;
import com.campus02.prg2_ischedule.dto.PreferenceRequest;
import com.campus02.prg2_ischedule.model.Course;
import com.campus02.prg2_ischedule.model.Preference;
import com.campus02.prg2_ischedule.model.Room;
import com.campus02.prg2_ischedule.model.User;
import com.campus02.prg2_ischedule.repository.RoomRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class ModelMapper {

    public static Course mapToCourse(CourseRequest courseRequest, Room room) {
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        course.setDate(LocalDate.parse(courseRequest.getDate()));
        course.setStart(LocalTime.parse(courseRequest.getStart()));
        course.setEnd(LocalTime.parse(courseRequest.getEnd()));
        course.setRoom(room);
        return course;
    }

    public static Preference mapToPreference(PreferenceRequest preferenceRequest, User user, Course course, Room room) {
        Preference preference = new Preference();
        preference.setUser(user);
        preference.setRoom(room);
        preference.setCourse(course);
        preference.setStart(isEmpty(preferenceRequest.getStart()) ? null : LocalTime.parse(preferenceRequest.getStart()));
        preference.setEnd(isEmpty(preferenceRequest.getEnd()) ? null : LocalTime.parse(preferenceRequest.getEnd()));
        preference.setReason(preferenceRequest.getReason());
        return preference;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
