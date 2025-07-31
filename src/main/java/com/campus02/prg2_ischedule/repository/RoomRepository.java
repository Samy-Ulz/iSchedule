/*
 * ISchedule
 * Repository class for the Room entity, handles the database operations
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus02.prg2_ischedule.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}