import {showLogin} from './login.js';
import {showRegister} from './register.js';
import {showHome} from './home.js';
import {showGame} from "./game.js";

window.authErrorTimeout = 3000;

page('/', showHome);
page('/login', showLogin);
page('/register', showRegister);
page('/game/:pin', showGame);

page();
