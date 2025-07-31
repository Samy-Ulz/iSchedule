/*
 * ISchedule
 * This class is responsible for the preference management
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.controller;

import com.campus02.prg2_ischedule.dto.PreferenceRequest;
import com.campus02.prg2_ischedule.mapper.ModelMapper;
import com.campus02.prg2_ischedule.model.Course;
import com.campus02.prg2_ischedule.model.Preference;
import com.campus02.prg2_ischedule.model.Room;
import com.campus02.prg2_ischedule.model.User;
import com.campus02.prg2_ischedule.repository.CourseRepository;
import com.campus02.prg2_ischedule.repository.PreferenceRepository;
import com.campus02.prg2_ischedule.repository.RoomRepository;
import com.campus02.prg2_ischedule.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {
    @Autowired
    private PreferenceRepository repo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Preference> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Preference create(@RequestBody PreferenceRequest preferenceRequest) {
        User user = userRepository.findById(Integer.valueOf(preferenceRequest.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findById(Integer.valueOf(preferenceRequest.getCourseId()))
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        Room room = preferenceRequest.getRoomId() == null ? null : roomRepository.findById(Integer.valueOf(preferenceRequest.getRoomId()))
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Preference preference = ModelMapper.mapToPreference(preferenceRequest, user, course, room);
        repo.save(preference);
        return preference;
    }
}