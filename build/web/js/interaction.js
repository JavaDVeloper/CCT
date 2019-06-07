//var idDrivLog = "driver-login";
//var idDrivPass = "driver-pass";
//var loginColor = "#870d4e";
//var passColor = "#BC477B";
//
//document.getElementById(idDrivLog).addEventListener("input", changeColour(idDrivLog, loginColor));
//document.getElementById(idDrivPass).addEventListener("input", changeColour(idDrivPass, passColor));
//
//function changeColour(id, theColor){
//document.getElementById(id).style.color = theColor;
//}

var selectModel = "vehicle-model";
var selectMake = "vehicle-make";

let selectId = ["vehicle-model", "vehicle-make"];
let optionOtherId = ["other-model-to-put", "other-make-to-put"];

var optionOtherModel = "other-model-to-put";
var optionOtherMake = "other-make-to-put";



document.getElementById(selectModel).addEventListener("change", function () {
    if (document.getElementById(selectModel).value == "other") {
        console.log("ble");
        document.getElementById(optionOtherId[0]).style.visibility = "visible";
        document.getElementById(optionOtherId[0]).style.marginBottom = "0";
    } else {
        document.getElementById(optionOtherId[0]).style.visibility = "hidden";
        document.getElementById(optionOtherId[0]).style.marginBottom = "-50px";
    }
});

document.getElementById(selectMake).addEventListener("change", function () {
    if (document.getElementById(selectMake).value == "other") {
        console.log("ble");
        document.getElementById(optionOtherId[1]).style.visibility = "visible";
        document.getElementById(optionOtherId[1]).style.marginBottom = "0";
    } else {
        document.getElementById(optionOtherId[1]).style.visibility = "hidden";
        document.getElementById(optionOtherId[1]).style.marginBottom = "-50px";
    }
});

document.getElementById("log-out").addEventListener("click", function () {
            console.log("ble");
    history.forward();
});

