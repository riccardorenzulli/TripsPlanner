var autocomplete;
var latitude;
var longitude;

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

function validateSearch() {
    
    if (true) {
        document.getElementById("latitude").value = latitude;
        document.getElementById("longitude").value = longitude;
        document.getElementById("main_cont").style.display = "none";
        document.getElementById("load_cont").style.display = "block";
    }
    
}

function initAutocomplete() {

    var options = {
        types: ['(cities)']
    };

    var input = document.getElementById('destination_city');
    autocomplete = new google.maps.places.Autocomplete(input, options);
    autocomplete.addListener('place_changed', onPlaceChanged);

}


function onPlaceChanged() {
    var place = autocomplete.getPlace();
    latitude = place.geometry.location.lat();
    longitude = place.geometry.location.lng();
}
