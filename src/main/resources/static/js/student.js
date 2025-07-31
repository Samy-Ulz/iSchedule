/*
 * ISchedule
 * handles the communication between html and java backend for the student page
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

const params = new URLSearchParams(window.location.search);
const id = params.get('id');
const date = new Date();
const monday = new Date(date);
monday.setDate(date.getDate() - (date.getDay() === 0 ? 6 : date.getDay() - 1));
const weekdays = ["Mon", "Tue", "Wed", "Thu", "Fri"];

function load() {
    loadCourses();
    loadUserCourses();
    loadUserInfo();
}

function loadUserCourses() {
    fetch('/api/users/' + id + '/courses')
        .then(response => response.json())
        .then(data => {
            data.forEach(course => {
                for (let i = 0; i < 5; i++) {
                    const day = new Date(monday);
                    day.setDate(monday.getDate() + i);
                    const localDateString = formatDate(day);
                    if (localDateString === course.date) {
                        let start = course.start.split(':')[0];
                        let end = course.end.split(':')[0];
                        for (let j = start; j < end; j++) {
                            const td = document.getElementById(weekdays[i] + '-' + j);
                            td.innerHTML = course.title + "<br>(" + start + "-" + end + ")";
                            td.style.backgroundColor = '#b43939';
                            td.style.textAlign = 'center';
                            td.style.verticalAlign = 'middle';
                        }
                    }
                }
            });
        });
}

function formatDate(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
}

document.getElementById('enroll-form').addEventListener('submit', async e => {
    e.preventDefault();

    const course_id = document.getElementById('course_id').selectedOptions[0].value;

    const resp = await fetch('/api/users/' + id + '/enroll/' + course_id, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' }
    });

    if (resp.ok) {
        alert('Successfully enrolled!');
        loadUserCourses();
    } else {
        alert("Couldn't enroll");
    }
});

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