function showPage(indexPage, days) {
    for(var i=0; i<days; i++){
        var name = 'page'+i;
        var buttonName = 'button'+i;
        if(i==indexPage) {
            document.getElementById(name).style.display='block';
            document.getElementById(buttonName).classList.add('active');
        }
        else {
            document.getElementById(name).style.display='none';
            document.getElementById(buttonName).classList.remove('active');
        }
    }
}