<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Livre</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container w3-margin-top">
        <h1 class="w3-center">Modifier Livre</h1>
        <form action="${pageContext.request.contextPath}/admin/books" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="${book.id}">
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="title" type="text" placeholder="Titre du Livre" value="${book.title}" required>
                </div>
            </div>
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="author" type="text" placeholder="Auteur" value="${book.author}" required>
                </div>
            </div>
            <button type="submit" class="w3-button w3-block w3-blue">Modifier</button>
        </form>
    </div>
</body>
</html>
