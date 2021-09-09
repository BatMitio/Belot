import * as api from "./util.js";

let template = Handlebars.compile(
    `
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2 class="text-center">Register</h2>
                <form id="registrationForm">
                    <p id="registrationError">All fields are required!</p>
                    <div class="form-group">
                        <label for="registerUsername">Username: </label>
                        <input type="text" class="form-control" id="registerUsername" name="username">
                        <small id="unavailable" class="form-text text-muted" style="display: none;">Username not available!</small>
                    </div>
                    <div class="form-group">
                        <label for="registerPassword">Password: </label>
                        <input type="password" class="form-control" id="registerPassword" name="password">
                    </div>
                    <div class="form-group">
                        <label for="rePass">Repeat password: </label>
                        <input type="password" class="form-control" id="rePass" name="rePass">
                    </div>
                    <button type="submit" class="btn btn-success">Register</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>`);

export async function showRegister() {
    if(await api.validCredentials())
        page('/');

    $('#container').html(template());
    let registerTimeout = null;
    $("#registrationForm").submit(async e => {
        e.preventDefault();
        let formData = new FormData(e.target);
        e.target.reset();
        let username = formData.get("username").trim();
        let password = formData.get("password").trim();
        let rePass = formData.get("rePass").trim();
        if (username == "" || password == "" || rePass == "" || password != rePass) {
            $("#registrationError").show();
            if (registerTimeout)
                clearTimeout(registerTimeout);
            registerTimeout = setTimeout(() => {
                $("#registrationError").show();
            }, window.authErrorTimeout);
        } else {
            let response = await api.register(username, password);
            if (response.message == "Registration successful!") {
                page.redirect('/');
            } else {
                alert(response.message);
            }
        }
    });
    $('#registerUsername').on('input', async e => {
        let username = e.target.value;
        let usernameAvailable = await api.post('/username_available', {username: username});
        if (usernameAvailable.message == 'Username available!') {
            $('#unavailable').hide();
            e.target.classList.add('is-valid');
            e.target.classList.remove('is-invalid');
        } else {
            $('#unavailable').show();
            e.target.classList.add('is-invalid');
            e.target.classList.remove('is-valid');
        }
    });
}