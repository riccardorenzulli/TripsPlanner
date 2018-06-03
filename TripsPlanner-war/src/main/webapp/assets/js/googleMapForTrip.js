var map;
var markers = [];

function initMap() {
    var coordinates = getCoordinates();

    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:coordinates[0][0][0], lng:coordinates[0][0][1]},
        zoom: 15
    });

    var hotels;
    for (hotels = 0; hotels < coordinates.length; hotels++) {
        var myLatLng = {lat: coordinates[hotels][0][0], lng: coordinates[hotels][0][1]};
        var marker = new google.maps.Marker({
                icon: "http://maps.google.com/mapfiles/ms/icons/red.png",
                position: myLatLng,
                map: map
            });

        markers.push(marker);
    }

}

function getCoordinates() {
    var myNodelat = document.getElementsByClassName("lat");
    var myNodelon = document.getElementsByClassName("lon");

    var myLatLng = [];
    var i;
    for (i = 0; i < myNodelat.length; i++) {
        var tmp = [parseFloat(myNodelat[i].value), parseFloat(myNodelon[i].value)];
        myLatLng.push([tmp, i]);
    }
    return myLatLng;
}

var last_marker = null; 
function setMarker(elem) {
    
    var lat = elem.getElementsByClassName("lat")[0].value;
    var lon = elem.getElementsByClassName("lon")[0].value;
    
    var decimalsLat = countDecimals(lat);
    var decimalsLon = countDecimals(lon);
    
    var mark = null;
    for (i=0; i<markers.length; i++) {
        var marker = markers[i];
        var latM = marker.getPosition().lat();
        var lngM = marker.getPosition().lng();
        
        latM = latM.toFixed(decimalsLat);
        lngM = lngM.toFixed(decimalsLon);
    
        if((lat == latM) && (lon == lngM)){
            markers[i].setIcon('http://maps.google.com/mapfiles/ms/icons/blue.png');
            mark = markers[i];
        }
    }
    
    if(last_marker !== null & last_marker !== mark){
        last_marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red.png');
    }
    
    last_marker = mark;
    
    map.panTo(mark.getPosition());
}

function countDecimals(value) {
    if(Math.floor(value) === value) return 0;
    return value.toString().split(".")[1].length || 0; 
}

