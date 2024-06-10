// //bai 1
// // const str = 'Hello World !';
// // const substr = '!';

// // console.log(str.includes(substr));


// //bai2
// function Cylinder(cyl_height, cyl_diameter) {
//     this.cyl_height = cyl_height;
//     this.cyl_diameter = cyl_diameter;
//   }
  
//   Cylinder.prototype.Volume = function () {
//     var radius = this.cyl_diameter / 2;
//     return this.cyl_height * Math.PI * radius * radius;
//   };
  
//   var cyl = new Cylinder(10, 5);
//   console.log('volume = ' + cyl.Volume().toFixed(4));
  

// //bai 3
// // function order(min,max) {
// //     return min - max;
// //   }
  
  
// //   function sumAll(arr) {
// //     var list = arr.sort(order);
// //     var a = list[0]; 
// //     var b = list[1]; 
// //     var c = 0;
  
// //     while (a <= b) {
// //       c = c + a; 
// //       a += 1; 
// //     }
  
// //     return c;
// //   }
  
// //   sumAll([10, 5]);
// //   function order(min,max) {
// //     return min - max;
// //   }
  
  
// //   function sumAll(arr) {
// //     var list = arr.sort(order);
// //     var a = list[0]; 
// //     var b = list[1]; 
// //     var c = 0;
  
// //     while (a <= b) {
// //       c = c + a;
// //       a += 1; 
// //     }
  
// //     return c;
// //   }
  
// //   sumAll([10, 5]);

// //bai4
// const number = parseInt(prompt("Enter a positive number: "));
// let isPrime = true;

// if (number === 1) {
//     console.log("1 is neither prime nor composite number.");
// }

// else if (number > 1) {
//     for (let i = 2; i < number; i++) {
//         if (number % i == 0) {
//             isPrime = false;
//             break;
//         }
//     }

//     if (isPrime) {
//         console.log(`${number} is a prime number`);
//     } else {
//         console.log(`${number} is a not prime number`);
//     }
// }

// else {
//     console.log("The number is not a prime number.");
// }

// //bai5
// // function(n){
// //     var arr = [],
// //         finalSum;

// //     if(n <= 1 || n >= 16){
// //        return false ;   
// //    }
// //    for(var i = 0; i < n; i++){
// //        var tmp= n/2;
// //        arr.push(tmp)    
       
// //    }
// //   return finalSum;
// // }


// //bai1
// // const person = {
// //     firstName: "Nhi",
// //     lastName: "Tran",
// //     age: 18,
// //     eyeColor: "brown"
// //   };
  
// // const keys = Object.keys(person);


// // const person = {
// //     firstName: "Nhi",
// //     lastName: "Tran",
// //     age: 18,
// //     eyeColor: "brown"
// //   };
  
// // const value = Object.values(person);


// // window.onload = setInterval(clock,1000);
    
// // function clock()
// // {
// //   var d = new Date();
  
// //   var date = d.getDate();
  
// //   var month = d.getMonth();
// //   var montharr =["Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"];
// //   month=montharr[month];
  
// //   var year = d.getFullYear();
  
// //   var day = d.getDay();
// //   var dayarr =["Sun","Mon","Tues","Wed","Thurs","Fri","Sat"];
// //   day=dayarr[day];
  
// //   var hour =d.getHours();
// //   var min = d.getMinutes();
// //   var sec = d.getSeconds();

// //   document.getElementById("date").innerHTML=day+" "+date+" "+month+" "+year;
// //   document.getElementById("time").innerHTML=hour+":"+min+":"+sec;
// // }

// // function sumPrimes(num, arr = []) {
// //     if (num <= 1) return
// //     for (let next = 2; next <= num; next++)
// //       if (!arr.some(val => next % val === 0)) arr.push(next) 
// //     return arr.reduce((a, b) => a + b)
// //     }
    
// // console.log(sumPrimes(977));

// // const numbersArr = [3, 10, 4, 21, 5, 9, 2, 6, 5, 3, 5];

// // numbersArr.sort((a, b) => a - b);
// // console.log(numbersArr); 

// // numbersArr.sort((a, b) => b - a);
// // console.log(numbersArr); 
    

// // const months = ["January", "February", "March", "April", "May", "June", "July"];

// // const random = Math.floor(Math.random() * months.length);
// // console.log(random, months[random]);


// // function list(...args) {
// //     return args;
// //   }
  
// //   function addArguments(arg1, arg2) {
// //     return arg1 + arg2;
// //   }
  
// //   console.log(list(1, 2, 3)); 
  
// //   console.log(addArguments(1, 2)); 
  
// //   const leadingThirtySevenList = list.bind(null, 37);
  
// //   const addThirtySeven = addArguments.bind(null, 37);
  
// //   console.log(leadingThirtySevenList()); 
// //   console.log(leadingThirtySevenList(1, 2, 3)); 
// //   console.log(addThirtySeven(5)); 
//   console.log(addThirtySeven(5, 10)); 

// let difference =array1.filter((element) => !array2.includes(element));
//     difference = difference.concat(array2.filter((element) => !array1.includes(element)));
// console.log(difference); 

// const array1 = [1, 3, 6, 6, 6,7];
// const array2 = [1, 3, 4, 5];

// function difference(main_array, del_array){
//     return main_array.concat(del_array).filter((item) => !(main_array.includes(item) && del_array.includes(item)));
// }

// console.log(difference(array1,array2));

function soLonthu2(arr) {
    let first, second;

    if (arr.length < 2) {
        return "Invalid Input";
    }

    arr.sort();

    for (let i = arr.length - 2; i >= 0; i--) {
        if (arr[i] !== arr[arr.length - 1]) {
            return "soLonthu2 " + arr[i];
        }
    }

    return "None";
}

const arr = [3,3,3,3];

console.log(soLonthu2(arr)); 