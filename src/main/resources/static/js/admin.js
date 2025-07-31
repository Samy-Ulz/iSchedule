/*
 * ISchedule
 * handles the communication between html and java backend for the admin page
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

const params = new URLSearchParams(window.location.search);
const id = params.get('id');

document.getElementById('room-form').addEventListener('submit', async e => {
     e.preventDefault();

     const room_name = document.getElementById('room_name').value;
     const room_capacity = document.getElementById('room_capacity').value;
     const payload = { name: room_name, capacity: room_capacity };

     const resp = await fetch('/api/rooms', {
         method: 'POST',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify(payload)
     });

     if (resp.ok) {
         alert('Room successfully added!');
     } else {
         alert("Room couldn't be added");
     }
});

document.getElementById('course-form').addEventListener('submit', async e => {
    e.preventDefault();

    const course_name = document.getElementById('course_name').value;
    const course_date = document.getElementById('course-date').value;
    const start_time = document.getElementById('course-start-time').value;
    const end_time = document.getElementById('course-end-time').value;
    const room_id = document.getElementById('course-room_id').selectedOptions[0].value;
    const payload = { title: course_name, date: course_date, start: start_time, end: end_time, roomId: room_id };

    const resp = await fetch('/api/course', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });

    if (resp.ok) {
        alert('Course successfully added!');
    } else {
        alert("Course couldn't be added");
    }
});

function load() {
    loadCourses();
    loadRooms();
    loadCourseRooms();
    loadUserInfo();
}

function loadCourses() {
    fetch('/api/course')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('course_id');
            select.innerHTML = '';
            data.forEach(course => {
                const item = document.createElement('option');
                item.value = course.id;
                item.textContent = course.title;
                select.appendChild(item);
            });
        });
}

function loadRooms() {
    fetch('/api/rooms')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('room_id');
            select.innerHTML = '';
            data.forEach(room => {
                const item = document.createElement('option');
                item.value = room.id;
                item.textContent = room.name;
                select.appendChild(item);
            });
        });
}

function loadCourseRooms() {
    fetch('/api/rooms')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('course-room_id');
            select.innerHTML = '';
            data.forEach(room => {
                const item = document.createElement('option');
                item.value = room.id;
                item.textContent = room.name;
                select.appendChild(item);
            });
        });
}

function loadUserInfo() {
    fetch('/api/users/' + id)
        .then(response => response.json())
        .then(user => {
            const greeting = document.getElementById("greeting");
            greeting.textContent = "Welcome, " + user.name;
        })
        .catch(error => {
            console.error("Fehler beim Laden des Benutzers:", error);
        });
}