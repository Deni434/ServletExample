<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>

<form action="add" id="savefrm">
Name: <input type="text" name="ename" id="ename" onchange="checkemail(this.value)"><br>
<span style="color: red;font-weight: bold;" id="spanid"></span><br>
Salary: <input type="text" name="esalary" id="esalary"><br>
<span style="color: red;font-weight: bold;" id="spanid"></span><br>
Department: <input type="text" name="edepartment" id="edepartment">


<input type="button" value="save" onclick="savedata()">
</form>

</body>

</html>

<script>

function savedata(){
	var name = document.getElementById("ename1").value ;
	
	//alert(document.getElementById("ename").value);
	alert("hello "+name);
	
	if(document.getElementById("ename").value==""){
		
		alert("Please enter employee name");
	}
	else if (document.getElementById("esalary").value=="") {
		alert("Please enter employee salary");
	}
	else if (document.getElementById("edepartment").value=="") {
		alert("Please enter employee department");
	}
	else{
		
		document.getElementById("savefrm").submit();
	}
	
	
}


function checkemail(ename){
	/*per = (vat*temPay)/100;
	pay = temPay-per;
	document.getElementById('pay').innerHTML = parseFloat(pay);*/
	
	//document.getElementById('rupee').value = 0;
	
	var url = "checkmail?ename="+ename+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = checkemailRequest;
    req.open("GET", url, true); 
              
    req.send(null);
	
}

function checkemailRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			//document.getElementById('saletable').innerHTML = req.responseText;
			
			//alert(req.responseText);
			 var result = req.responseText;
			 if(result=="true"){
				 
				 document.getElementById("spanid").innerHTML = "name already exist" ;
			 }
			 else{
				 
				 document.getElementById("spanid").innerHTML = "name doesn't exist" ;
			 }
			
		}
	}
}


</script>