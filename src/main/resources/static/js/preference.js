/*
 * ISchedule
 * adds a new preference to the database
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

document.getElementById('preference-form').addEventListener('submit', async e => {
    e.preventDefault();

    const course_id = document.getElementById('course_id').selectedOptions[0].value;
    const room_id = document.getElementById('room_id').selectedOptions[0].value;
    const start_time = document.getElementById('start-time').value;
    const end_time = document.getElementById('end-time').value;
    const reason = document.getElementById('reason').value;
    const payload = { userId: id, courseId: course_id, roomId: room_id, start: start_time, end: end_time, reason: reason };

    const resp = await fetch('/api/preferences', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });

    if (resp.ok) {
        alert('Preference successfully added!');
    } else {
        alert("Preference couldn't be added");
    }
});