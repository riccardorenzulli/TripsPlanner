/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var map;

function initMap() {
    var coordinates = getCoordinates();
    console.log(coordinates);

    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:coordinates[0][0], lng:coordinates[0][1]},
        zoom: 15
    });

    var hotels;
    for (hotels = 0; coordinates.length; hotels++) {
        var marker = new google.maps.Marker({
            position: {lat:coordinates[hotels][0], lng:coordinates[hotels][1]},
            map: map,
            title: 'Hello World!'
        });

    }


}

function getCoordinates() {
    var myNodelat = document.querySelectorAll("#lat");
    var myNodelon = document.querySelectorAll("#lon");

    var myLatLng = [];
    var i;
    for (i = 0; i < myNodelat.length; i++) {
        var tmp = [parseFloat(myNodelat[i].value), parseFloat(myNodelon[i].value)];
        myLatLng.push(tmp);
    }
    return myLatLng;
}