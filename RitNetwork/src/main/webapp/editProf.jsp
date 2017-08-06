<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include  file="header.jsp"%>

<div id="editprofile">
<div class="reprof_container"></div>
<div class="prof_container">

		<div class="sidebar">
				<div class="pic">
					<div class="display_pic">
						<img id="img_opc" src="resources/img/pic.jpg" alt="profile_pic"/>
					</div>
				</div>
				<div class="sidebar_text">
					<%  if(type.equals("student")) { %>	
						<h3><%=studobj.getUsn()%> </h3> <br>
						<h3><%=studobj.getDepartment()%> </h3> <br>
						<h3><%=studobj.getCourse()%> </h3> 
					<% }else if(type.equals("faculty")){  %>
						<h3><%=facobj.getFaculty_coll_id()%> </h3> <br>
						<h3><%=facobj.getDepartment()%> </h3> <br>
					<%  } %>
				</div>
				
		</div>

		<div class="prof_area">
			
			<div class="prof_details shown">

		<%  if(type.equals("student")) { %>
				<button type="button" class="sprof_edit_button btn btn-primary">update</button>
				<pre>
				<h3>Name      : <span class="sedit_name" class="prof_content" contenteditable><%=studobj.getName()%></span></h3><br>
				<h3>Sem       : <span class="sedit_sem" class="prof_content" contenteditable><%=studobj.getSemester()%></span></h3><br>
				<h3>About me  : <span class="sedit_about" class="prof_content" contenteditable><%=studobj.getAbout()%></span></h3><br>
				<h3>Skills    : <span class="sedit_skills" class="prof_content" contenteditable><%=studobj.getSkills()%></span></h3><br>
				<h3>Hobbies   : <span class="sedit_hobbies" class="prof_content" contenteditable><%=studobj.getHobbies()%></span></h3><br>
				<h3>Phone No  : <span class="sedit_phno" class="prof_content" contenteditable><%=studobj.getPhoneNo()%></span></h3><br>
				</pre>
		<% }else if(type.equals("faculty")) { %>

				<button type="button" class="fprof_edit_button btn btn-primary">update</button>
				<pre>
				<h3>Name      : <span class="fedit_name" class="prof_content" contenteditable><%=facobj.getName()%></span></h3><br>
				<h3>About me  : <span class="fedit_about" class="prof_content" contenteditable><%=facobj.getAbout()%></span></h3><br>
				<h3>subjects handling : <span class="fedit_subs" class="prof_content" contenteditable><%=facobj.getSubjects()%></span></h3><br>
				<h3>Phone No  : <span class="fedit_phno" class="prof_content" contenteditable><%=facobj.getPhoneNo()%></span></h3><br>
				</pre>
		<% } %>
			</div>
		</div>

</div>

</div>
</body>
</html>