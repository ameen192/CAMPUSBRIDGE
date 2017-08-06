<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="background-color: #cccccc">
<a href="index.php" target="_blank">
		  <img style="height: 150px;" src="resources/img/transparent.png" alt="logo">
		 </a>
	
<div class="registration_div">
		
		
	<div class="regformdiv">
			
				
			
		<form id="reg_form" action="RegServ" method="POST">
				
						<h2> Registration Form</h2>

				<input class="txt" type="text" name="name" placeholder="name" required><br>
				<input class="txt" id="pwd" type="password" name="password" placeholder="password" required><br><span id="passSpan"></span>
				<input class="txt" id="pwd2" type="password" name="password2" placeholder="re-enter password" required><br><span id="pass2Span"></span>
				
			<div class="radio_gender">
				Gender :
				<input type="radio" name="gender" value="male" required> Male
				<input type="radio" name="gender" value="female"> female
				<input type="radio" name="gender" value="other"> Other<br>
			</div>	

				<input class="txt" id="reg_email" type="email" name="email" placeholder="enter email Id" required><br><span id="emailSpan"></span>

			<div class="radiotype">
				Type : <input type="radio" name="type" value="student" id="stud">student
				
				<input type="radio" name="type" value="faculty" id="fac"> faculty <br>
			</div>

			<div id="studdiv" style="display: none;">																		<!--stud division-->


				<select id="deptsel" class="txt" type="text" name="sdepartment" placeholder="department"> 
				
				<option value="empty">select department</option>
				<option value="compApp" class="selcomp">computer applications</option>
				<option value="engn" class="selengg">engineering</option>

				</select><br>		<!-- department-->
				
				<select style="display: none;" class="txt" id="mca" type="text" name="course" placeholder="course">  <!--select mca-->

				<option value="empty">select course</option>
				<option value="mca">MCA</option>

				</select>

				<select style="display: none;" class="txt" id="engn" type="text" name="course" placeholder="course">	<!--select engn-->
				
				<option value="empty">select course</option>
				<option value="cs">CS</option>
				<option value="is">IS</option>
				<option value="mech">mechanical</option>
				<option value="ec">EC</option>			

				</select><br>


				<select class="txt" type="text" name="semester" placeholder="semester">
					<option value="">select sem</option>
					<option value="1">1st</option>
					<option value="2">2nd</option>
					<option value="3">3rd</option>
					<option value="4">4th</option>
					<option value="5">5th</option>
					<option value="6">6th</option>
					<option value="7">7th</option>
					<option value="8">8th</option>

				</select><br>




				<input class="txt" id="reg_usn" type="text" name="usn" placeholder="usn"><br><span id="usnSpan"></span>
				
			</div>
			<div id="facultydivision" style="display: none;">
				<select class="txt" name="fdepartment"> 
				
				<option value="empty">select department</option>
				<option value="compApp">computer applications</option>
				<option value="engn">engineering</option>

				</select><br>		<!-- department-->



				<input class="txt" id="reg_fid" type="text" name="faculty_coll_id" placeholder="faculty id"><br><span id="fidSpan"></span>
			</div>
			<input id="sub_but" type="submit" value="register">
		
		</form> 
	</div>
</div>

<script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
  <script>window.jquery || document.write('<script src="resources/js/jquery-3.1.js"><\/script>')</script>
<script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="resources/js/ajaxCode.js"></script>
<script type="text/javascript" src="resources/js/myjquery.js"></script>
<script type="text/javascript" src="resources/js/myjquery.js"></script> 
</body>
</html>