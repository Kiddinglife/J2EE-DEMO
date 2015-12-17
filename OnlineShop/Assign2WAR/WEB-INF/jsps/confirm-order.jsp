<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Conform Order</title>
<link rel="stylesheet" type="text/css" href="css/productList.css" />
</head>
<body style="text-align: center;">
<div style="width: 300px; margin:0 auto;">
<table id="mylist" class="mytable" cellspacing="0" summary="productsList" style="width: 300px;">
	<tr>
		<th colspan="2" scope="col" abbr="title">details record</th>
	</tr>
	<tr>
		<td class="alt">gname</td>
		<td class="alt">${customer.givenname}</td>
	</tr>
	<tr>
		<td class="alt">sname</td>
		<td class="alt">${customer.surname}</td>
	</tr>
	<tr>
		<td class="alt">email</td>
		<td class="alt">${customer.email}</td>
	</tr>
	<tr>
		<td class="alt">address</td>
		<td class="alt">${customer.address}</td>
	</tr>
	<tr>
		<td class="alt">postcode</td>
		<td class="alt">${customer.postcode}</td>
	</tr>
		<tr>
		<td class="alt">country</td>
		<td class="alt">${customer.country}</td>
	</tr>
	<tr>
		<td class="alt">payment</td>
		<td class="alt">${customer.payment}</td>
	</tr>
	<tr>
		<td class="alt"><a href="FacadeServlet?action=save-order">proceed</a></td>
		<td class="alt"><a href="FacadeServlet?action=cancel-order">cancel</a></td>
	</tr>
</table>
</div>
</body>
</html>