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

<!--  본문  -->
    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header">이미지 등록 페이지</h1>
            </div>
			
		 	 <form action="<%=contextPath%>/insert_image.admin" method="post" enctype="multipart/form-data">
		 	 	
		 	 	<input type="hidden" >
		 	 	
				<div class="form-group row">
		            <label for="Title" class="col-sm-2 col-form-label"><strong>제목</strong></label>
		            <div class="col-sm-10">
		                <input type="text" name="title" class="form-control" id="Title">
		            </div>
		        </div> 
		 	  
        		<div class="form-group row">
          	  		<label for="ad_type" class="col-sm-2 col-form-label"><strong>종류</strong></label>
            	
	            	<div class="col-sm-10">
	            		<select name="ad_type" class="form-control" id="ad_type">
		                <option selected>선택(필수)</option>
		                <option>간판</option>
		                <option>명함</option>
		                <option>기타</option>
		                </select><br>
	            	</div>
        		</div> 
        		

         
		        <div class="form-group row">
		            <label for="inputFile" class="col-sm-2 col-form-label"><strong>첨부 파일</strong></label>
		            <div class="col-sm-10">
		                <div class="custom-file" id="inputFile">
		                
		                	<div class="form-group" id="file-list">
 								<a href="#" onclick="addFile()">파일추가</a>  
		                 		<div class="file-group"> 
		                    		<input multiple="multiple" name="file" type="file" class="custom-file-input" id="customFile">
		                    		<a href='#' name='file-delete'>삭제</a> 
 		                    	</div>
		                   	</div>
		                   	
		                    <div class="select_img"><img src="" /></div>
		                    
		                    
		                </div>
		            </div>
		        </div>
		        
		        <div class="row">
		            <div class="col-auto mr-auto"></div>
		            <div class="col-auto">
		                <input class="btn btn-primary" type="submit" role="button" value="이미지 등록">
		            </div>
		        </div>
    		</form>
		 
        </div>
		 
		 
	 
		<%=request.getRealPath("/") %>



        <hr>

        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Company 2013</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
	
	
	<script>
		  $("#customFile").change(function(){
		   if(this.files && this.files[0]) {
		    var reader = new FileReader;
		    reader.onload = function(data) {
		     $(".select_img img").attr("src", data.target.result).width(500);        
		    }
		    reader.readAsDataURL(this.files[0]);
		   }
		  });
 	</script>
 	
 	
 	<script type="text/javascript">
	    $(document).ready(function() {
	        $("a[name='file-delete']").on("click", function(e) {
	            e.preventDefault();
	            deleteFile($(this));
	        });
	    })
	 
	    function addFile() {
	        var str = "<div class='file-group'><input name='file' type='file' class='custom-file-input' id='customFile'><a href='#' name='file-delete'>삭제</a></div>";
	        $("#file-list").append(str);
	        $("a[name='file-delete']").on("click", function(e) {
	            e.preventDefault();
	            deleteFile($(this));
	        });
	    }
	 
	    function deleteFile(obj) {
	        obj.parent().remove();
	    }
</script>


  	
 	
</div>
</body>
</html>