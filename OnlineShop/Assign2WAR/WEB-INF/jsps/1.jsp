<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/productList.css" />
<script language="javascript" type="text/javascript">

	function deleteConfirm() {
		var b = confirm("You confirm?");
		if (b)
			return true;
		else
			return false;
	}

	function changeQuantity(o, id, preValue) {
		var currentQuantity = o.value;
		
		if (currentQuantity <= 0 || currentQuantity != parseInt(currentQuantity)) {
			alert("please enter integer number");
			o.value = preValue;
			o.select();
			return;
		}

		var b = confirm("are you sure the quantity will be changed to "
				+ currentQuantity);
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/FacadeServlet?id="
					+ id + "&quantity=" + currentQuantity+"&action=change-quantity";
		}
	}
</script>

</head>
<body>
<div id="top"></div>
<div id="container">
<div id="logo"></div>
<div id="select">
<h2>Product List <span
	style="vertical-align: bottom; font-size: 9px">sort by the
catalog</span></h2>
<table class="mytable" cellspacing="0" summary="catalogs">
	<tr>
		<c:forEach var="entry" items="${pl.kind}">
			<td scope="col" abbr="${entry}"><a
				href="FacadeServlet?action=show-product-list&kind=${entry }"
				onclick=" show('${pl.currentPage})">${entry}</a></td>
		</c:forEach>
	</tr>
</table>
</div>

<c:if test="${empty(pl.productList)}">
	<table class="mytable" cellspacing="0" summary="productsList">
		<tr>
			<td class="alt">please choose a catalog to show the product list</td>
		</tr>
	</table>
</c:if> <c:if test="${!empty(pl.productList)}">
	<table id="mylist" class="mytable" cellspacing="0"
		summary="productsList">
		<tr>
			<th colspan="5" scope="col" abbr="title">Product List</th>
		</tr>
		<tr>
			<th scope="col" abbr="ProductCatalog">Catalog</th>
			<th scope="col" abbr="ProductCode">Code</th>
			<th scope="col" abbr="ProductPrice">Price</th>
			<th scope="col" abbr="ProductDescription">Description</th>
			<th scope="col" abbr="Operation">Operation</th>
		</tr>
		<c:forEach var="entry" items="${pl.productList }">
			<tr>
				<td class="alt">${entry.category}</td>
				<td class="alt">${entry.pcode}</td>
				<td class="alt">A$ ${entry.price}</td>
				<td class="alt">${entry.pdesc}</td>
				<td class="alt"><a title="put it onto my cart"
					href="FacadeServlet?action=show-cart&id=${entry.pcode}"> <img
					src="images/cart_icon.jpg" width="64px" height="64px"
					style="border: 0;" /></a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" class="alt"><a
				href="FacadeServlet?action=show-product-list&wantedPage=${pl.prePage}">Previous
			Page</a> &nbsp; <a
				href="FacadeServlet?action=show-product-list&wantedPage=${pl.nextPage }">Next
			Page</a></td>
		</tr>
	</table>
</c:if> <c:if test="${!empty(cart.cart)}">
	<table class="mytable" cellspacing="0" summary="myCart">
		<tr>
			<th colspan="7" scope="col" abbr="title">your Shopping Cart</th>
		</tr>
		<tr>
			<th scope="col" abbr="ProductCatalog">Catalog</th>
			<th scope="col" abbr="ProductCode">Code</th>
			<th scope="col" abbr="ProductPrice">Price</th>
			<th scope="col" abbr="ProductDescription">Description</th>
			<th scope="col" abbr="ProductQuantity">Quantity</th>
			<th scope="col" abbr="LineTotalPrices">LineTotalPrices</th>
			<th scope="col" abbr="Operation">Operation</th>
		</tr>
		<c:forEach var="entry" items="${cart.cart}">
			<tr>
				<td class="alt">${entry.product.category}</td>
				<td class="alt">${entry.product.pcode}</td>
				<td class="alt">A$ ${entry.product.price}</td>
				<td class="alt">${entry.product.pdesc}</td>
				<td class="alt"><input type="text" value="${entry.quantity}"
					onchange="changeQuantity(this, ${entry.product.pcode}, ${entry.quantity})"></input>
				</td>
				<td class="alt">A$ ${entry.totalPrice}</td>
				<td class="alt"><a title="remove this product"
					href="FacadeServlet?action=remove-cart-item&id=${entry.product.pcode}"
					onclick="return deleteConfirm()"> <img src="images/remove.jpg"
					width="64px" height="64px" style="border: 0;" /></a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" class="alt" style="font-size: 12px;">Grand Total
			Prices: A$ ${cart.totalPrice}</td>

			<td colspan="1" class="alt"><a title="Customer Details"
				href="customerDetails.html" onclick="return deleteConfirm()"> <img src="images/purchaseOrder.jpg"
				width="64px" height="64px" style="border: 0;" /></a></td>

			<td colspan="1" class="alt"><a
				title="cancel the entire order for me"
				href="FacadeServlet?action=cancel-cart" onclick="return deleteConfirm()"><img
				src="images/cancel.jpg" width="64px" height="64px"
				style="border: 0;" /></a></td>
		</tr>
	</table>
</c:if></div>
</body>
</html>