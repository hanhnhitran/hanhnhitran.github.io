function f(time, x) {
    const timeformat = "HH:mm:ss";

    const [hours, minutes, seconds] = time.split(':').map(Number);
    const date = new Date();
    date.setHours(hours, minutes, seconds, 0);

    date.setSeconds(date.getSeconds() + x);

    const pad = (num) => String(num).padStart(2, '0');
    const calculated_time = `${pad(date.getHours())}:${pad(date.getMinutes())}:${pad(date.getSeconds())}`;

    return calculated_time;
}

console.log(f("12:00:00", 6))