<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>using commons Upload to upload file</title>
</head>
<style>
* {
	font-family: "宋体";
	font-size: 14px
}
</style>
<body>
	<p align="center">请您选择需要上传的文件</p>

	<label class="control-label">选择图片</label>
	<form id="myform" action="pictureServlet?method=uploadImage"
		method="post" enctype="multipart/form-data">
		<input id="uploadImg" name="uploadImg" type="file" class="file" multiple data-show-upload="false" data-show-caption="true"	data-allowed-file-extensions='["jpg", "png","gif","jpeg"]'>
			 
			 <input type="submit" name="submit" value="提交"> 
			 <input type="reset" name="reset" value="重置">

	</form>

</body>
</html>