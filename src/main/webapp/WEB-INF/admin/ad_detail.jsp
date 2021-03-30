<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="./../common/common.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="<%=contextPath %>/resources/css/bootstrap.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/css/thumbnail-gallery.css">

<title>관리자 페이지</title>
</head>
<body>

    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.php">희소가치</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                    	<a href="#about">기타1</a>
                    </li>
                    <li>
                    	<a href="#services">기타2</a>
                    </li>
                    <li>
                    	<a href="#contact">기타3</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	<!-- main -->
   <div class="col-lg-12">
 	   <button name="insert-image" type="button" class="btn btn-default" onclick="adDelete('${ad.no}');"> 이미지삭제</button> 
   </div>
   <img class="img-responsive" src="resources${ad.image}"/>
    
    
    
    
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
    	
    function adDelete(no) {
        var url = `${pageContext.request.contextPath}/delete_ad.admin`;
		console.log("haha");
		
		if(confirm("게시물을 삭제하실건가요?") == true) {
			location.href = url+'?no='+${ad.no};
			console.log('success_delete');
		} else {
			console.log('fail_delete');
			return false;
		}
    }
    
    
    </script>

</body>
</html>