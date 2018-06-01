function setXMLHttpRequest() {
  var xhr = null;
  // browser standard con supporto nativo
  if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    xhr = new ActiveXObject("Microsoft.XMLHTTP");
  }
  return xhr;
}

var xhrObj = setXMLHttpRequest();

function showPage(indexPage, days) {
    for(var i=0; i<days; i++){
        var name = 'page'+i;
        var buttonName = 'button'+i;
        if(i==indexPage) {
            document.getElementById(name).style.display='block';
            document.getElementById(buttonName).classList.add('active');
        }
        else {
            document.getElementById(name).style.display='none';
            document.getElementById(buttonName).classList.remove('active');
        }
    }
}

function canSaveTrip(f, loggedin) {
    console.log(loggedin);
    if (loggedin === "loggedin") return true;
    
    else {
        swal('You are not logged in'
    , 'Please log in in order to save this trip.', 'warning');
    swal({
        title: 'You are not logged in!',
        text: "Please log in in order to save this trip.",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#AEC6CF',
        cancelButtonColor: '#cfb7ae',
        confirmButtonText: 'Yes, go to login page!'
    }).then((result) => {
        if (result.value) {
            document.getElementById("save-trip-login").submit();
        }
        })
        
        return false;
    }
}

var addmemorybtn;

function openMemoryUpload() {
    addmemorybtn = document.getElementById("add_memory_div");
    addmemorybtn.style.display = "block";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == addmemorybtn) {
        addmemorybtn.style.display = "none";
    }
}

function readURL(input) {
  if (input.files && input.files[0]) {

    var reader = new FileReader();

    reader.onload = function(e) {
      $('.image-upload-wrap').hide();

      $('.file-upload-image').attr('src', e.target.result);
      $('.file-upload-content').show();

      $('.image-title').html(input.files[0].name);
    };

    reader.readAsDataURL(input.files[0]);

  } else {
    removeUpload();
  }
}

function removeUpload() {
  $('.file-upload-input').replaceWith($('.file-upload-input').clone());
  $('.file-upload-content').hide();
  $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function () {
		$('.image-upload-wrap').addClass('image-dropping');
	});
	$('.image-upload-wrap').bind('dragleave', function () {
		$('.image-upload-wrap').removeClass('image-dropping');
});


/* form submit */
function goToTripView(div){
    var form = div.querySelector('#trip_form');
    form.submit();
}

//function addMemory(i) {
//    var param = "action=action=memoryUpload&id="+i;
//    var url = "ControllerServlet";
//    xhrObj.open('POST', url, true);
//    xhrObj.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//    xhrObj.onreadystatechange = reloadTrip;
//    xhrObj.send(param);
//}
//
//function reloadUserInfo() {
//    if(xhrObj.readyState === 4 && xhrObj.status === 200) {
//        var ris = xhrObj.responseText;
//        if (ris === "success") {
//            addmemorybtn.style.display = "none";
//            swal('Success!', 'New memory added.', 'success');
//        }
//        
//        else {
//            swal('Warning!', ris, 'warning');
//        }
//    }
//    else if(xhrObj.status === 400) swal("Error!",  "status 400", "error");
//}