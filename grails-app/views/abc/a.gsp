<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
<script>
$(document).ready(function(){
  $(".img-swap").live('click', function() {
    if ($(this).attr("class") == "img-swap") {
      this.src = this.src.replace("_off","_on");
    } else {
      this.src = this.src.replace("_on","_off");
    }
   // $(this).toggleClass("on");
  });
});</script>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200,width=150');
	if (window.focus) {newwindow.focus()}
	return false;
}


</script>


</head>

<body>
<%--<svg width="50" height="50">
    <circle cx="25" cy="25" r="22"
     fill="blue" stroke="gray" stroke-width="2"/>
</svg>
--%><table><tr>
<%
    for ( int i = 0; i < 30; i++ ) {
        %>
		
<td>
 <a href="g.gsp?id=${i}" onclick="return popitup('g.gsp?id=${i}')" > <img src="C:\Users\Praveen\Desktop\img_swap_off.png" class="img-swap" id =${i} /></a>
</td>

<%
//println "${i}"	
}
%>
</tr></table>
  
<%--<canvas id="myCanvas" width="200" height="100"
style="border:1px solid #000000;">
</canvas>  
  
  <a href="popupex.html" onclick="return popitup('popupex.html')"
	>Link to popup</a>
--%></body>
</html>