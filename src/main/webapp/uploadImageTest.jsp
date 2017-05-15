<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>Krajee JQuery Plugins - &copy; Kartik</title>
        <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/default.css">
        <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="js/fileinput.js" type="text/javascript"></script>
        <!--简体中文-->
        <script src="js/locales/zh.js" type="text/javascript"></script>
        <!--繁体中文-->
        <script src="js/locales/zh-TW.js" type="text/javascript"></script>
        <script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
            <div class="htmleaf-container">
                <header class="htmleaf-header">
                    <h1>基于Bootstrup 3可预览的HTML5文件上传插件 <span>An enhanced HTML 5 file input for Bootstrap 3.x with file preview, multiple selection, and more features</span></h1>
                    <div class="htmleaf-links">
                        <a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家" target="_blank"><span> jQuery之家</span></a>
                        <a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/html5/html5muban/201505091801.html" title="返回下载页" target="_blank"><span> 返回下载页</span></a>
                    </div>
                </header>
                <div class="container kv-main">
                    <div class="page-header">
                    <h2>Bootstrap File Input Example</h2>
                    </div>
                    <form enctype="multipart/form-data" action="pictureServlet?method=uploadImages" method="post">
                        <input id="uploadImg" name="uploadImg"  class="file" type="file" multiple data-min-file-count="1" multiple data-show-upload="false" data-show-caption="true" data-allowed-file-extensions='["jpg", "png","gif","jpeg"]'>
                        <br>
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" class="btn btn-default">Reset</button>
                    </form>
                    	
                    <hr>
                    <form enctype="multipart/form-data">
                        <label>Test invalid input type</label>
                        <input id="file-0b" class="file" type="text" multiple data-min-file-count="1">
                        <script>
                        $(document).on('ready', function(){$("#file-0b").fileinput();});
                        </script>
                    </form>
                    <hr>
                    <form enctype="multipart/form-data">
                        <input id="file-0a" class="file" type="file" multiple data-min-file-count="3">
                        <hr>
                         <div class="form-group">
                            <input id="file-0b" class="file" type="file">
                        </div>
                        <hr>
                        <div class="form-group">
                            <input id="file-1" type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="2">
                        </div>
                        <hr>
                        <div class="form-group">
                            <input id="file-2" type="file" class="file" readonly data-show-upload="false">
                        </div> 
                        <hr>
                        <div class="form-group">
                            <label>Preview File Icon</label>
                            <input id="file-3" type="file" multiple=true>
                        </div>
                        <hr>
                        <div class="form-group">
                            <input id="file-4" type="file" class="file" data-upload-url="#">
                        </div>
                        <hr>
                        <div class="form-group">
                            <button class="btn btn-warning" type="button">Disable Test</button>
                            <button class="btn btn-info" type="reset">Refresh Test</button>
                            <button class="btn btn-primary">Submit</button>
                            <button class="btn btn-default" type="reset">Reset</button>
                        </div>
                        <hr>
                        <div class="form-group">
                            <input type="file" class="file" id="test-upload" multiple>
                            <div id="errorBlock" class="help-block"></div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <input id="file-5" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="#">
                        </div>
                    </form>
                    
                    
                    <hr>
                    <h4>支持多种语言</h4>
                    <form enctype="multipart/form-data">
                        <label>简体中文</label>
                        <input id="file-zh" name="file-zh[]" type="file" multiple>
                        <hr style="border: 2px dotted">
                        <label>繁体中文</label>
                        <input id="file-zh-TW" name="file-zh-TW[]" type="file" multiple>
                    </form>
                    <hr>
                    <br>
                </div>
             
            </div>
    </body>
	<script>
    $('#file-zh').fileinput({
        language: 'zh',
        uploadUrl: '#',
        allowedFileExtensions : ['jpg', 'png','gif'],
    });
    $('#file-zh-TW').fileinput({
        language: 'zh-TW',
        uploadUrl: '#',
        allowedFileExtensions : ['jpg', 'png','gif'],
    });
    $("#file-0").fileinput({
        'allowedFileExtensions' : ['jpg', 'png','gif'],
    });
    $("#file-1").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
	});
    /*
    $(".file").on('fileselect', function(event, n, l) {
        alert('File Selected. Name: ' + l + ', Num: ' + n);
    });
    */
	$("#file-3").fileinput({
		showUpload: false,
		showCaption: false,
		browseClass: "btn btn-primary btn-lg",
		fileType: "any",
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
	});
	$("#file-4").fileinput({
		uploadExtraData: {kvId: '10'}
	});
    $(".btn-warning").on('click', function() {
        if ($('#file-4').attr('disabled')) {
            $('#file-4').fileinput('enable');
        } else {
            $('#file-4').fileinput('disable');
        }
    });    
    $(".btn-info").on('click', function() {
        $('#file-4').fileinput('refresh', {previewClass:'bg-info'});
    });
    /*
    $('#file-4').on('fileselectnone', function() {
        alert('Huh! You selected no files.');
    });
    $('#file-4').on('filebrowse', function() {
        alert('File browse clicked for #file-4');
    });
    */
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
        /*
        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
        });
        */
    });
	</script>
</html>