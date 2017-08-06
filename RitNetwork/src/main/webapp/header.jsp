<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<title>Insert title here</title>
</head>
<body>

<%
		Student studobj = null;
		Faculty facobj = null;
		String type = (String) session.getAttribute("type");
		String name = null;
		if (type.equals("student")) {
			studobj = (Student) session.getAttribute("userobj");
			name = studobj.getName();
		} else if (type.equals("faculty")) {
			facobj = (Faculty) session.getAttribute("userobj");
			name = facobj.getName();
		}
		
		System.out.println("checking session in header");
		System.out.println(session.getAttribute("type"));
		if(session.getAttribute("type")==null){
			System.out.println("checking session in header in if loop");
			request.setAttribute("notlogged", "true"); 
			response.sendRedirect("login.jsp");
			return;
		}  
%>

<div class="header_file">
	<div class="header_pic">
		<a href="fetchHome">
        <img src="resources/img/transparent.png"/> 
        </a> 
    </div>
    <div class="header_right">

    	<div class="header_search">	
    			Hi <%=name%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="headlink"><a href="editProf.jsp">edit_prof</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="logout"><a href="logout">logout</a></span>
  				<!-- <input type="text" name="search" placeholder="Search.."> -->

		</div>
		<div class="header_nav">
	    	<nav class="navbar navbar-inverse" style="background-color: #a6a6a6;"><!-- navbar-light by-faded -->
	    		<ul class="nav navbar-nav">
	    				  <li class="nav-item"><a class="nav-link" href="fetchHome">home</a></li>
	    				  <li class="nav-item"><a class="nav-link" href="viewProfiles">profiles</a></li>
						  <li class="nav-item"><a class="nav-link" href="activities.jsp">Activities</a></li>
						  <li class="nav-item"><a class="nav-link" href="fetchRequests">Requests</a></li>
						  <li class="nav-item"><a class="nav-link" href="fetchQnA">QnA</a></li>
						  <li class="nav-item"><a class="nav-link" href="placement.jsp">Placement</a></li>
						  <li class="nav-item"><a class="nav-link" href="#">Feedback</a></li>
				</ul>
			</nav>
		</div>
    </div>
</div>
<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script>window.jquery || document.write('<script src="resources/js/jquery-3.1.js"><\/script>')
	</script>
	<script type="text/javascript"
		src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.15.1/jquery.validate.min.js"></script>
	<script type="text/javascript" src="resources/js/ajaxCode.js"></script>
	<script type="text/javascript" src="resources/js/myjquery.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/requests.js"></script>
	<script type="text/javascript" src="resources/js/ajax2.js"></script>
	<script type="text/javascript" src="resources/js/qna.js"></script>
	<script type="text/javascript" src="resources/js/activities.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	
</body> 
</html>