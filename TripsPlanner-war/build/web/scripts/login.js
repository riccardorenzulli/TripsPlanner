/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  // This is called with the results from from FB.getLoginStatus().
//  function statusChangeCallback(response) {
//    console.log('statusChangeCallback');
//    console.log(response);
//    // The response object is returned with a status field that lets the
//    // app know the current login status of the person.
//    // Full docs on the response object can be found in the documentation
//    // for FB.getLoginStatus().
//    if (response.status === 'connected') {
//      // Logged into your app and Facebook.
//      testAPI();
//    } else {
//      // The person is not logged into your app or we are unable to tell.
//      console.log('Please log into this app.');
//    }
//  }
//
//  // This function is called when someone finishes with the Login
//  // Button.  See the onlogin handler attached to it in the sample
//  // code below.
//  function checkLoginState() {
//    FB.getLoginStatus(function(response) {
//      statusChangeCallback(response);
//    });
//  }
//
 // window.fbAsyncInit = function() {
 //   FB.init({
 //     appId      : '1525121230949483',
 //     cookie     : true,  // enable cookies to allow the server to access
 //                         // the session
 //     xfbml      : true,  // parse social plugins on this page
 //     version    : 'v3.0' // use graph api version 2.8
 //   });

//
//    // Now that we've initialized the JavaScript SDK, we call
//    // FB.getLoginStatus().  This function gets the state of the
//    // person visiting this page and can return one of three states to
//    // the callback you provide.  They can be:
//    //
//    // 1. Logged into your app ('connected')
//    // 2. Logged into Facebook, but not your app ('not_authorized')
//    // 3. Not logged into Facebook and can't tell if they are logged into
//    //    your app or not.
//    //
//    // These three cases are handled in the callback function.
//
//    FB.getLoginStatus(function(response) {
//      statusChangeCallback(response);
//    });
//
//  };
//
//  // Load the SDK asynchronously
//(function(d, s, id) {
//  var js, fjs = d.getElementsByTagName(s)[0];
//  if (d.getElementById(id)) return;
//  js = d.createElement(s); js.id = id;
//  js.src = '//connect.facebook.net/en_US/sdk.js';
//  fjs.parentNode.insertBefore(js, fjs);
//}(document, 'script', 'facebook-jssdk'));
//
//  // Here we run a very simple test of the Graph API after login is
//  // successful.  See statusChangeCallback() for when this call is made.
//  function testAPI() {
//    console.log('Welcome!  Fetching your information.... ');
//    FB.api('/me', function(response) {
//      console.log('Successful login for: ' + response.name);
//      document.getElementById('status').innerHTML =
//        'Thanks for logging in, ' + response.name + '!';
//    });
//  }
//
//function doLoginFB() {
//            console.log("sono nella dologin")
//
//    FB.login(function (response) {
//              console.log("snon nella doLoginfb")
//
//        if (response.status === 'connected') {
//            console.log(response.authResponse.accessToken);
//            FB.api('/me', {fields: 'name, email, picture'}, function (response) {
//                console.log(JSON.stringify(response));
//                console.log('Good to see you, ' + response.name + '.' + ' Email: ' + response.email + ' Facebook ID: ' + response.id);
//                /*
//                 document.getElementById("name").value = response.name;
//                 document.getElementById("imgurl").value = "http://graph.facebook.com/" + response.id + "/picture?type=normal";
//                 document.getElementById("email").value = response.email;
//                 */
//
//            });
//            console.log("stiamo per chiamare la hiddenform")
//            document.getElementById("idtoken").value = response.authResponse.accessToken;
//            document.getElementById("action").value = "login-f";
//            document.getElementById("hidden-form-f").submit();
//        } else {
//            //non sei riuscito a connetterti
//        }
//    });
//}
//
//Google

function doLoginGoogle(googleUser) {
  // Useful data for your client-side scripts:
  var profile = googleUser.getBasicProfile();
  console.log("ID: " + profile.getId()); // Don't send this directly to your server!
  console.log('Full Name: ' + profile.getName());
  console.log('Given Name: ' + profile.getGivenName());
  console.log('Family Name: ' + profile.getFamilyName());
  console.log("Image URL: " + profile.getImageUrl());
  console.log("Email: " + profile.getEmail());

  // The ID token you need to pass to your backend:
  var id_token = googleUser.getAuthResponse().id_token;
  console.log("ID Token: " + id_token);

  document.getElementById("idtoken").value = id_token;
  document.getElementById("action").value = "login-g";
  document.getElementById("id").value = profile.getId()
  document.getElementById("name").value = profile.getGivenName();
  document.getElementById("surname").value = profile.getFamilyName();
  document.getElementById("imgURL").value = profile.getImageUrl();
  document.getElementById("email").value = profile.getEmail();
  document.getElementById("hidden-form-g").submit();
}

function genericLogout(typeLogin) {
    if (typeLogin == "google") {
        logoutGoogle();
    } else {
        logoutFacebook();
    }
}

// function logoutFacebook() {
//   FB.logout(function(response) {
//     console.log("user is now logged out");
//   });
// }

function logoutGoogle() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        window.location.href = 'LoginServlet?action=logout';
    });
    auth2.disconnect();
}

// called loading the login.jsp, it inits the auth system. we need the auth system to be able to call the auth.signout() later...
function onLoad() {
      gapi.load('auth2', function() {
        gapi.auth2.init();
      });
}
