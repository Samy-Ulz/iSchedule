/*
 * ISchedule
 * This class is responsible for the user management
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.controller;

import com.campus02.prg2_ischedule.model.Course;
import com.campus02.prg2_ischedule.model.User;
import com.campus02.prg2_ischedule.repository.CourseRepository;
import com.campus02.prg2_ischedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setId(0);
        User saved = userRepository.save(user);
        return ResponseEntity
                .created(URI.create("/api/users/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/{userId}/courses")
    public Set<Course> getCoursesById(@PathVariable Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getCourses();
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/enroll/{courseId}")
    public User addCourse(@PathVariable Integer userId, @PathVariable Integer courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        user.getCourses().add(course);
        return userRepository.save(user);
    }
}

