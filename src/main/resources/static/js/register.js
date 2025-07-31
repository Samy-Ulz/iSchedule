/*
 * ISchedule
 * handles the communication between html and java backend for the register page
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

document.getElementById('registerForm').addEventListener('submit', async e => {
    e.preventDefault();

    const username = document.getElementById('regUsername').value;
    const email    = document.getElementById('regEmail').value;
    const password = document.getElementById('regPassword').value;
    const password2= document.getElementById('regPassword2').value;
    const roleVal  = document.getElementById('regRole').value;

    if (password !== password2) {
        alert('Passwords do not match. Please retype.');
        return;
    }

    const endpoint = '/api/users';

    const payload = { name: username, email, password, role: roleVal };

    try {
        const response = await fetch(endpoint, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });

        if (response.ok) {
            alert('Registration successful! You can now log in.');
            window.location.href = '/';
        } else {
            const errorData = await response.json().catch(() => null);
            alert('Registration failed: ' + (errorData?.message || response.statusText));
        }
    } catch (err) {
        console.error('Network error:', err);
        alert('Unable to connect to the server. Please try again later.');
    }
});