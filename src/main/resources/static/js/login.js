import * as api from "./util.js";

let template = Handlebars.compile(
    `
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2 class="text-center">Login</h2>
                <form id="loginForm">
                    <p id="loginError">All fields are required!</p>
                    <div class="form-group">
                        <label for="loginUsername">Username: </label>
                        <input type="text" class="form-control" id="loginUsername" name="username">
                    </div>
                    <div class="form-group">
                        <label for="loginPassword">Password: </label>
                        <input type="password" class="form-control" id="loginPassword" name="password">
                    </div>
                    <button type="submit" class="btn btn-success">Login</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>`)

export async function showLogin() {
    if(await api.validCredentials())
        page('/');

    $('#container').html(template());
    addEventListeners();
}

function addEventListeners() {
    let timeout = null;
    $("#loginForm").submit(async e => {
        e.preventDefault();
        let formData = new FormData(e.target);
        let username = formData.get("username").trim();
        let password = formData.get("password").trim();
        if (username == "" || password == "") {
            $("#loginError").show();
            if (timeout)
                clearTimeout(timeout);
            timeout = setTimeout(() => {
                $("#loginError").show();
            }, window.authErrorTimeout);
        } else {
            let response = await api.login(username, password);
            if (response.message == "Login successful!") {
                page.redirect('/');
            } else {
                alert(response.message);
            }
            e.target.reset();
        }
    });
}