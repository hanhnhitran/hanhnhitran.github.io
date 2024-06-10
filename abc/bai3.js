var weekend =  function(date1){
    var data = new Date(date1);
     
    if(data.getDay() == 6 || data.getDay() == 0)
       {
        return "weekend";
        } 
}

console.log(weekend('Jun 10, 2024'));
console.log(weekend('Jun 8, 2024'));
console.log(weekend('Jun 9, 2024'));