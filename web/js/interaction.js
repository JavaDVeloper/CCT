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

document.getElementById(selectModel).addEventListener("change", function(){

        displayFieldToPutOwn(selectModel);
    }    
);
document.getElementById(selectMake).addEventListener("change", function(){
    displayFieldToPutOwn(selectMake);
});

function displayFieldToPutOwn(bleId){
            for(i = 0; i < selectId.length; i++){
                console.log(i);
                console.log(selectId[i]);
    if (document.getElementById(bleId).value == "other"){
        console.log("ble");

        document.getElementById(optionOtherId[i]).style.visibility = "visible";
        }
    
    else{
        document.getElementById(optionOtherId[i]).style.visibility = "hidden";        
    }
}

}