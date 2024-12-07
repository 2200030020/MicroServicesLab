<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JFSD </title>
</head>
<body>
<table style="100%">

<tr>
	<td style="width: 120px">College Name</td>
	<td><input type="text" id="T1"> </td>
</tr>
<tr>
	<td style="width: 120px">College acronym</td>
	<td><input type="text" id="T2"> </td>
</tr>
<tr>
	<td style="width: 120px"></td>
	<td>
		<button onclick="save()">Save</button>
		<button onclick="update()">Update</button>
		<button onclick="del()">Delete</button>
		<button onclick="read()">Read</button>
	</td> 
</tr>
</table>
<div style ="width:100%" id="collegeList"></div>
</body>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
function save() {
	var data = JSON.stringify({
		name:T1.value,
		acronym:T2.value
	});
	var url = "http://localhost:8083/10Springs17/college/save";
	callApi("POST", url, data, getResponse);
}
function getResponse(response) {
	alert(response);
}

function name() {
	var data = JSON.stringify({
		name:T1.value,
		acronym:T2.value
	});
	var url = "http://localhost:8083/10Springs17/college/update";
	callApi("PUT", url, data, getResponse);
}
function getResponse() {
	alert(response);
}
function del() {
	var data = "";
	var url = "http://localhost:8083/10Springs17/college/delete?acronym=" +T2.value ;
	callApi("DELETE" , url , data , getResponse);
}
function getResponse(response) {
	alert(response);
}
function read() {
	var data = "";
	var url = "http://localhost:8083/10Springs17/college/read";
	callApi("GET" , url , data , generateTable);
}
function generateTable(response) {
	var data = JSON.parse(response);
	var tb1 = `<table border="1">
					<tr>
						<th>College Name</th>
						<th>Acrony</th>
					</tr>;

	
	for(var x in data){
		tb1 += `<tr>
						<td>`+ data[x].name +`</td>
						<td>`+ data[x].acronym +`</td>
		
		</tr>`;
	}
	tb1 += `</table>`;
	collegeList.innerHTML = tb1;
}

</script>
</html>