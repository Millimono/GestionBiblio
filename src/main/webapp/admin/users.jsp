<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Utilisateurs</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        form {
            margin-top: 20px;
        }
    </style>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-bar w3-light-grey">
        <a href="${pageContext.request.contextPath}/admin/home" class="w3-bar-item w3-button w3-black">Accueil</a>
        <a href="${pageContext.request.contextPath}/admin/home" class="w3-bar-item w3-button">Gestion des Livres</a>
        <a href="${pageContext.request.contextPath}/admin/users" class="w3-bar-item w3-button">Gestion des Utilisateurs</a>
        <a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3-button">Déconnexion</a>
    </div>
    <div class="w3-container w3-margin-top">
        <h1 class="w3-center">Liste des Utilisateurs</h1>
        <table class="w3-table w3-bordered w3-striped">
            <thead>
                <tr>
                    <th>Nom d'utilisateur</th>
                    <th>Email</th>
                    <th>Rôle</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.role.name}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/admin/users" method="post" style="display:inline;">
                                <input type="hidden" name="_method" value="DELETE">
                                <input type="hidden" name="id" value="${user.id}">
                                <button type="submit" class="w3-button w3-red">Supprimer</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/admin/users/edit" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="${user.id}">
                                <button type="submit" class="w3-button w3-yellow">Modifier</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h2 class="w3-center">Ajouter un Nouvel Utilisateur</h2>
        <form action="${pageContext.request.contextPath}/admin/users" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="username" type="text" placeholder="Nom d'utilisateur" required>
                </div>
            </div>
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="password" type="password" placeholder="Mot de passe" required>
                </div>
            </div>
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-blue w3-margin-right">?</i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="email" type="email" placeholder="Email" required>
                </div>
            </div>
            <div class="w3-section">
                <label for="role">Rôle:</label>
                <select class="w3-select" id="role" name="role">
                    <option value="user">Utilisateur</option>
                    <option value="admin">Administrateur</option>
                </select>
            </div>
            <button type="submit" class="w3-button w3-block w3-blue">Ajouter</button>
        </form>
    </div>
</body>
</html>
