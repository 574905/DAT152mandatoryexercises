<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <fmt:setLocale value="${language}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<fmt:bundle basename="no.hvl.dat152.properties/Bundle">

<form method="post">
<fieldset>


<button type = "submit" name = "lang" value = "no"><img src="images/norwegian_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "en"><img src="images/usa_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "es"><img src="images/spanish_flag.jpg" width = "35px" height = "30px"></button>


</fieldset>

<c:set var = "count" value = "0" scope = "page"></c:set>
<c:forEach var = "p" items = "${products}">
<br>
<h3>${p.name}</h3>
<img src = "${p.imageFile}" width = "100" height = "100"><br>
<b><fmt:message key = "name"></fmt:message>${p.name}</b><br>
<b><fmt:message key = "price"></fmt:message>${p.price}</b><br>
<b><fmt:message key = "description"></fmt:message>${p.description[language.language]}</b><br>
<button type = "submit" name = "productID" value = "${count}"><fmt:message key = "addToCart"></fmt:message></button>
<c:set var = "count" value ="${count+1}" scope ="page"></c:set>
</c:forEach>


</form>



<p>
	<a href = "homepage"><fmt:message key = "home"></fmt:message></a>
	<a href = "cart"><fmt:message key = "cart"></fmt:message></a>
</p>
</fmt:bundle>
</body>
</html>