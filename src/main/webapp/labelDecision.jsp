<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>标签判定页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.pie.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/charts.js"></script>
</head>
<body>
	<div class="header">
		<div class="headerwidget">
			<div class="earnings">
				<div class="one_half">
					<h4>Today's Earnings</h4>
					<h2>$640.01</h2>
				</div>
				<!--one_half-->
				<div class="one_half last alignright">
					<h4>Current Rate</h4>
					<h2>53%</h2>
				</div>
				<!--one_half last-->
			</div>
			<!--earnings-->
		</div>
		<!--headerwidget-->

	</div>
	<!--header-->

	<div class="pageheader">
		<h1 class="pagetitle">Reports</h1>
		<span class="pagedesc">An example of graphs &amp; charts. A
			page without left menu.</span>

		<ul class="hornav">
			<li class="current"><a href="#charts">Charts</a></li>
			<li><a href="#statistics">Statistics</a></li>
		</ul>
	</div>
	<!--pageheader-->

	<div class="contentwrapper">

		<div id="charts" class="subcontent">

			<div class="one_half">
				<div class="contenttitle2">
					<h3>Simple Chart</h3>
				</div>
				<!--contenttitle-->
				<br />
				<div id="chartplace" style="height: 300px;"></div>
			</div>
			<!--one_half-->

			<div class="one_half last">
				<div class="contenttitle2">
					<h3>Bar Graph</h3>
				</div>
				<!--contenttitle-->
				<br />
				<div id="bargraph" style="height: 300px;"></div>
			</div>
			<!--one_half last-->

			<br clear="all" />
			<br />

			<div class="one_half">
				<div class="contenttitle2">
					<h3>Real Time Chart</h3>
				</div>
				<!--contenttitle-->
				<br />
				<div id="realtime" style="height: 300px;"></div>
				<br /> <small>You can update a chart periodically to get a
					real-time effect by using a timer to insert the new data in the
					plot and redraw it.</small>
			</div>
			<!--one_half-->

			<div class="one_half last">
				<div class="contenttitle2">
					<h3>Pie Chart</h3>
				</div>
				<!--contenttitle-->
				<br />
				<div id="piechart" style="height: 300px;"></div>
			</div>
			<!--one_half last-->

			<br clear="all" />

		</div>
		<!--#charts-->

		<div id="statistics" class="subcontent">&nbsp;</div>
		<!--#statistics-->

	</div>
	<!--contentwrapper-->


	</div>
	<!--bodywrapper-->

</body>
</html>
