/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var map;
var markers = [];

Number.prototype.toFixedDown = function(digits) {
    var re = new RegExp("(\\d+\\.\\d{" + digits + "})(\\d)"),
        m = this.toString().match(re);
    return m ? parseFloat(m[1]) : this.valueOf();
};

function initMap() {
    var coordinates = getCoordinates();
    console.log(coordinates);

    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:coordinates[0][0][0], lng:coordinates[0][0][1]},
        zoom: 15
    });

    var hotels;
    for (hotels = 0; coordinates.length; hotels++) {
        var marker = new google.maps.Marker({
            icon: "http://maps.google.com/mapfiles/ms/icons/red-dot.png",
            position: {lat:coordinates[hotels][0][0], lng:coordinates[hotels][0][1]},
            map: map,
            title: 'Hello World!'
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
function setMarker(T){
    //var total_price = T.querySelector('#total_price').value;
    //var day_price = T.querySelector('#day_price').value;
    //var adult_number = T.querySelector('#adult_number').value;
    //var list_id = T.querySelector('#list_id').value;
    
    var lat = T.querySelector('#lat').value;
    var lon = T.querySelector('#lon').value;
    
    var decimalsLat = countDecimals(lat);
    var decimalsLon = countDecimals(lon);
    
    console.log("lat = " +lat);
    console.log("lon = " +lon);
    //document.getElementById('adult_number_field').innerText = adult_number;
    //document.getElementById('base_amount_field').innerText = day_price;
    //document.getElementById('total_cost_field').innerText = total_price;
    //document.getElementById('list_id_choosed').value = list_id;
    //console.log("valore list_id= "+list_id);
    var mark = null;
    for (i=0; i<markers.length; i++) {
        var marker = markers[i];
        var latM = marker.getPosition().lat();
        var lngM = marker.getPosition().lng();
        
        latM = latM.toFixedDown(decimalsLat);
        lngM = lngM.toFixedDown(decimalsLon);
    
        console.log("latM = " +latM);
        console.log("lonM = " +lngM);
        if((lat == latM) && (lon == lngM)){
            console.log("marker trovato")
            markers[i].setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png');
            mark = markers[i];
        }
    }
    
    if(last_marker !== null & last_marker !== mark){
        last_marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png');
    }
    
    last_marker = mark;
    
    map.panTo(mark.getPosition());
}

function countDecimals(value) {
    if(Math.floor(value) === value) return 0;
    return value.toString().split(".")[1].length || 0; 
}

