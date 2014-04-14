<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<form:form method="post" action="addNewProduct.html" commandName="product">

    <table>
    <tr>
        <td><form:label path="name"><spring:message code="label.productName"/></form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="description"><spring:message code="label.productDescription"/></form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td><form:label path="type"><spring:message code="label.productType"/></form:label></td>
        <td><form:input path="type" /></td>
    </tr>
    <tr>
        <td><form:label path="price"><spring:message code="label.productPrice"/></form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addProduct"/>"/>
        </td>
    </tr>
</table>
</form:form>

</body>
</html>