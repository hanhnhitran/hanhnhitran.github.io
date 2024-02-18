const inputBox = document.getElementById("input-box")
const listContain = document.getElementById("list-contain")
function Addtask(){
    if(inputBox.value === ''){
        alert("You must enter something!");
    }
    else{
        let li = document.createElement("li");
        li.innerHTML = inputBox.value;
        listContain.appendChild(li);
        let span = document.createElement("span");
        span.innerHTML = "\u00d7"
        li.appendChild(span);
    }
    inputBox.value = "";
    saveData();
}

listContain.addEventListener("click", function(e){
    if(e.target.tagName ==="LI"){
        e.target.classList.toggle("checked");
        saveData();
    }
    else if(e.target.tagName ==="SPAN"){
        e.target.parentElement.remove();
        saveData();
    }
}, false);

function saveData(){
    localStorage.setItem("data", listContain,innerHTML);
}

function showTask(){
    listContain,innerHTML = localStorage.getItem("data");
}
showTask();