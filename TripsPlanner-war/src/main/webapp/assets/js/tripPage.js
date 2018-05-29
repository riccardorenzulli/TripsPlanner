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

function canSaveTrip(f, loggedin) {
    console.log(loggedin);
    if (loggedin === "loggedin") return true;
    
    else {
        swal('You are not logged in'
    , 'Please log in in order to save this trip.', 'warning');
    swal({
        title: 'You are not logged in!',
        text: "Please log in in order to save this trip.",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#AEC6CF',
        cancelButtonColor: '#cfb7ae',
        confirmButtonText: 'Yes, go to login page!'
    }).then((result) => {
        if (result.value) {
            document.getElementById("save-trip-login").submit();
        }
        })
        
        return false;
    }
}