
function startingMaintenanceON()
{	
//	For MAINTENANCE with countdown
//	StartCountDown("countDownCounterDiv","07/16/2018 03:30:00 PM","WEBSITE WILL BE UNDER MAINTENANCE IN "," FOR A DURATION OF 10 MINUTE");
	
//	For MAINTENANCE without countdown
	//StartCountDownOnlyMsg("countDownCounterDiv","03/06/2019 09:00:00 PM","IN CASE OF UNSUCCESSFUL PAYMENT TRANSACTIONS, IF AMOUNT IS DEDUCTED, IT WOULD BE AUTO-REFUNDED/CREDITED BACK TO YOUR ACCOUNT WITHIN 3 WORKING DAYS. IN CASE OF QUERY SEND EMAIL ON 'epay-rera@gujarat.gov.in'","");
}

//setSessionTimeout(secondsBeforeExpire);

function setSessionTimeout(divId, secondsBeforeExpire)
{	
	GetCurrentSessionTime(secondsBeforeExpire);
	CountBack(divId,secondsBeforeExpire,"This session expires in ","");
}

function GetCurrentSessionTime(secondsBeforeExpire)
{
	  var timeToDecide = 15; // Give client 15 seconds to choose.
	  setTimeout(function() {
//	      alert('Your session is about to timeout in ' + timeToDecide + ' seconds!')
	  }, (secondsBeforeExpire - timeToDecide) * 1000);
}

function StartCountDown(myDiv,myTargetDate,message,message1)
{
  var dthen	= new Date(myTargetDate);
  var dnow	= new Date();
  ddiff		= new Date(dthen-dnow);
  gsecs		= Math.floor(ddiff.valueOf()/1000);
  CountBack(myDiv,gsecs,message,message1);
}

function Calcage(secs, num1, num2)
{
  s = ((Math.floor(secs/num1))%num2).toString();
  if (s.length < 2) 
  {	
    s = "0" + s;
  }
  return (s);
}

function CountBack(myDiv, secs,message,message1)
{
  var DisplayStr = getDisplayStr(secs);
  if(secs > 0)
  {	
	DisplayStr = message + DisplayStr + message1;
	document.getElementById(myDiv).style.backgroundColor = 'red';
	document.getElementById(myDiv).innerHTML = DisplayStr;    
    setTimeout("CountBack('" + myDiv + "'," + (secs-1) + ",'" + message + "','" + message1 + "');", 1000);
  }
  else
  {
//    document.getElementById(myDiv).innerHTML = "";
//    document.getElementById(myDiv).style.backgroundColor = 'white';
    var elem = document.getElementById(myDiv);
    elem.parentNode.removeChild(elem);
  }
}

function getDisplayStr(secs) {
	var DisplayStr;
	  var DisplayFormat = "%%D%% Days %%H%%:%%M%%:%%S%%";
	  DisplayStr = DisplayFormat.replace(/%%D%%/g,	Calcage(secs,86400,100000));
	  DisplayStr = DisplayStr.replace(/%%H%%/g,		Calcage(secs,3600,24));
	  DisplayStr = DisplayStr.replace(/%%M%%/g,		Calcage(secs,60,60));
	  DisplayStr = DisplayStr.replace(/%%S%%/g,		Calcage(secs,1,60));
	return DisplayStr;
}
function getDisplayStr1(secs) {
	var DisplayStr;
	var DisplayFormat = "%%H%%:%%M%%:%%S%%";
	DisplayStr = DisplayFormat.replace(/%%H%%/g,		Calcage(secs,3600,24));
	DisplayStr = DisplayStr.replace(/%%M%%/g,		Calcage(secs,60,60));
	DisplayStr = DisplayStr.replace(/%%S%%/g,		Calcage(secs,1,60));
	return DisplayStr;
}


function ePayVerification(myDiv,verfyId, secs,message,message1)
{
  var DisplayStr = getDisplayStr1(secs);
  if(secs > 0)
  {	
	DisplayStr = message + DisplayStr + message1;
	document.getElementById(myDiv).innerHTML = DisplayStr;    
    setTimeout("ePayVerification('" + myDiv + "','" + verfyId + "'," + (secs-1) + ",'" + message + "','" + message1 + "');", 1000);
  }
  else
  {
	  $("#verifyPaymentForm").submit();
	  document.getElementById(verfyId).disabled = false;
	  document.getElementById(verfyId).style.backgroundColor = "#f2a52f";
	  var elem = document.getElementById(myDiv);
	  elem.parentNode.removeChild(elem);
	  var elem = document.getElementById("loding");
	  elem.parentNode.removeChild(elem);
	  alert("Please click the Payment Verify button.");
  }
}

function autoLoadPage(myDiv,minutes){
	var seconds = minutes * 60;
	reloadPage(myDiv, seconds);
}
function reloadPage(myDiv,seconds){
	if(seconds > 0)
	  {	
	    setTimeout("reloadPage('" + myDiv + "'," + (seconds-1) + ");", 1000);
	  }
	  else
	  {
		  document.getElementById(myDiv).submit();
	  }
}
function autoSubmitApplication(myDiv,formId, secs,message,message1)
{
  var DisplayStr = getDisplayStr1(secs);
  if(secs > 0)
  {	
	DisplayStr = message + DisplayStr + message1;
//	document.getElementById(myDiv).style.backgroundColor = '#5cb85c';
	document.getElementById(myDiv).style.backgroundColor = 'green';
	document.getElementById(myDiv).innerHTML = DisplayStr;    
    setTimeout("autoSubmitApplication('" + myDiv + "','" + formId + "'," + (secs-1) + ",'" + message + "','" + message1 + "');", 1000);
  }
  else
  {
	  var elem = document.getElementById(myDiv);
	  elem.parentNode.removeChild(elem);
	  document.getElementById(formId).submit();
  }
}

function StartCountDownOnlyMsg(myDiv,myTargetDate,message,message1)
{
  var dthen	= new Date(myTargetDate);
  var dnow	= new Date();
  ddiff		= new Date(dthen-dnow);
  gsecs		= Math.floor(ddiff.valueOf()/1000);
  CountBackOnlyMsg(myDiv,gsecs,message,message1);
}

function CountBackOnlyMsg(myDiv, secs,message,message1)
{
  var DisplayStr = getDisplayStr(secs);
  if(secs > 0)
  {	
	DisplayStr = message + message1;
	document.getElementById(myDiv).style.backgroundColor = 'red';
	document.getElementById(myDiv).innerHTML = DisplayStr;    
    setTimeout("CountBackOnlyMsg('" + myDiv + "'," + (secs-1) + ",'" + message + "','" + message1 + "');", 1000);
  }
  else
  {
//    document.getElementById(myDiv).innerHTML = "";
//    document.getElementById(myDiv).style.backgroundColor = 'white';
    var elem = document.getElementById(myDiv);
    elem.parentNode.removeChild(elem);
  }
}

function paymentUnderSettlement(myDiv,secs)
{
  var DisplayStr = getDisplayStr1(secs);
  if(secs > 0)
  {	
	document.getElementById(myDiv).innerHTML = DisplayStr;    
    setTimeout("paymentUnderSettlement('" + myDiv + "'," + (secs-1) + ",);", 1000);
  }
  else
  {
	  document.getElementById(myDiv).innerHTML = DisplayStr;  
  }
}
