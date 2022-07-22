var container = document.querySelector(".movie-container");

var data = [
  {
    img: "https://m.media-amazon.com/images/M/MV5BMDljNTQ5ODItZmQwMy00M2ExLTljOTQtZTVjNGE2NTg0NGIxXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_FMjpg_UX1000_.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Star war",
  },
  {
    img: "https://upload.wikimedia.org/wikipedia/vi/2/2d/Avengers_Endgame_bia_teaser.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "End game",
  },
  {
    img: "https://terrigen-cdn-dev.marvel.com/content/prod/1x/stb_teaser_1-sht_v4_lg.jpg  ",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Shang chi",
  },
  {
    img: "https://lumiere-a.akamaihd.net/v1/images/p_avengersinfinitywar_19871_cb171514.jpeg?region=0,0,540,810&width=480",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Infiniti war",
  },
  {
    img: "https://lumiere-a.akamaihd.net/v1/images/p_blackpanther_19754_4ac13f07.jpeg?region=0,0,540,810&width=480",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Black panther",
  },
  {
    img: "https://upload.wikimedia.org/wikipedia/en/8/8a/The_Avengers_%282012_film%29_poster.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Advengers",
  },
  {
    img: "https://i.pinimg.com/736x/13/db/2d/13db2dfef0d7fe0b0c205d8dd3c83b02.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Infiniti war",
  },
  {
    img: "https://cdn.tgdd.vn//GameApp/1338713//5-800x1186.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Thor",
  },
  {
    img: "https://media.senscritique.com/media/000018355538/source_big/Captain_Marvel.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Captain Marvels",
  },
  {
    img: "https://lumiere-a.akamaihd.net/v1/images/image_ae30e307.jpeg?region=0,0,540,810&width=480",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Antman the wasp",
  },
  {
    img: "https://upload.wikimedia.org/wikipedia/en/7/74/Shang-Chi_and_the_Legend_of_the_Ten_Rings_poster.jpeg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Shang chi",
  },
  {
    img: "https://terrigen-cdn-dev.marvel.com/content/prod/1x/guardiansofthegalaxy_lob_crd_03.jpg",
    link: "https://www.netflix.com/title/81026705?trackId=13752289&trackIdJaw=13752289&trackIdEpisode=13752289&trackIdTrailer=13752289&dpRightClick=1",
    name: "Guardians of the galaxy",
  },
];

let renderData = function (data) {
  let dom = document.querySelector("#xx");
  dom.innerHTML = "";

  for (let i = 0; i < data.length; i++) {
    let html = `<div class="movie-list">
        <div class="movie-list-wrapper">
            <div class="movie-list-item">
                <img src="${data[i].img}" alt="">
                <button><a href="${data[i].link}">Watch</a></button>
            </div>
            <p>${data[i].name}</p>
        </div>
    </div>`;
    dom.innerHTML += html;
  }
};

let form = document.querySelector("#a");
form.onsubmit = function (e) {
  e.preventDefault();
  let filmName = form.filmName.value.trim();

  let result = data.filter((i) => {
    return i.name.toLowerCase().includes(filmName.toLowerCase());
  });

  console.log(result);
  renderData(result);
};


