/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = deleteUICss();
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
            //$("<div>").text(message).prependTo("#log");
            //$("#log").scrollTop(0);
        }
        $("#departure_city").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "https://api.sandbox.amadeus.com/v1.2/airports/autocomplete",
                    dataType: "json",
                    data: {
                        apikey: "3AKuSyfvvCZE43RQw1dvNKC2NK6yJP7J",
                        term: request.term
                    },
                    success: function (data) {
                        response(data);
                        console.log("chiamata success");
                    }
                });
            },
            minLength: 3,
            select: function (event, ui) {
                //log(ui.item ?
                        //"Selected: " + ui.item.label :
                        //"Nothing selected, input was " + this.value);
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


function deleteUICss(){
    $('.ui-spinner-button').detach();
    console.log("deletecss");
}