/*
 * ISchedule
 * This class is responsible for the course management
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.controller;

import com.campus02.prg2_ischedule.dto.CourseRequest;
import com.campus02.prg2_ischedule.mapper.ModelMapper;
import com.campus02.prg2_ischedule.model.Course;
import com.campus02.prg2_ischedule.model.Room;
import com.campus02.prg2_ischedule.repository.CourseRepository;
import com.campus02.prg2_ischedule.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseRepository repo;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Course> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Course create(@RequestBody CourseRequest courseRequest) {
        Room room = roomRepository.findById(Integer.valueOf(courseRequest.getRoomId()))
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Course course = ModelMapper.mapToCourse(courseRequest, room);
        repo.save(course);
        return course;
    }
}
