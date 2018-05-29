var autocomplete;
var latitude;
var longitude;

//$("destination_city").keydown(function(event) {
//    if (event.keyCode == 13) {
//        event.preventDefault();
//    }
//});

function increment(id) {
    oldvalue = parseInt(document.getElementById(id).value);
    newvalue = oldvalue + 1;
    if (newvalue <= 10) {
        document.getElementById(id).value = newvalue;
    }
}

function decrement(id) {
    oldvalue = parseInt(document.getElementById(id).value);
    newvalue = oldvalue - 1;
    if ((id === "child_count" && newvalue >= 0) || (id === "adult_count" && newvalue > 0)) {
        document.getElementById(id).value = newvalue;
    }
}

function validateSearch(f) {
    var destination_city = document.getElementById("destination_city").value;
    var departure_date = document.getElementById("departure_date").value;
    var return_date = document.getElementById("return_date").value;
    var adult_count = document.getElementById("adult_count").value;
    var child_count = document.getElementById("child_count").value;
    
    if(destination_city === "") {
        swal('Destination city field is empty!', 'Please insert a destination city.', 'warning');
        document.getElementById("destination_city").focus();
        return false;
    }
  
    else if(!checkDestCity(destination_city)) {
        swal('Destination city field is incorrect!', 'Please insert a valid destination city.', 'warning');
        document.getElementById("destination_city").focus();
        return false;
    }
    
    if(departure_date === "") {
        swal('Departure date field is empty!', 'Please insert a departure date.', 'warning');
        document.getElementById("departure_date").focus();
        return false;
    }
  
    else if(!checkExpressionReg(departure_date, "^((0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2})*$")) {
        swal('Departure date field is incorrect!', 'Please insert a valid departure date.', 'warning');
        document.getElementById("departure_date").focus();
        return false;
    }
    
    if(!checkDepDate(departure_date)) {
        swal('Departure date field is incorrect!', "You can't travel back in time.", 'warning');
        document.getElementById("departure_date").focus();
        return false;
    }
    
    if(return_date === "") {
        swal('Return date field is empty!', 'Please insert a return date.', 'warning');
        document.getElementById("return_date").focus();
        return false;
    }
  
    else if(!checkExpressionReg(return_date, "^((0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2})*$")) {
        swal('Return date field is incorrect!', 'Please insert a valid return date.', 'warning');
        document.getElementById("return_date").focus();
        return false;
    }
    
    if (!checkDates(departure_date, return_date)) {
        swal('Dates fields are wrong!', 'Trip max length must be 7 days', 'warning');
        return false;
    }
    
    if(adult_count === "") {
        swal('Adult field is empty!', 'Please insert a adult number.', 'warning');
        document.getElementById("adult_count").focus();
        return false;
    }
  
    else if(!checkExpressionReg(adult_count, "^(1|2|3|4|5|6|7|8|9|10)$")) {
        swal('Adult field is incorrect!', 'Please insert a valid adult number.', 'warning');
        document.getElementById("adult_count").focus();
        return false;
    }
    
    if(child_count === "") {
        swal('Child field is empty!', 'Please insert a child number.', 'warning');
        document.getElementById("child_count").focus();
        return false;
    }
  
    else if(!checkExpressionReg(child_count, "^(0|1|2|3|4|5|6|7|8|9|10)$")) {
        swal('Child field is incorrect!', 'Please insert a valid child number.', 'warning');
        document.getElementById("child_count").focus();
        return false;
    }
        
    document.getElementById("latitude").value = latitude;
    document.getElementById("longitude").value = longitude;
    document.getElementById("main_cont").style.display = "none";
    document.getElementById("load_cont").style.display = "block";
        
    return true;
}

function checkDates(departure_date, return_date) {
    dep = departure_date.split("/");
    dep_mm = parseInt(dep[0]);
    dep_dd = parseInt(dep[1]);
    dep_yyyy = parseInt(dep[2]);
    
    ret = return_date.split("/");
    ret_mm = parseInt(ret[0]);
    ret_dd = parseInt(ret[1]);
    ret_yyyy = parseInt(ret[2]);
    
    var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
    var depDate = new Date(dep_yyyy,dep_mm,dep_dd);
    var retDate = new Date(ret_yyyy,ret_mm,ret_dd);

    var diffDays = Math.round(Math.abs((depDate.getTime() - retDate.getTime())/(oneDay)));
    console.log(diffDays);
    
    if (diffDays > 7) return false;
    else return true;
}

function checkDepDate(departure_date) {
    var today = new Date();
    var dd = parseInt(today.getDate());
    var mm = parseInt(today.getMonth()+1); //January is 0!
    var yyyy = parseInt(today.getFullYear());
    
    dep = departure_date.split("/");
    dep_mm = parseInt(dep[0]);
    dep_dd = parseInt(dep[1]);
    dep_yyyy = parseInt(dep[2]);
    
    if (!(dep_dd >= dd && dep_mm >= mm && dep_yyyy >= yyyy)) return false;
    
    else return true;
    
}

function checkExpressionReg(s, expr) {
    var pattern = new RegExp(expr);
    return (pattern.test(s));
}

function checkDestCity(destination_city) {
    var place = autocomplete.getPlace();
    if (place && place.geometry) return true;
    else return false;
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
    if (place.geometry) {
        latitude = place.geometry.location.lat();
        longitude = place.geometry.location.lng();
    }
}
