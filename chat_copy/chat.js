// thay đổi dark mode (add class dark mode vào body)
document.querySelector("#sw_mode").addEventListener("click", function () {
  document.body.classList.toggle("dark_mode");
});

var email_ = "";
var currentid_ = "";
var img_ = "";

// check xem sự thay đổi của user đã được lưu trong firebase hay chưa
firebase.auth().onAuthStateChanged((user) => {
  if (user) {
    var uid = user.uid;
    console.log(user.email);
    email_ = user.email;
    img_ = user.photoURL;
    loadchat(user.email);
    renderCurrentUser(user.photoURL, user.displayName);
    console.log(user);
    // ...
  } else {
    sweetAlert("warning", "bạn cần đăng nhập");
    setTimeout(() => {
      open("./signin/index.html", "_self");
    }, 3000);
  }
});

let signOut = () => {
  firebase
    .auth()
    .signOut()
    .then(() => {
      // Sign-out successful.
    })
    .catch((error) => {
      // An error happened.
    });
};

let clock = () => {
  let date = new Date();
  let h = date.getHours();
  let m = date.getMinutes();
  let s = date.getSeconds();
  let d = date.getDay();

  if (m < 10) {
    m = "0" + m;
  }
  if (h < 10) {
    h = "0" + h;
  }
  if (s < 10) {
    s = "0" + s;
  }
  var weekday = new Array(7);
  weekday[0] = "Sunday";
  weekday[1] = "Monday";
  weekday[2] = "Tuesday";
  weekday[3] = "Wednesday";
  weekday[4] = "Thursday";
  weekday[5] = "Friday";
  weekday[6] = "Saturday";

  var n = weekday[d];

  return ` ${h}:${m}:${s}     ${n}`;
};

let loadchat = async (email) => {
  let result = await firebase
    .firestore()
    .collection("chat")
    .where("users", "array-contains", email)
    .get();
  console.log(result);

  let data = getDataFromDocs(result.docs);
  console.log(data);
  renderUserList(data);
  renderChat(data[0], email);
};

let getDataFromDoc = (doc) => {
  let data = doc.data();
  data.id = doc.id;
  return data;
};

let getDataFromDocs = (docs) => {
  let result = [];
  for (let doc of docs) {
    let data = getDataFromDoc(doc);
    result.push(data);
  }
  return result;
};

let sweetAlert = (icon, message) => {
  const Toast = Swal.mixin({
    toast: true,
    position: "top-end",
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.addEventListener("mouseenter", Swal.stopTimer);
      toast.addEventListener("mouseleave", Swal.resumeTimer);
    },
  });

  Toast.fire({
    icon: icon,
    title: message,
  });
};

let renderChat = (data, ownerEmail) => {
  let chat = data.chat;
  currentid_ = data.id;
  let dom = document.querySelector(".chat");
  dom.innerHTML = "";

  for (let i = 0; i < chat.length; i++) {
    console.log(chat[i].email);
    let html = `<div class="mess  ${
      chat[i].email == ownerEmail ? "owner" : ""
    }">
    <div class="mess-avatar">
      <img src="${chat[i].avatar}" alt="" />
    </div>
    <div class="mess-content">
      <p>${chat[i].email}</p>
      <p>
       ${chat[i].content}
      </p>
      <p>${chat[i].time}</p>
    </div>
  </div>`;
    dom.innerHTML += html;
  }
};

let renderUserList = (data, email) => {
  let dom = document.querySelector(".card-body");
  dom.innerHTML = "";

  for (let i = 0; i < data.length; i++) {
    let html = `<div id="c${data[i].id}" class="item d-flex align-items-center">
    <div class="image">
      <img
        src="${data[i].avatar}"
        alt="..."
        class="img-fluid rounded-circle"
      />
    </div>
    <div class="text">
      <a href="#"> <h3 class="h5">${data[i].name}</h3></a
      ><small>Time ${data[i].timeStart}</small>
    </div>
  </div>`;

    dom.innerHTML += html;
  }
  for (let i = 0; i < data.length; i++) {
    let user = document.querySelector(`#c${data[i].id}`);
    user.addEventListener("click", () => {
      renderChat(data[i], email);
    });
  }
};

let renderCurrentUser = (photo, userName) => {
  document.querySelector("#userImg").src = photo;
  document.querySelector("#userName").innerHTML = userName;
};

setInterval(() => {
  document.querySelector("#realTime").innerHTML = clock();
}, 1000);

let formChat = document.querySelector("#chat_input_form");
formChat.onsubmit = (e) => {
  e.preventDefault();

  let content = formChat.chat.value.trim();

  updateNewMessage(content, email_, img_, clock(), currentid_);
};

let updateNewMessage = async (content, email, img, time, currentID) => {
  if (currentID) {
    let conversationId = currentID;
    let message = {
      content: content,
      time: time,
      img: img,
      email: email,
    };
    await firebase
      .firestore()
      .collection("chat")
      .doc(conversationId)
      .update({
        chat: firebase.firestore.FieldValue.arrayUnion(message),
      });
  }
};

// let loadConversation1 = async (email)=>{
//     var currentEmail = email.trim()
//     document.querySelector("#currentEmail").innerHTML = currentEmail
//     let result = await firebase.firestore()
//     .collection('chat')
//     .where('users','array-contains',currentEmail)
//     .get()

//     let Conversations = getDataFromDocs(result.docs)
//     console.log(Conversations)
//     renderChat(Conversations[0], currentEmail)
//     rederListFriends(Conversations, currentEmail)
// }