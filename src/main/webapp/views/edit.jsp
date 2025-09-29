<%--
  Created by IntelliJ IDEA.
  User: luan
  Date: 9/22/2025
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center text-danger">cap nhat san pham</h1>
    <div class="col-lg-8">
        <f:form method="post" action="" modelAttribute="product" enctype="multipart/form-data">
            <div class="form-group">
                <label >Ten san pham</label>
                <f:input path="productName" type="text"  class="form-control" />
                <f:errors path="productName" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Gia san pham</label>
                <f:input path="productPrice" type="text" class="form-control" />
                <f:errors path="productPrice" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="">Lua chon danh muc</label>
                    <f:select class="form-control" path="category.id" id="">
                      <c:forEach items="${categories}" var="category">
                          <option value="${category.id}"
                              ${category.id == product.category.id ? "selected" : ""}>
                                  ${category.categoryName}</option>
                      </c:forEach>

                    </f:select>
            </div>
            <div class="form-group">
                <label>To ta san pham</label>
                <f:input path="description" type="text" class="form-control" />
                <small class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label>Anh </label>
                <input type="file" class="form-control" name="image" />
                <img src="${product.urlImage}" width="150px">
            </div>
            <button type="submit" class="btn btn-primary">Cap nhat</button>
        </f:form>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>