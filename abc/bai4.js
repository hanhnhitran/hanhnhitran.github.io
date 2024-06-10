function time(time) {
    const hours = Math.floor(time / 60);
    const minutes = time % 60;
    return `${hours}h ${minutes < 10 ? `0${minutes}` : minutes}m`;
  }
  
console.log(time(80));
