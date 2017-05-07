<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>图片索引系统</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/messages.js"></script>
</head>

<body class="withvernav">
	<div class="centercontent">

		<div class="pageheader">
			<h1 class="pagetitle">图片存储索引</h1>
			<ul class="hornav">
				<li class="current"><a href="#inbox">Inbox</a></li>
				<li><a href="#compose">Compose New</a></li>
			</ul>
		</div>
		<!--pageheader-->

		<div id="contentwrapper" class="contentwrapper">

			<div id="inbox" class="subcontent">

				<div class="msghead">
					<ul class="msghead_menu">
						<li><a class="reportspam">Report Spam</a></li>
						<li class="marginleft5 dropdown" id="actions"><a
							class="dropdown_label" href="#actions"> Actions <span
								class="arrow"></span>
						</a>
							<ul>
								<li><a href="">Mark as Read</a></li>
								<li><a href="">Mark as Unread</a></li>
								<li><a href="">Move to Folder</a></li>
								<li><a href="">Add Star</a></li>
							</ul></li>
						<li class="marginleft5"><a class="msgtrash" title="Trash"></a></li>
						<li class="right"><a class="next"></a></li>
						<li class="right"><a class="prev prev_disabled"></a></li>
						<li class="right"><span class="pageinfo">1-10 of 2,139</span></li>
					</ul>
					<span class="clearall"></span>
				</div>
				<!--msghead-->

				<table cellpadding="0" cellspacing="0" border="0"
					class="stdtable mailinbox">
					<colgroup>
						<col class="con1" width="4%" />
						<col class="con0" width="4%" />
						<col class="con1" width="15%" />
						<col class="con0" width="63%" />
						<col class="con1" width="4%" />
						<col class="con1" width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th width="20" class="head1 aligncenter"><input
								type="checkbox" name="checkall" class="checkall" /></th>
							<th class="head0">&nbsp;</th>
							<th class="head1">Sender</th>
							<th class="head0">Subject</th>
							<th class="head1 attachement">&nbsp;</th>
							<th class="head0">Date</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th class="head1 aligncenter"><input type="checkbox"
								name="checkall" class="checkall2" /></th>
							<th class="head0"></th>
							<th class="head1">Sender</th>
							<th class="head0">Subject</th>
							<th class="head1 attachement">&nbsp;</th>
							<th class="head0">Date</th>
						</tr>
					</tfoot>
					<tbody>
						<tr class="unread">
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Hiccup Haddock</td>
							<td><a href="" class="title">Ut enim ad minim veniam,
									quis nostrud exercitation</a></td>
							<td class="attachment"><img
								src="images/icons/attachment.png" alt="" /></td>
							<td class="date">July 1</td>
						</tr>
						<tr class="unread">
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>themepixels</td>
							<td><a href="" class="title">Ullamco laboris nisi ut
									aliquip ex ea commodo consequat. </a></td>
							<td class="attachment"></td>
							<td class="date">June 30</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Puss in Boots</td>
							<td><a href="" class="title">Sed ut perspiciatis unde
									omnis iste natus error</a></td>
							<td class="attachment"></td>
							<td class="date">June 28</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Humpty Dumpty</td>
							<td><a href="" class="title">Sit voluptatem accusantium
									doloremque laudantium</a></td>
							<td class="attachment"><img
								src="images/icons/attachment.png" alt="" /></td>
							<td class="date">June 20</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar starred"></a></td>
							<td>themepixels</td>
							<td><a href="" class="title">Totam rem aperiam, eaque
									ipsa quae ab illo inventore</a></td>
							<td class="attachment"></td>
							<td class="date">June 19</td>
						</tr>
						<tr class="unread">
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Hiccup Haddock</td>
							<td><a href="" class="title">Ut enim ad minim veniam,
									quis nostrud exercitation</a></td>
							<td class="attachment"><img
								src="images/icons/attachment.png" alt="" /></td>
							<td class="date">July 1</td>
						</tr>
						<tr class="unread">
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>themepixels</td>
							<td><a href="" class="title">Ullamco laboris nisi ut
									aliquip ex ea commodo consequat. </a></td>
							<td class="attachment"></td>
							<td class="date">June 30</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Puss in Boots</td>
							<td><a href="" class="title">Sed ut perspiciatis unde
									omnis iste natus error</a></td>
							<td class="attachment"></td>
							<td class="date">June 28</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar"></a></td>
							<td>Humpty Dumpty</td>
							<td><a href="" class="title">Sit voluptatem accusantium
									doloremque laudantium</a></td>
							<td class="attachment"><img
								src="images/icons/attachment.png" alt="" /></td>
							<td class="date">June 20</td>
						</tr>
						<tr>
							<td class="aligncenter"><input type="checkbox" name="" /></td>
							<td class="star"><a class="msgstar starred"></a></td>
							<td>themepixels</td>
							<td><a href="" class="title">Totam rem aperiam, eaque
									ipsa quae ab illo inventore</a></td>
							<td class="attachment"></td>
							<td class="date">June 19</td>
						</tr>

					</tbody>
				</table>
			</div>
			<div id="compose" class="subcontent" style="display: none">&nbsp;</div>
		</div>
		<!--contentwrapper-->

	</div>
	<!--centercontent-->


	</div>
	<!--bodywrapper-->

</body>
</html>