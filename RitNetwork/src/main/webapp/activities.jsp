<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include  file="header.jsp" %>
	<div id="activities" class="index">
	<div class="content_container">
		<div class="content_area">

			 <div class="act_title">
				<h2> Activities </h2>
			</div>
							
<!-- post activity-->		<div id="post_act"<%
						if (type.equals("student")) {%>
							style="display: block;"<%
						} else {%>
							style="display: none;"<%
						}%>>
								<input id="act_title" type="text" name="reqInput"placeholder="activity title"><br>
								<textarea id="act_textarea" rows="4" cols="80" placeholder="Post an activity"></textarea><br>
								Select activity start date and time : date : <input type="text" class="actdate" name="actdate">
								time : <input type="text" class="acttime" name="acttime"><br><br>
								Select activity end date and time : date : <input type="text" class="actenddate" name="actenddate">
								time : <input type="text" class="actendtime" name="actendtime"><br>
								<button type="button" class="btn btn-primary" id="post_actbutt">post activity</button>
							</div>
						
						
							

							

						


						<div class="listacts">
							


						</div>
 
		</div>
	</div>
</div>
</body>
</html>