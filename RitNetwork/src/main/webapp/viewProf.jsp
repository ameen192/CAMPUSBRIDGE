<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include  file="header.jsp" %>
<% List<Student> studs = (List<Student>) request.getAttribute("studs"); %>
<% List<Faculty> facs = (List<Faculty>) request.getAttribute("facs"); %>


<div id="profile" class="index">
<div class="viewprof_maincontainer">

			<div id="viewprof_radio">
				<input type="radio" name="type" value="student" checked required> student &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="type" value="faculty"> faculty
			</div>


	<div id="viewstudentsprof" style="margin-top: 30px;">		<!--students here -->
			
		<div class="card-deck">
			<%for(Student s: studs){%>
				
				<div class="card text-center card-info" style="width: 200px;">
					<img class="card-img-top" src="resources/img/pic.jpg" alt="Card image cap">
					<div class="card-block">
						<h6>Name : <%=s.getName()%></h6>
						<h6>usn : <%=s.getUsn()%></h6>
						<button class="cardprofview btn btn-primary">view</button>
		  			</div>
				</div>
				<div class="profdialog" style="display: none;">
					<img class="img-thumbnail rounded-circle" src="resources/img/pic.jpg" alt="Card image cap">
					<div class="details" style="float: right; margin-right: 20px;">
						<h3>Name : <%=s.getName()%></h3>
						<h4>usn : <%=s.getUsn()%></h4>
						<h4>email : <%=s.getEmail()%></h4>
						<h4>Department : <%=s.getDepartment()%></h4>
						<h4>About : <%=s.getAbout()%></h4>
						<h5>Skills : <%=s.getSkills()%></h5>
						<h5>hobbies : <%=s.getHobbies()%></h5>	
					</div>
				</div>
			
			<%} %>
		</div>
	</div>
		
	<div id="viewfacultiesprof" style="display: none; margin-top: 30px;"> <!--faculties here -->
		<div class="card-deck">
			<%for(Faculty f: facs){%>
				
				<div class="card text-center card-info" style="width: 200px;">
					<img class="card-img-top" src="resources/img/pic.jpg" alt="Card image cap">
					<div class="card-block">
						<h4>Name : <%=f.getName()%></h4>
						<button class="cardprofview btn btn-primary">view</button>
		  			</div>
				</div>
				<div class="profdialog" style="display: none;">
					<img class="img-thumbnail rounded-circle" src="resources/img/pic.jpg" alt="Card image cap">
					<div class="details" style="float: right; margin-right: 20px;">
						<h3>Name : <%=f.getName()%></h3>
						<h4>email : <%=f.getEmail()%></h4>
						<h4>Department : <%=f.getDepartment()%></h4>
						<h4>About : <%=f.getAbout()%></h4>
						<h5>subjects handling : <%=f.getSubjects()%></h5>
					</div>
				</div>
			
			<%} %>
		</div>
	

	</div>
</div>
</div>
</body>
</html>