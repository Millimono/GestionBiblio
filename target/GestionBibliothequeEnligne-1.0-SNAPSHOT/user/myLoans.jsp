<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mes Emprunts</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-bar w3-light-grey">
        <a href="${pageContext.request.contextPath}/user/home" class="w3-bar-item w3-button">Accueil</a>
        <a href="${pageContext.request.contextPath}/user/searchBooks.jsp" class="w3-bar-item w3-button">Rechercher des Livres</a>
        <a href="${pageContext.request.contextPath}/user/myLoans.jsp" class="w3-bar-item w3-button w3-black">Mes Emprunts</a>
        <a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3-button">Déconnexion</a>
    </div>
    <div class="w3-container w3-margin-top">
        <h1 class="w3-center">Mes Emprunts</h1>
        <table class="w3-table w3-bordered w3-striped">
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Date d'emprunt</th>
                    <th>Date de retour</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="loan" items="${loans}">
                    <tr>
                        <td>${loan.book.title}</td>
                        <td>${loan.book.author}</td>
                        <td>${loan.loanDate}</td>
                        <td>${loan.returnDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
