/*
 * ISchedule
 * checks validity of time input
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

function checkTime(timeInput) {
    const [hours, minutes] = timeInput.split(":").map(Number);
    const time = new Date();
    time.setHours(hours, minutes, 0, 0);

    const start = new Date();
    start.setHours(7, 0, 0, 0); // 07:00 Uhr

    const end = new Date();
    end.setHours(21, 0, 0, 0); // 21:00 Uhr

    if(!(time >= start && time <= end)) {
        alert("Only timeslots between 07:00 and 21:00 are allowed");
        return false;
    }
}