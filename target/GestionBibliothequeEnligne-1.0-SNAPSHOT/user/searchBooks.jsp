<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rechercher des Livres</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-bar w3-light-grey">
        <a href="${pageContext.request.contextPath}/user/home" class="w3-bar-item w3-button">Accueil</a>
        <a href="${pageContext.request.contextPath}/user/searchBooks.jsp" class="w3-bar-item w3-button w3-black">Rechercher des Livres</a>
        <a href="${pageContext.request.contextPath}/user/myLoans" class="w3-bar-item w3-button">Mes Emprunts</a>
        <a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3-button">Déconnexion</a>
    </div>
    <div class="w3-container w3-margin-top">
        <h1 class="w3-center">Rechercher des Livres</h1>
        <form action="${pageContext.request.contextPath}/user/searchBooks" method="get" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="search" type="text" placeholder="Titre ou Auteur" required>
                </div>
            </div>
            <button type="submit" class="w3-button w3-block w3-blue">Rechercher</button>
        </form>
        <c:if test="${not empty books}">
            <h2 class="w3-center">Résultats de la recherche</h2>
            <table class="w3-table w3-bordered w3-striped">
                <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Auteur</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/user/borrowBook" method="post" style="display:inline;">
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input type="hidden" name="username" value="${sessionScope.username}">
                                    <button type="submit" class="w3-button w3-green">Emprunter</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
