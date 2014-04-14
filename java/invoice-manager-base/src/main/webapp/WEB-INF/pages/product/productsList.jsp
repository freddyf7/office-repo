<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Products List</title>
</head>
<body>

<h3>Products List</h3>
<c:if  test="${!empty productsList}">
<table class="data">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Type</th>
    <th>Price</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${productsList}" var="product">
    <tr>
        <td>${product.idProduct}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.type}</td>
        <td>${product.price}</td>
        <td><a href="delete/${product.idProduct}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="addProduct">Adicionar Produto</a>
</c:if>
</body>
</html>