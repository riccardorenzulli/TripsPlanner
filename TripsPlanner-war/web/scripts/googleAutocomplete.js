/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = useAutocomplete();

function useAutocomplete() {
    var input = document.getElementById('departure_city');
    var input2 = document.getElementById('destination_city');
    var options = {
        types: ['(cities)']
    };
    autocomplete = new google.maps.places.Autocomplete(input, options);
    autocomplete2 = new google.maps.places.Autocomplete(input2, options);

}