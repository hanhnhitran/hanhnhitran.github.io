//bai1
function printTriangle(height) {
  for (let i = 1; i <= height; i++){
    let lineToPrint = ""; 
    for(let j = height - i; j > 0; j--){ 
      lineToPrint += " ";
    }  
    for(let j = i * 2 - 1; j > 0; j--){ 
      lineToPrint += "1";
    }
    console.log(lineToPrint);
  }
}

printTriangle(15)


//bai2
let myArray = [9,7,9,4,7,8,20,18,15,0]

for (i = 0; i < myArray.length; i++) {
    if (myArray[i]%2==0 && myArray[i]==0) {
        console.log(myArray[i]+" even number & equal 0");
    } if (myArray[i]==0) {
        console.log(myArray[i]+" equal 0");
    } if (myArray[i]%2==0) {
        console.log(myArray[i]+" even number");
    } else {
        console.log(myArray[i]+" not an even number");
    }
} 
  



//Bai 3
let myAnswer = []

let a = prompt("Have u eaten?")
if (a == "yes"){
  b = prompt("r u full")
  myAnswer.push("u have eaten")
  if (b == "yes") {
    alert("oke")
    myAnswer.push(" u r full")
} if (b == "no") {
    c = prompt("would u like some more: ")
    myAnswer.push("no thanks")
  }
}

alert(myAnswer) 
