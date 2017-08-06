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
<div id="placements" class="index">
	<div class="content_container">
		<div class="content_area">
			
				<div class="Page_title">
					<h2> placements</h2>
				</div>

				<div id="placement_area">

					<div id="placeinsert" ><?php if($utype == 'faculty')
													{
														?>  style="display: block;" <?php 
													}else{
						 								?> style="display: none;" <?php
												} ?> >
						<input id="comp_name" type="text" name="reqInput" placeholder="company name"><br><span id="compSpan"></span>
						<textarea id="comp_textarea" rows="3" cols="100" placeholder="desciption for recruitment"></textarea><br><span id="comtextSpan"></span>
						interview date : <input id="placedate" type="text" name="placedate"><span id="pdateSpan"></span>
						pakage/lpa : <input id="package" type="text" name="package"><br><span id="packageSpan"></span>

						send mail to : 

						<select class="txt" id="placeselect" name="placeselect">
				
							<option value="empty">select course</option>
							<option value="mca">MCA</option>
							<option value="cs">CS</option>
							<option value="is">IS</option>
							<option value="mech">mechanical</option>
							<option value="ec">EC</option>			

						</select><br>

						<span style="color: blue;">note: by default mail will be sent to all final year students.</span><br>



						<button type="button" class="btn btn-primary" id="place_but" rel="<?php echo $fid;?>">post</button>
					</div>

					<div class="placeArea">
<?php
							$plsql = "SELECT * FROM placement ORDER BY plc_id DESC";
							$presult = $conn->query($plsql);
						if ($presult->num_rows > 0) { 
							while($prow = $presult->fetch_assoc()){ ?>
							<h3>company name: <?php echo $prow['compname'];?></h3>
							package: <?php echo $prow['package'];?>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							on date: <?php echo $prow['plc_date'];?><br>
							criteria: <?php echo $prow['criteria'];?>


<?php						}
						}else{
							echo "no interviews";
						}
?>

					</div>
					<div class="replaceArea"></div>


				</div>
		</div>
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