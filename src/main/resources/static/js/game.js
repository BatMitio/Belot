import * as api from "./util.js";

let template = Handlebars.compile(`
<div class="row">
    <div class="col-sm-1">
        <button class="btn-success" id="toggleFullscreen">Go fullscreen</button>        
    </div>
</div>
<div class="imageHolder text-center">
    <img id="8" class="image" src="/images/2C.png"/>
    <img id="7" class="image" src="/images/AS.png"/>
    <img id="6" class="image" src="/images/KH.png"/>
    <img id="5" class="image" src="/images/QH.png"/>
    <img id="4" class="image" src="/images/2C.png"/>
    <img id="3" class="image" src="/images/AS.png"/>
    <img id="2" class="image" src="/images/KH.png"/>
    <img id="1" class="image" src="/images/QH.png"/>
</div>
`);

let radius = (15/32) * window.innerWidth;
let cardsAngleDiff = 10;

export async function showGame(ctx) {

    let gamePin = ctx.params.pin;
    let response = await api.post('/join', {gamePin});
    if (response.message != "Successfully joined!") {
        alert(response.message);
        return;
    }
    $('#container').html(template());
    $('#toggleFullscreen').click(e => {
        console.log("here");
        toggleFullScreen(document.body);
    });

    $('.imageHolder').click(e => {
        anime({
            targets: '.image',
            translateX: function (el, i, l){
                return Math.cos(rad(getAngle(i, l))) * radius;
            },
            translateY: function (el, i, l){
                return -Math.sin(rad(getAngle(i, l))) * radius + radius;
            },
            easing: 'easeInOutElastic',
            rotate: function (el, i, l) {
                console.log(getAngle(i, l));
                return 90 - getAngle(i, l) + cardsAngleDiff / 2;
            },
            duration: 700,
            delay: anime.stagger(20),
        });
    });
}

function rad(deg){
    return (deg / 180) * Math.PI;
}

function toggleFullScreen(el) {
    el.requestFullscreen();
}

function getAngle(i, l){
    return (l / 2 - i) * cardsAngleDiff + 90 - cardsAngleDiff / 2;
}