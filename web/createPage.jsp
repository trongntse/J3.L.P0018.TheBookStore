
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>

<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts -->
        <link rel="dns-prefetch" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">



        <link rel="icon" href="Favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <title>Create_Book</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
            <div class="container">
                <a class="navbar-brand" href="adminPage.jsp">MANAGER_BOOK</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

        <main class="my-form">
            <div class="cotainer">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">Create_Book</div>
                            <div class="card-body">
                                <form name="my-form" action="AdminInsertController" method="post">
                                    <div class="form-group row">
                                        <label for="bookID" class="col-md-4 col-form-label text-md-right">Book ID</label>
                                        <div class="col-md-6">
                                            <input type="text" value="${param.bookID}" class="form-control" name="txtBookID" required="true">
                                        </div>
                                        <c:if test="${requestScope.ERROR_BOOK !=null}">
                                            <script>alert("${requestScope.ERROR_BOOK}")</script>
                                        </c:if>
                                    </div>

                                    <div class="form-group row">
                                        <label for="book_name" class="col-md-4 col-form-label text-md-right">Book Name</label>
                                        <div class="col-md-6">
                                            <input type="text" value="${param.bookName}" class="form-control" name="txtBookName" required="true">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="image" class="col-md-4 col-form-label text-md-right">Image</label>
                                        <div class="col-md-6">
                                            <input type="file" value="" class="form-control" placeholder="Enter Description" name="txtImage" required="true">
                                        </div>
                                    </div>    

                                    <div class="form-group row">
                                        <label for="author" class="col-md-4 col-form-label text-md-right">Author</label>
                                        <div class="col-md-6">
                                            <input type="text" value="${param.author}" class="form-control" name="txtAuthor" required="true">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="description" class="col-md-4 col-form-label text-md-right">Description</label>
                                        <div class="col-md-6">
                                            <input type="text" value="${param.description}" class="form-control" name="txtDescription" required="true">
                                        </div>                                     
                                    </div>

                                    <div class="form-group row">
                                        <label for="price" class="col-md-4 col-form-label text-md-right">Price</label>
                                        <div class="col-md-6">
                                            <input type="text" value="${param.price}" class="form-control" name="txtPrice" required="true">
                                        </div>                                       
                                    </div>

                                    <div class="form-group row">
                                        <label for="categoryID" class="col-md-4 col-form-label text-md-right">Category ID</label>
                                        <div class="col-md-6">
                                            <select name="txtCategoryID" class="form-select">
                                                <c:forEach items="${sessionScope.LIST_CATE}" var="dto">
                                                    <option value="${dto.getCategoryID()}">${dto.getCategoryName()}</option>                              
                                                </c:forEach>
                                                
                                            </select>
                                           
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="quantity" class="col-md-4 col-form-label text-md-right">Quantity</label>
                                        <div class="col-md-6">
                                            <input min="0" type="number" value="${param.quantity}" class="form-control" name="txtQuantity" required="true">
                                        </div>
                                    </div>



                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-primary">CREATE_BOOK</button>
                                    </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>

