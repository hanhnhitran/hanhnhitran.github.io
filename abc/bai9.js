// let currentTime = document.getElementById("currentTime");
// let days = document.getElementById("days");
// let hrs = document.getElementById("hours");
// let mins = document.getElementById("minutes");
// let secs = document.getElementById("seconds");

setInterval(countdown, 1000);

function countdown() {
    let now = new Date();

    currentTime.textContent = now.toLocaleString();

    let newYear = new Date("January 1, 2024");
    let nextYear = now.getFullYear() + 1;
    newYear.setFullYear(nextYear);

    let time = newYear - now;
    let days = time / (1000 * 60 * 60 * 24);
    let hrs = (days - Math.floor(days)) * 24;
    let mins = (hrs - Math.floor(hrs)) * 60;
    let secs = (mins - Math.floor(mins)) * 60;

    daysBox.textContent = Math.floor(days);
    hrsBox.textContent = Math.floor(hrs);
    minsBox.textContent = Math.floor(mins);
    secsBox.textContent = Math.floor(secs);
}

