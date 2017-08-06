<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<%@ page import="edu.campus.dto.NoticeBoard"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp"%>
	<div id="home" class="index" style="display: block;">
		<div class="home_container">
			<div class="home_content">
				<div class="home_part1">
					<div class="home_notice">

						<div class="notice_title">
							<h3>notice board</h3>
						</div>

						<div class="insert_notice" <%if (type.equals("faculty")) {%>
							style="display: block;" <%} else {%> style="display: none;" <%}%>>

							<!-- post activity-->
							<div id="post_notice">
								<textarea id="notice_textarea" rows="4" cols="70"
									placeholder="Post notice"></textarea>
								<br> <span id="noticeSpan"></span>

							</div>

							<div class="noticefilter">
								filter by : <select id="filter_Dept" name="filter_Dept">
									<option value="all">all</option>
									<option value="compapp">computerApplications</option>
									<option value="engn">Engineering</option>
								</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
									id="filter_course_mca" name="filter_course_mca"
									style="display: none;">
									<option value="all">all</option>
									<option value="mca">MCA</option>
								</select> <select id="filter_course_engn" name="filter_course_engn"
									style="display: none;">
									<option value="all">all</option>
									<option value="cs">CS</option>
									<option value="is">IS</option>
									<option value="mech">Mechanical</option>
									<option value="ec">EC</option>
								</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="filter_sem"
									id="filter_sem" style="display: none;">
									<option value="all">all</option>
									<option value="1">1st</option>
									<option value="2">2nd</option>
									<option value="3">3rd</option>
									<option value="4">4th</option>
									<option value="5">5th</option>
									<option value="6">6th</option>
									<option value="7">7th</option>
									<option value="8">8th</option>
								</select>


								<button type="button" class="btn btn-primary" id="post_notice_butt">post notice</button>

							</div>
							<div class="inunresponded"></div>
						</div>
						
						
						<button id="notice_refresh" class="btn btn-primary" type="button">refresh</button>

						<div class="fetch_notice">

							


							<% List<NoticeBoard> notice = (List<NoticeBoard>)request.getAttribute("notice");
	
			if(notice != null){
							for(NoticeBoard eachNotice : notice){
	%>

							<div class="notice_row">
								<br> <br> <span class="n_head"> posted by: <%=eachNotice.getFac().getName()%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<small>at date : <%=eachNotice.getNotice_date()%></small>

								<h5>
									<%=eachNotice.getNotice_desc()%>
								</h5>

								<%	
								if(type.equals("faculty")){
									if(eachNotice.getFac().getFaculty_coll_id().equals(facobj.getFaculty_coll_id())) {
										%>
								<button class="del_notice btn btn-primary btn-sm" type="button"
									rel="<%=eachNotice.getNotice_id()%>">remove notice</button>
								<%
									}%>
							</div>
							
							<%	}%><div class="inunresponded"></div><% 
							}
						}else{	%>
							<h4>no notices</h4>
							<%	
				}%>
				
						</div>
	
						<div class="refetch_notice"></div>

					</div>
				</div>

				<div class="home_part2"<%if(type.equals("faculty")) {%>
							style="display: block;" <%} else {%> style="display: none;"<%}%>>
					<div class="home_activities">
						<div class="verify1">



							<div class="homepage_title">Pending verification</div>

														<div class="verify_usn">
								<br> <br>
								<h5>
									name : new user
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; usn : 1ms15mca82
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									sem : 4
								</h5>
								<button class="verify_user btn btn-primary">accept</button>
								<button class="reject_user btn btn-primary">reject</button>

							</div>

							
							<!-- <h5>no pending users</h5> -->
							
						</div>
						<div class="verify2"></div>
					</div>
					<div class="home_requests"<%if (type.equals("faculty")) {%>
							style="display: block;" <%} else {%> style="display: none;" <%}%>>
						<div class="homepage_title">Requests</div>
					</div>
				</div>
				<?php 		}
?>
			</div>
		</div>
	</div>
</body>
</html>