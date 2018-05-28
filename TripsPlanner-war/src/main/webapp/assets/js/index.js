function increment(id) {
    oldvalue = parseInt(document.getElementById(id).value);
    newvalue = oldvalue + 1;
    if (newvalue <= 10) {
        document.getElementById(id).value = newvalue
    }
}

function decrement(id) {
    oldvalue = parseInt(document.getElementById(id).value);
    newvalue = oldvalue - 1;
    if ((id === "child_count" && newvalue >= 0) || (id === "adult_count" && newvalue > 0)) {
        document.getElementById(id).value = newvalue
    }
}

function loading() {
    //content = "<body id=\"load_cont\" class=\"full-screen\"><div class=\"coming-soon-wrapper full-screen\"><div class=\"coming-soon full-screen\"><div class=\"centered-box text-center\"><div class=\"logo\"><h2>TRIPSPLANNER</h2></div><div class=\"loading-animation\"><span><i class=\"fa fa-plane\"></i></span><span><i class=\"fa fa-bed\"></i></span><span><i class=\"fa fa-ship\"></i></span><span><i class=\"fa fa-suitcase\"></i></span></div><div class=\"search-title\"><p>We Are On It! Looking For The Best Trip For You. This Will Take Few Seconds.</p></div><p class=\"copyright\">&copy; 2018 TripsPlanner</p></div></div></div></body>";
    document.getElementById("main_cont").style.display = "none";
    document.getElementById("load_cont").style.display = "block";
}

function initialize() {

    var options = {
        types: ['(cities)']
    };

    var input = document.getElementById('destination_city');
    var autocomplete = new google.maps.places.Autocomplete(input, options);
}

google.maps.event.addDomListener(window, 'load', initialize);


