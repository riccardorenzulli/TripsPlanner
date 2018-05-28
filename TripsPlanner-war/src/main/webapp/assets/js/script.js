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

function modifyUserInfo() {
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var age = document.getElementById("age").value;
    var sex = document.getElementById("sex").value;
    
    if(name == "") {
        swal('Name field is empty!', 'Please insert your name.', 'warning')
        document.getElementById("name").focus();
        return false;
    }
  
    else if(!checkExpressionReg(name, "^[a-zA-Z]{1,30}$")) {
        swal('Name field is incorrect!', 'Please insert a valid name.', 'warning')
        document.getElementById("name").focus();
        return false;
    }
    
    if(surname == "") {
        swal('Surname field is empty!', 'Please insert your surname.', 'warning')
        document.getElementById("surname").focus();
        return false;
    }
  
    else if(!checkExpressionReg(surname, "^[a-zA-Z]{1,30}$")) {
        swal('Surname field is incorrect!', 'Please insert a valid surname.', 'warning')
        document.getElementById("surname").focus();
        return false;
    }
    
    if(age == "") {
        swal('Age field is empty!', 'Please insert your age.', 'warning')
        document.getElementById("age").focus();
        return false;
    }
  
    else if(!checkExpressionReg(age, "^[0-9]{2,3}$")) {
        swal('Age field is incorrect!', 'Please insert a valid age.', 'warning')
        document.getElementById("age").focus();
        return false;
    }
    
    if(sex == "") {
        swal('Sex field is empty!', 'Please insert your sex.', 'warning')
        document.getElementById("sex").focus();
        return false;
    }
  
    else if(!checkExpressionReg(sex, "^(Male|Female|Other|male|female|other)$")) {
        swal('Sex field is incorrect!', 'Please insert a valid sex.', 'warning')
        document.getElementById("sex").focus();
        return false;
    }
        
    var param = "action=modify-user-info&name="+name+"&surname="+surname+"&age="+age+"&sex="+sex;
    var url = "ControllerServlet";
    xhrObj.open('POST', url, true);
    xhrObj.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhrObj.onreadystatechange = reloadUserInfo;
    xhrObj.send(param);
}

function checkExpressionReg(s, expr) {
    var pattern = new RegExp(expr);
    return (pattern.test(s));
}

function reloadUserInfo() {
    if(xhrObj.readyState === 4 && xhrObj.status === 200) {
        var ris = xhrObj.responseText;
        if (ris === "success") {
            $("#user-personal-info").load("user-profile.jsp #user-personal-info>*","");
            $("#header").load("header.jsp #header>*","");
            swal('Success!', 'Personal informations updated.', 'success')
        }
        
        else {
            swal('Warning!', ris, 'warning');
        }
    }
    else if(xhrObj.status === 400) swal("Error!",  "status 400", "error");
    
}


