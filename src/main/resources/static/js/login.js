/*
 * ISchedule
 * handles the communication between html and java backend for the login page
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

document.getElementById('login-form').addEventListener('submit', async e => {
     e.preventDefault(); // stops default form submission

     // Read fields by ID
     const email    = document.getElementById('email').value;
     const password = document.getElementById('password').value;

     const resp = await fetch('/api/auth/login', {
         method: 'POST',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify({ email, password })
     });

     // Send to the unified login endpoint
     if (resp.ok) {
         const data = await resp.json();
         alert('Login successful!');
         switch (data.role) {
             case 'Student':
                 window.location.href = '/student.html?id=' + data.id;
                 break;
             case 'Assistant':
                 window.location.href = '/assistant.html?id=' + data.id;
                 break;
             case 'Administrator':
                 window.location.href = '/admin.html?id=' + data.id;
                 break;
             default:
                 alert('Login failed – Unknown Role ' + data.role);
                 break;
         }
     } else {
         alert('Login failed – please check your credentials');
     }
});