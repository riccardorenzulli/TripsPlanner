/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        var marker = new google.maps.Marker({
            icon: "http://maps.google.com/mapfiles/ms/icons/red.png",
            position: {lat:coordinates[hotels][0][0], lng:coordinates[hotels][0][1]},
            map: map,
            title: 'Hotel'
        });
        markers.push(marker);
    }

}

function getCoordinates() {
    var myNodelat = document.querySelectorAll("#lat");
    var myNodelon = document.querySelectorAll("#lon");

    var myLatLng = [];
    var i;
    for (i = 0; i < myNodelat.length; i++) {
        var tmp = [parseFloat(myNodelat[i].value), parseFloat(myNodelon[i].value)];
        myLatLng.push([tmp, i]);
    }
    return myLatLng;
}

var last_marker = null; 
function setPricesAndMarker(T){
    var total_price = T.querySelector('#total_price').value;
    var day_price = T.querySelector('#day_price').value;
    var adult_number = T.querySelector('#adult_number').value;
    var list_id = T.querySelector('#list_id').value;
    
    document.getElementById('adult_number_field').innerText = adult_number;
    document.getElementById('base_amount_field').innerText = day_price;
    document.getElementById('total_cost_field').innerText = total_price;
    document.getElementById('list_id_choosed').value = list_id;
    
    markers[list_id].setIcon('http://maps.google.com/mapfiles/ms/icons/blue.png');
    
    if(last_marker !== null & last_marker !== markers[list_id]){
        last_marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red.png');
    }
    
    last_marker = markers[list_id];
    
    map.panTo(markers[list_id].getPosition());
}