/*
 * ISchedule
 * Repository class for the User entity, handles the database operations
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campus02.prg2_ischedule.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
}