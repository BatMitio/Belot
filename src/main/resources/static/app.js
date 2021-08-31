import * as api from '/util.js';

let loginTimeout, registerTimeout, errorTimeout = 3000;

init();
await showHome();

async function showHome(){
    if(await api.validCredentials()){
        $("#clientName").text(localStorage.getItem("username"));
        $("#welcomeMessage").show();
        $("#authenticationSection").hide();
    } else {
        localStorage.clear();
        $("#welcomeMessage").hide();
        $("#authenticationSection").show();
    }
}

function init(){
    $("#loginForm").submit(async e => {
        e.preventDefault();
        let formData = new FormData(e.target);
        let username = formData.get("username").trim();
        let password = formData.get("password").trim();
        if (username == "" || password == "") {
            $("#loginError").show();
            if (loginTimeout)
                clearTimeout(loginTimeout);
            loginTimeout = setTimeout(() => {
                $("#loginError").show();
            }, errorTimeout);
        } else {
            let response = await api.login(username, password);
            if(response.message = "Login successful!"){
                showHome();
            }
            else {
                alert(response.message);
            }
            e.target.reset();
        }
    });
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
            }, errorTimeout);
        } else {
            let response = await api.register(username, password);
            if(response.message = "Registration successful!"){
                showHome();
            }
            else {
                alert(response.message);
            }

        }
    });
    $("#logoutButton").click(async e => {
        e.preventDefault();
        await api.logout();
        showHome();
    });
    $("#joinGameForm").submit(async e => {
        e.preventDefault();
        let formData = new FormData(e.target);
        let gamePin = formData.get("roomPin").trim();
        let response = await api.post('/join', {gamePin});
        if(response.message == "Successfully joined!"){
            window.href = '/game';
        }
        alert(response.message);
    });
    $("#createGameButton").click(e => {
        e.preventDefault();
    });
}