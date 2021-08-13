

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin_Page</title>
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
                            <h2> <b>Wellcom Admin: ${LOGIN_USER.userName}</b></h2>
                            <style>
                                #link { color: #FF0000; } 
                            </style>
                            <a id="link" class="dropdown-item" href="LogoutController"><i class="fas fa-sign-out-alt"></i>Logout</a>
                        </div>
                        <style>
                            #links { color: #31B404; } 
                        </style>
                        <a id="links" class="dropdown-item" href="createPage.jsp"><i class="fas fa-folder-plus"></i> INSERT-BOOK</a>

                    </div>                      

                </div>                           
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>                           
                            <th>BookID</th>
                            <th>BookName</th>
                            <th>Image</th>												
                            <th>Author</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>categotyID</th>
                            <th>Quantity</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="dto" items="${sessionScope.LIST_BOOKS}" >         
                        <form action="AdminUpdateController">
                            <tr>
                                <td>
                                    <input class="form-control" style="width: 50px" type="text" name="txtBookID" value="${dto.bookID}" readonly="true"/>
                                </td>
                                <td>
                                    <input class="form-control" style="width: 100px" type="text" name="txtBookName" value="${dto.bookName}" required="true"/>
                                </td>

                                <td>
                                    <input style="width: 90px" type="file" name="txtImage" value="${dto.image}" class="form-control"/>          
                                    <img  src="./images/${dto.image}" alt="${dto.image}" width="80px" height="70px" />
                                    <input type="hidden" name="oldImage" value="${dto.image}"/>
                                </td>

                                <td>
                                    <input class="form-control" style="width: 70px" type="text" name="txtAuthor" value="${dto.author}" required="true"/>                                  
                                </td>

                                <td>
                                    <input class="form-control" style="width: 100px" type="text" name="txtDescription" value="${dto.description}" required="true"/>  
                                </td>                               
                                <td>
                                    <input class="form-control" style="width: 80px" type="number" min="0" name="txtPrice" value="${dto.price}" required="true"/>                                     
                                </td>

                                <td>    
                                    <select name="txtCategoryID" class="form-select">
                                        <tag:if test="${sessionScope.LIST_CATE != null}">
                                            <tag:set var="listCate" value="${sessionScope.LIST_CATE}" scope="page"></tag:set>
                                            <tag:if test="${not empty pageScope.listCate}">
                                                <tag:set var="cateChose" value="${dto.categoryID}" scope="page"></tag:set>
                                                <tag:forEach var="category" items="${pageScope.listCate}">
                                                    <option value="${category.categoryID}" <tag:if test="${category.categoryID == cateChose}">selected</tag:if>>
                                                        ${category.categoryID}
                                                    </option>
                                                </tag:forEach>
                                            </tag:if>
                                        </tag:if>
                                    </select>                                     
                                </td>  

                                <td>
                                    <input class="form-control" min="0" style="width: 60px" type="number" name="txtQuantity" value="${dto.quantity}" required="true"/>                                      
                                </td> 
                                <td>
                                    <input class="form-control" style="width: 60px" type="text" name="txtStatus" value="${dto.status}" readonly="true"/>      

                                </td>   
                                <td>
                                    <c:url 
                                        var="urlDelete" value="AdminDeleteController">
                                        <c:param name="txtBookID" value="${dto.bookID}"/>
                                        <c:param name="txtStatus" value="${dto.status}"/>
                                    </c:url>
                                    <c:choose>
                                        <c:when test="${dto.status != false}">
                                            <a href="${urlDelete}" onclick="return confirm('ARE YOU SURE?');" class="delete" title="Delete" data-toggle="tooltip"><i class="fas fa-trash-alt"></i></a>
                                            </c:when>
                                            <c:otherwise>
                                            <a href="${urlDelete}" onclick="return confirm('ARE YOU SURE?');" class="delete" title="Return" data-toggle="tooltip"><i class="fas fa-undo-alt"></i></a>
                                            </c:otherwise>
                                        </c:choose>

                                </td>
                                <td>             
                                    <script type="text/javascript">
                                        function Alert() {
                                            alert("UPDATE SUCCESS!!");
                                        }
                                    </script>
                                    <button type="submit" onclick=" Alert()" class="delete" title="Update" data-toggle="tooltip"><i class="fas fa-pencil-alt"></i></button>      
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

