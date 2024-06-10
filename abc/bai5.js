function days_passed(data) {
    var current = new Date(data.getTime());
    var previous = new Date(data.getFullYear(), 1, 1);
  
    return Math.ceil((current - previous + 1) / 86400000);
  }
  console.log(days_passed(new Date(2024, 6, 10)));