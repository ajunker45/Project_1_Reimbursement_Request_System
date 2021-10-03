console.log('the script is running')

let PageTitleTextDiv = document.getElementById('strangeTitleDiv');

function Change_title_color(){
    PageTitleTextDiv.style.color ='purple';
}

PageTitleTextDiv.addEventListener('click',Change_title_color);