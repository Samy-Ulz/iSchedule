/*
 * ISchedule
 * Repository class for the Preference entity, handles the database operations
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.repository;

import com.campus02.prg2_ischedule.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
