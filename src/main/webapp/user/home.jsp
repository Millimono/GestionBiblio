<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Home</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-bar w3-light-grey">
        <a href="${pageContext.request.contextPath}/user/home" class="w3-bar-item w3-button w3-black">Accueil</a>
        <a href="${pageContext.request.contextPath}/user/searchBooks.jsp" class="w3-bar-item w3-button">Rechercher des Livres</a>
        <a href="${pageContext.request.contextPath}/user/myLoans.jsp" class="w3-bar-item w3-button">Mes Emprunts</a>
        <a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3-button">Déconnexion</a>
    </div>
    <div class="w3-container w3-margin-top">
        <h1 class="w3-center">Bienvenue Utilisateur</h1>
        <p class="w3-center">Ceci est la page d'accueil pour les utilisateurs.</p>
    </div>
</body>
</html>
