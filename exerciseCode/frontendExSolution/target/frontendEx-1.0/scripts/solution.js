// @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 19, 2017 
var consoleLog = document.getElementById("consoleLog");
var changeColor = document.getElementById("changeMyColor");
var changeTHcolor = document.getElementById("changeTHcolor");
var toggleImg = document.getElementById("toggleImg");
var removeBtns = document.getElementById("removeBtns");
var sortFname = document.getElementById("sortFname");
var sortLname = document.getElementById("sortLname");
var filterFemale = document.getElementById("filterFemale");
var filterMale = document.getElementById("filterMale");
var sumAccount = document.getElementById("sumAccount");
//getElementByTagName returns an array of all elements of that type:
var form = document.getElementsByTagName("form");
var nameRegExp = /^[a-zA-ZæøåÆØÅ ]+$/;
form[0].onsubmit = function () {
    //regular expression patterns to use in the CheckInput method:
    var nameRegExp = /^[a-zA-ZæøåÆØÅ ]+$/;
    var emailRegExp = / ^ ( ( [ \ - \ w ] + ) \ . ? ) + @ ( ( [ \ - \ w ] + ) \ . ? ) + \ . [ a - zA -Z ] { 2 , 4 } $ /; //http://www.tutorialspark.com/javascript/JavaScript_Regular_Expression_Form_Validation.php
    var passwordRegExp = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/; //https://stackoverflow.com/questions/12090077/javascript-regular-expression-password-validation-having-special-characters

    var fNameInput = document.getElementById("fname").value; //The value does not exist before the form was submitted
    console.log(fNameInput);

    //check if the user input matches the required pattern:
    var result = checkInput(fNameInput, nameRegExp); //returns a boolean
    console.log(result);
    return result; //return false from a form.onsubmit means that data is not submitted. e.g no request is made to the server.
};
consoleLog.onclick = function () { /*write your eventhandler code here*/
};
changeColor.onclick = function () {
    this.style.backgroundColor = 'red';
};
changeTHcolor.onclick = function () { //document.getElementsByTagName("th").forEach(function(element){ element.style.color = 'pink';});
    var thList = document.getElementsByTagName("th");
    for (var i = 0; i < thList.length; i++) {
        thList[i].style.color = 'pink';
    }
};
var logo = "";
toggleImg.onclick = function () {
    var logoDiv = document.getElementById("logo");
    if (logo.length === 0)
        logo = logoDiv.innerHTML;

    logoDiv.innerHTML = (logoDiv.innerHTML.length === 0) ? logo : "";
};
removeBtns.onclick = function () {
    document.getElementById("row1").innerHTML = "";
};
sortFname.onclick = function () {
    var tbody = document.getElementsByTagName("tbody")[0];
    var tableRows = tbody.getElementsByTagName("tr");
//    console.log(tableRows);
    var data = dataFromElements(tableRows);
//    console.log(data);
    data.sort(function(x, y){
        return (x.firstName<y.firstName)?-1:((x.firstName>y.firstName)?1:0);
    });
    var newRows = data.map(function(obj){
        return "<tr><td>"+obj.id+"</td>"+"<td>"+obj.firstName+"</td>"+"<td>"+obj.lastName+"</td>"+"<td>"+obj.email+"</td>"+"<td>"+obj.gender+"</td>"+"<td>"+obj.account+"</td></tr>";
    }).reduce(function(accumulator, currentValue) {
    return accumulator + currentValue;
});
    tbody.innerHTML = newRows;
};
sortLname.onclick = function () {};
filterFemale.onclick = function () {
    var tbody = document.getElementsByTagName("tbody")[0];
    var tableRows = tbody.getElementsByTagName("tr");
//    console.log(tableRows);
    var data = dataFromElements(tableRows);
    var newRows = data.filter((obj)=> obj.gender === "female")
    .map(function(obj){
        return "<tr><td>"+obj.id+"</td>"+"<td>"+obj.firstName+"</td>"+"<td>"+obj.lastName+"</td>"+"<td>"+obj.email+"</td>"+"<td>"+obj.gender+"</td>"+"<td>"+obj.account+"</td></tr>";
    })
    .reduce(function(accumulator, currentValue) {
    return accumulator + currentValue;
});
    tbody.innerHTML = newRows + "<tr><td><strong>Total</strong></td><td></td><td></td><td></td><td></td><td id=\"total\"></td></tr>";
};
filterMale.onclick = function () {};
sumAccount.onclick = function () {
     var tbody = document.getElementsByTagName("tbody")[0];
    var tableRows = tbody.getElementsByTagName("tr");
//    console.log(tableRows);
    var data = dataFromElements(tableRows);
    var sum = 0;
    data.forEach(function(obj){
        sum += Number(obj.account);
    });
    document.getElementById("total").innerText = sum.toFixed(2);
};

function checkInput(value, regexp) {
    //var regex = /^\d{5}$/;
    if (regexp.test(value) === false) {
        alert("You entered a wrong value. Try again");
//        zipCode.focus();
        return false;
    }
    return true;
}
function dataFromElements(tableRows) {
    result = [];
    for (var i = 0; i < tableRows.length; i++) {
        var tds = tableRows[i].getElementsByTagName("td");
        if (tds[0].innerText !== 'Total'){
            var obj = {};
            obj.id = tds[0].innerText;
            obj.firstName = tds[1].innerText;
            obj.lastName = tds[2].innerText;
            obj.email = tds[3].innerText;
            obj.gender = tds[4].innerText;
            obj.account = tds[5].innerText;
            result.push(obj);
        }
    }
    return result;
}
