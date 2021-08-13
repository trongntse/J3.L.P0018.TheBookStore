

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User_Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./fonts/fontawesome-free-5.14.0/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/478461b23c.js" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">

                        <div class="col-sm-9">	
                            <div class="container">
                                <a class="navbar-brand" href="LoadAllBookController">BOOK-STORE</a>
                                <button class="navbar-toggler" type="button" >
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                            </div>
                            <style>
                                #link { color: #FF0000; } 
                            </style>
                            <a id="link" class="dropdown-item" href="LogoutController"><i class="fas fa-sign-out-alt"></i>Logout</a>
                        </div>                                            
                    </div>                      

                </div>                           
                <div class="table-filter">                    
                   <div class="row">                       
                        <div class="col-sm-12">
                            <form action="SearchController">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                                <div class="filter-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" name="txtSearch" value="">
                                </div>
                            </form>
                            <!-- CART-->
                            <tag:if test="${sessionScope.CART != null}">
                                <tag:url var="urlCart" value="promotionList.jsp">
                                </tag:url>
                                <a href="${urlCart}">
                                    <span>Shopping_Cart</span>
                                    <i class="fa fa-shopping-cart"></i>
                                </a>
                            </tag:if> 
                        </div>
                    </div>

                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>                           

                            <th>Image</th>
                            <th>BookName</th>
                            <th>Author</th>												
                            <th>Description</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th></th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="dto" items="${sessionScope.LIST_BOOK}" >         
                        <form action="UpdateController">
                            <tr>                              

                                <td>
                                    <input style="width: 150px; height: 300px " type="hidden" name="txtImage" value="${dto.image}" class="form-control"/>          
                                    <img  src="./images/${dto.image}" alt="${dto.image}" width="80px" height="70px" />

                                </td>

                                <td>
                                    <input class="form-control" style="width: 80px" type="text" name="txtBookName" value="${dto.bookName}" readonly="true"/>
                                </td>
                                <td>
                                    <input class="form-control" style="width: 100px" type="text" name="txtAuthor" value="${dto.author}" readonly="true"/>
                                </td>
                                <td>
                                    <input class="form-control" style="width: 70px" type="text" name="txtDescription" value="${dto.description}" readonly="true"/>                                  
                                </td>

                                <td>
                                    <input class="form-control" style="width: 100px" type="email" name="txtPrice" value="${dto.price}" readonly="true"/>  
                                </td>                               
                                <td>
                                    <input class="form-control" type="text" name="txtCategoryID" value="${dto.categoryID}" readonly="true"/>                                     
                                </td>

                                <td>
                                    <input class="form-control" type="text" name="txtQuantity" value="${dto.quantity}" readonly="true"/>                                      
                                </td> 

                                <td>   

                                </td>

                                <td>

                                </td>

                                <td>
                                    <button class="btn" type="submit" title="ADD TO CART"><i class="far fa-calendar-plus"></i></button>
                                </td>

                                <td>

                                </td>
                            </tr>                      
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>     
    </body>
</html>                                		

