//bai1
// const date = new Date();

// let day = date.getDate();
// let month = date.getMonth() + 1;
// let year = date.getFullYear();

// let currentDate = `${day}-${month}-${year}`;
// console.log(currentDate); 

//bai2
// const getDays = (year, month) => {
//     return new Date(year, month, 0).getDate();
// };

//bai3
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

//bai4