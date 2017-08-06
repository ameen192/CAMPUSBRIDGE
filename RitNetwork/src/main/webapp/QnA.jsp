<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.campus.dto.Student"%>
<%@ page import="edu.campus.dto.Faculty"%>
<%@ page import="edu.campus.dto.Questions"%>
<%@ page import="edu.campus.dto.Q_answers"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="qna" class="index">
		<div class="content_container">

			<div class="content_area">

				<!--page title-->
				<div class="Page_title">
					<h2>Question and answers</h2>
				</div>
				<!--ask question-->
				<div id="ask_Question"
					<%
						if (type.equals("student")) {
					%>
					style="display: block;"
					<%
						} else {
					%>
					style="display: none;"
					<%
						}
					%>
					>
					<textarea id="ques_textarea" rows="6" cols="100"
						placeholder="Post a Question"></textarea>
					<br>
					<button type="button" class="btn btn-primary" id="ask_ques">ask</button>
					<div class="inunresponded"></div>
				</div>


				<button id="refreshqna" class="btn btn-primary" type="button">refresh</button>
				
				
				<div <%if (type.equals("faculty")) {%>style="display: block; margin-top: 20px;"
					<%
						} else {
					%>style="display: none;"<%
						}
					%>></div>

				<div class="qnafilter">
					filter by : <select name="filter">
						<option value="ComputerApplications">computerApplications</option>
						<option value="civil">civil</option>
						<option value="mechanical">mechanical</option>
						<option value="ec">electronics</option>
					</select>
				</div>
				<div id="newest">


					<%
						List<Questions> ques = (List<Questions>) request.getAttribute("ques");
					if(ques != null){
						for (Questions q : ques) {
							List<Q_answers> ans = (List<Q_answers>) q.getAns();
					%>

					<div class="QnA_list">
						<br> <br>
						<div class="ques_div">
							<h3><%=q.getQuestion()%></h3>
						</div>
						<br>
						<div class="ans_list" style="display: none;">
							<%
							if(ans != null){
								for (Q_answers a : ans) {
									System.out.println(ans.size());
							%>

								<h5>
									<%=a.getAnswer_desc()%>
									<%
										if ((type.equals("student") && (a.getStud().getUsn()) == studobj.getUsn())
														|| (type.equals("faculty")
																&& (a.getFac().getFaculty_coll_id() == facobj.getFaculty_coll_id()))) {
											
									%><br><button class="del_ans btn btn-secondary btn-sm">delete</button>

									<%
										}
								}
							}else{
									%>
								be the first to answer</h5>
						   <%}%>



						</div>

						<div class="QnAopt">

							<div class="anser_textarea" style="display: none;">
								<textarea class="ansTextArea" cols="100" rows="4" style="overflow: scroll;"
									placeholder="enter your answer here :"></textarea>
								<br> <span class="ansSpan"></span>
								<button type="button" class="sub_ans btn btn-primary btn-sm" rel="<%=q.getQues_id()%>">submit</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="can_ans btn btn-primary btn-sm">cancel</button>
							</div>


							<button type="button" class="ans_view btn btn-primary">view answers</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="ans_but btn btn-primary">answer</button>
										
							<% 		if(type.equals("student") && (q.getStud().getUsn()) == studobj.getUsn()){	%>
									

							<button type="button" class="del_but btn btn-primary">delete</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							asked by : <%=q.getStud().getName() %>
							<%} //if loop close %>


						</div>
					</div>
					<div class="inunresponded"></div>
					<%
						} 
					}//while loop close
						else{ %>
							<h3> no questions yet </h3> 
					<%	}
						
					%>

				</div>
				<div class="loadhere"></div>
			</div>
		</div>
	</div>
</body>
</html>