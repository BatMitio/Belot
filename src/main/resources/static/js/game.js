import * as api from "./util.js";

let template = Handlebars.compile(`<div class="line">
    <div class="imageHolder">
<!--        <img id="8" class="image" src="/images/2C.png"/>-->
        <img id="7" class="image" src="/images/AS.png"/>
        <img id="6" class="image" src="/images/KH.png"/>
        <img id="5" class="image" src="/images/QH.png"/>
        <img id="4" class="image" src="/images/2C.png"/>
        <img id="3" class="image" src="/images/AS.png"/>
        <img id="2" class="image" src="/images/KH.png"/>
        <img id="1" class="image" src="/images/QH.png"/>
    </div>
</div>
`);

export async function showGame(ctx) {
    $('body').click(e => {
        toggleFullScreen(document.body);
    });
    let gamePin = ctx.params.pin;
    let response = await api.post('/join', {gamePin});
    if (response.message != "Successfully joined!") {
        alert(response.message);
        return;
    }
    $('#container').html(template());
    let radius = 600;
    let cardsAngleDiff = 10;

    $('.imageHolder').click(e => {
        anime({
            targets: '.image',
            translateX: function (el, i, l){
                return Math.cos(rad((l / 2 - i) * cardsAngleDiff + 90 - cardsAngleDiff / 2)) * radius;
            },
            translateY: function (el, i, l){
                return -Math.sin(rad((l / 2 - i) * cardsAngleDiff + 90 - cardsAngleDiff / 2)) * radius + radius;
            },
            easing: 'easeInOutElastic',
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