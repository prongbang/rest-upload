<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="./js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<h1>Upload File Form HTML</h1>
	<form action="rest/service/upload" method="post"
		enctype="multipart/form-data">
		<p>
			Select a file : <input type="file" name="file" size="50" />
		</p>
		<input type="submit" value="Upload It" />
	</form>
	<br>
	<br>
	<h1>Test Send JSON</h1>
	<button onclick="send()">Send JSON</button>
	<script>
		function send() {
			var data = {
				title : "TEST",
				name : "abc"
			};
			$.ajax({
				type : "POST",
				url : "./rest/service/wellcome",
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8",
				dataType : "application/json",
				success : function(data,status) {
					console.log(" **** success ** " + data);
				},
				failure : function(data) {
					console.log("fail",data);
				}
			});
		}
	</script>

	<br>
	<br>
	<h1>Upload File jQuery</h1>
	<div>
		<input type="file" name="file" id="file">
		<button onclick="upload()">Upload</button><br>
		<p id="response"></p>
	</div>
	<script>
		function upload() {
			var myFormData = {
				file : document.getElementById('file').files[0]
			};
			var formData = new FormData();
			for ( var key in myFormData) {
				formData.append(key, myFormData[key]);
			}
			$.ajax({
				url : './rest/service/upload',
				type : 'POST',
				data : formData, // Do not send it as - data: { formData: formData }
				processData : false, // Tell jquery to don't process the data
				contentType : false, // If you do not set it as false, most probably you would get 400 or 415 error
				success : function(data, status) {
					$("#response").text('success ' + data);
				},
				failure : function(data) {
					$("#response").text("fail " + data);
				}
			});
		}
	</script>

</body>
</html>