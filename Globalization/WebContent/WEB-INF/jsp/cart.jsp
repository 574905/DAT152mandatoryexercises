<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     
      <fmt:setLocale value="${language}"/>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<fmt:bundle basename="no.hvl.dat152.properties/Bundle">


<fieldset>
<form method="post">

<button type = "submit" name = "lang" value = "no"><img src="images/norwegian_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "en"><img src="images/usa_flag.jpg" width = "35px" height = "30px"></button>
<button type = "submit" name = "lang" value = "es"><img src="images/spanish_flag.jpg" width = "35px" height = "30px"></button>

</form>
</fieldset>

<h1><fmt:message key = "cart"></fmt:message></h1>
<table border = "1">

<tr>

<th><fmt:message key = "name"></fmt:message></th>
<th><fmt:message key = "shortDescription"></fmt:message></th>
<th><fmt:message key = "price"></fmt:message></th>
<th><fmt:message key = "quantity"></fmt:message></th>
<th><fmt:message key = "totalAmount"></fmt:message></th>

</tr>

<c:forEach items = "${cart}" var = "p">
<tr>
<td>${p.name}</td>
<td>${p.description[language.language]}</td>
<td>${p.price}</td>
<td></td>
<td></td>

</tr>
</c:forEach>




</table>


<p>
	<a href = "homepage"><fmt:message key = "home"></fmt:message></a>
	<a href = "product"><fmt:message key = "link_products"></fmt:message></a>
</p>
</fmt:bundle>
</body>
</html>