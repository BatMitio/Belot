import * as api from "./util.js";

let loggedTemplate = Handlebars.compile(
    `
        <div id="welcomeMessage">
            <h2 class="text-center">Welcome, {{username}}!</h2>
            <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form id="joinGameForm">
                    <div class="form-group">
                        <label for="roomPin" class="text-center">Room PIN: </label>
                        <input type="text" class="form-control" id="roomPin" name="roomPin">
                        <input type="submit" class="form-control btn btn-primary" value="Join">
                    </div>
                </form>
            </div>
            <div class="col-md-4"></div>
            </div>
            
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 text-center">
                    <button id="createGameButton" class="btn btn-success">Create game!</button>
                    <button id="logoutButton" class="btn btn-danger">Logout</button>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>`);

let anonymousTemplate = Handlebars.compile(
    `
        <div id="welcomeMessage" class="row">
            <h2 class="text-center">Welcome, stranger!</h2>
            <h4 class="text-center">In order to participate in this platform you need to Sign in/up!</h4>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 text-center">
                    <button id="signIn" class="btn btn-success">Sign in</button>
                    <button id="signUp" class="btn btn-success">Sign up</button>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    `);


export async function showHome() {
    if (await api.validCredentials()) {
        showLogged(localStorage.getItem("username"));

    } else {
        localStorage.clear();
        showAnonymous();
    }
}

function showLogged(username) {
    $('#container').html(loggedTemplate({username: username}));
    $("#joinGameForm").submit(async e => {
        e.preventDefault();
        let formData = new FormData(e.target);
        let gamePin = formData.get("roomPin").trim();
        let response = await api.post('/join', {gamePin});
        if (response.message == "Successfully joined!") {
            page('/game/' + gamePin);
        }
        alert(response.message);
    });
    $("#createGameButton").click(async e => {
        e.preventDefault();
        let response = await api.get('/create');
        if(response.message == "Successfully created!"){
            page('/game/' + response.data.gamePin);
            return;
        }
        alert(response.message);
    });
    $("#logoutButton").click(async e => {
        await api.logout();
        page('/');
    })

}

function showAnonymous() {
    $('#container').html(anonymousTemplate());
    $('#signIn').click(e => {
        e.preventDefault();
        page('/login');
    });
    $('#signUp').click(e => {
        e.preventDefault();
        page('/register');
    });
}