/*
 * ISchedule
 * This class is responsible for the room management
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.campus02.prg2_ischedule.model.Room;
import com.campus02.prg2_ischedule.repository.RoomRepository;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomRepository repo;

    @GetMapping
    public List<Room> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Room create(@RequestBody Room r) {
        return repo.save(r);
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable int id, @RequestBody Room r) {
        r.setId(id);
        return repo.save(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}