/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = useAutocomplete();

function useAutocomplete() {
//    var input = document.getElementById('departure_city');
//    var input2 = document.getElementById('destination_city');
//    var options = {
//        language: 'en',
//        types: ['(cities)']
//    };
//    autocomplete = new google.maps.places.Autocomplete(input, options);
//    autocomplete2 = new google.maps.places.Autocomplete(input2, options);

    $(function () {
        function log(message) {
        }
        $("#departure_city").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "https://api.sandbox.amadeus.com/v1.2/airports/autocomplete",
                    dataType: "json",
                    data: {
                        apikey: getApiFromHidden(),
                        term: request.term
                    },
                    success: function (data) {
                        var res = [];
                        for (i = 0; i < data.length; i++ ) {
                                city = data[i];
                                city['value'] = city['label'];
                                res.push(city);
                        }
                        response(res);
                    }
                });
            },
            minLength: 3,
            select: function (event, ui) {

            },
            open: function () {
                //$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                //$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });
    });
    
    $(function () {
        function log(message) {
        }
        $("#destination_city").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "https://api.sandbox.amadeus.com/v1.2/airports/autocomplete",
                    dataType: "json",
                    data: {
                        apikey: "3AKuSyfvvCZE43RQw1dvNKC2NK6yJP7J",
                        term: request.term
                    },
                    success: function (data) {
                        var res = [];
                        for (i = 0; i < data.length; i++ ) {
                                city = data[i];
                                city['value'] = city['label'];
                                res.push(city);
                        }
                        response(res);
                    }
                });
            },
            minLength: 3,
            select: function (event, ui) {

            },
            open: function () {
                //$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                //$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });
    });
    
}

function getApiFromHidden(){
    var amadeus_autocomplete = $('#amadeus_autocomplete').val();
    console.log("l'api è:" + amadeus_autocomplete);
    return amadeus_autocomplete;
}
