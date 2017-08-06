<%
	if(request.getAttribute("notlogged") != null){ %>
		<h2>please login to go to home page</h2> <% 
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

	<div class="logo_login">
		<img src="resources/img/transparent.png" alt="logo">
	</div>
<div class="login_div">
	

		<div class="login_div1">
		<h4 style="color: red;"><% if(request.getAttribute("invalid")!=null){
		out.print("invalid password");
		}  %></h4>
				<h2>Login</h2>
			<form id="login_form" action="login" method="POST">
				<input class="usecss" id="login_email" type="email" name="email" placeholder="enter email" required>  <br> <span id="login_ajax"></span> 
				<input class="usecss" type="password" name="password" placeholder="enter password" required><br><br>
				<div id="login_radio"><input type="radio" name="type" value="student" required> student &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="type" value="faculty"> faculty</div>
				<input class="usecss" id="login_sub" type="submit" name="submit" value="submit">
			</form>
		</div>
	

	<div class="login_div2">
			 <div id="login_left">	<a href="#">forgotPassword</a></div>
			<div id="login_right">	<a href="registration.jsp">register</a></div>
	</div>

</div>


<script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
  <script>window.jquery || document.write('<script src="resources/js/jquery-3.1.js"><\/script>')</script>
<script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="resources/js/ajaxCode.js"></script>
<script type="text/javascript" src="resources/js/myjquery.js"></script>
<script type="text/javascript" src="resources/js/myjquery.js"></script> 
<script type="text/javascript" src="resources/js/ajax2.js"></script>
</body>
</html>