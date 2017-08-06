<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<%@ page import="edu.campus.dto.Requests"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="requests" class="index">
		<div class="content_container">
			<div class="content_area" style="padding: 50px;">

				<div class="Page_title">
					<h2>requests</h2>
				</div>

				<div id="request_topic" <%if (type.equals("student")) {%>
					style="display: block;" <%} else {%> style="display: none;" <%}%>>
					<input id="req_title" type="text" name="reqInput"
						placeholder="request title"><br> <span
						id="reqtitleSpan"></span>
					<textarea id="req_textarea" rows="3" cols="100"
						placeholder="desciption for request"></textarea>
					<br> <span id="reqtextSpan"></span>
					<button type="button" class="btn btn-primary" id="req_but">request</button>
				</div>
				<div class="inunresponded"></div>

				<button id="refreshreq" class="btn btn-primary" type="button">refresh</button>




<!-- request list area -->
				<div class="req_list">
						<%
							List<Requests> reqs = (List<Requests>) request.getAttribute("reqs");
							if (reqs != null) {
								for (Requests r : reqs) {
						%>
				
					<div class="reunresponded"></div>
					<div class="unresponded">
						<h4 style="margin-top: 20px;">title :&nbsp;&nbsp; <%=r.getReq_title()%></h4>
						<h6>description : <%=r.getReq_desc()%></h6>
						<h6>requested on : <%=r.getReq_date()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; By :<%=r.getStud().getName()%>&nbsp;(<%=r.getStud().getUsn()%>)</h6>
						<%
/* student section	 */	
						if (type.equals("student")) {
							if (studobj.getUsn() == r.getStud().getUsn()) {
						%>
								<button class="del_self_req btn btn-primary btn-sm">deleteRequest</button><%
							}
							int i = 0;
							for (Student s : r.getStudReqInterested()) {
								if (studobj.getUsn() == s.getUsn()) {
									i = 1;
								}
							}	%>
						
							<button class="req_interested btn btn-primary btn-sm" rel="<%=r.getReqID()%>" <%if (i == 1) {%>disabled <%}%>>interested</button>&nbsp;&nbsp;&nbsp;<span class="intrestednum"><%=r.getStudReqInterested().size()%></span>
						<div class="inunresponded"></div>
						<%
/* faculty section	 */					
							}else if (type.equals("faculty")) {
						%>
						<button class="resp_but btn btn-primary btn-sm">Respond</button>
						<button class="reject_but btn btn-primary btn-sm">Reject</button>
						&nbsp;&nbsp;&nbsp;<span class="intrestednum"><%=r.getStudReqInterested().size()%></span>
						
						<div class="response_area" style="display: none;">
							<textarea class="resp_textarea" rows="2" cols="60"
								placeholder="desciption for response"></textarea>
							<br> <span class="textSpan"></span> select allotment date :
							<input class="datepicker" type="text" name="resp_date"><span
								class="dateSpan"></span><br> <br>
								<h3><%=r.getReqID()%></h3>
							<button class="in_resp_butt btn btn-primary btn-sm" rel="<%=r.getReqID()%>">respond</button>

						</div>
						<div class="inunresponded"></div>
						<%
									}	%>
						<div class="interestednumdialog" style="display: none;">
							<%List<Student> studs = r.getStudReqInterested(); 
								for(Student s : studs){%>
							<%=s.getName()%>&nbsp;&nbsp;&nbsp;<%=s.getUsn()%>
							<%} %>
						</div><%
								}
							}
						%>
					</div>
					
					
						
					<div class="reresponded"></div>
					<div class="responded">
						<%
							List<Requests> respreqs = (List<Requests>) request.getAttribute("respreqs");
							if (reqs != null) {
								for (Requests rs : respreqs) {
						%>
						<h5 style="margin-top: 20px;">title :<%=rs.getReq_title()%></h5>
						<h6>description :<%=rs.getReq_desc()%></h6>
						<h6>requested on :<%=rs.getReq_date()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; By :<%=rs.getStud().getName()%>&nbsp;(<%=rs.getStud().getUsn()%>)</h6>
						<br>
						<h5>Response Details</h5>
						<h6>Response :<%=rs.getResp().getResp()%></h6>
						<h6>date alloted :<%=rs.getResp().getAllot_date()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By :<%=rs.getResp().getFac().getName()%></h6>
						<div class="inresponded"></div>
						<%
								}
							}
						%>
					</div>
					
				</div>
				<div class="rereq_list"></div>
			</div>
		</div>
	</div>
</body>
</html>