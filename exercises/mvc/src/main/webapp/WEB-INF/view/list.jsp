<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>List movies</title>
<script type="text/javascript" src="/jquery.js"></script>
</head>
<body>
<form method="post" action="/app/movie/delete" id="form">
	<input type="hidden" name="movieId" id="movieId" />
</form>
<script type="text/javascript">
function deleteMovie(movieId) {
	$("#movieId").val(movieId);
	$("#form").submit();
}
function show(movieId, type) {
	$.ajax({
	    url: "/app/movie/show/" + movieId,
	    type: "GET",
	    dataType: type,
	    contentType: "application/" + type,
	    cache: false,
	    success: function(data, textStatus, jqXHR) {
	    	alert("OK: " + jqXHR.responseText);
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
	    	alert("ERROR: " + textStatus);
	    }
	});
}
</script>
<h1>Movies</h1>
<table id="moviesTable">
	<c:forEach items="${movies}" var="movie">
		<tr>
			<td>
				<a href="/app/movie/${movie.id}">${movie.name}</a> 
				<a href="#" id="deleteMovieLink${movie.id}" onClick="deleteMovie(${movie.id})">[delete]</a> | 
				<a href="#" id="showXmlLink${movie.id}" onClick="show(${movie.id}, 'xml')">[xml]</a> |
				<a href="#" id="showJsonLink${movie.id}" onClick="show(${movie.id}, 'json')">[json]</a>	
			</td>
		</tr>
	</c:forEach>
</table>

<a href="/app/movie/create" id="createMovieLink">Create movie</a>
</body>
</html>