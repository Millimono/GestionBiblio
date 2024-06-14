<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .form-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="w3-container">
        <h2 class="w3-center">Inscription</h2>
        <div class="w3-card-4 form-container">
            <form action="register" method="post">
                <div class="w3-section">
                    <label for="username">Nom d'utilisateur:</label>
                    <input type="text" class="w3-input" id="username" name="username" required>
                </div>
                <div class="w3-section">
                    <label for="password">Mot de passe:</label>
                    <input type="password" class="w3-input" id="password" name="password" required>
                </div>
                <div class="w3-section">
                    <label for="email">Email:</label>
                    <input type="email" class="w3-input" id="email" name="email" required>
                </div>
                <div class="w3-section">
                    <label for="role">Rôle:</label>
                    <select class="w3-select" id="role" name="role">
                        <option value="user">Utilisateur</option>
                        <option value="admin">Administrateur</option>
                    </select>
                </div>
                <button type="submit" class="w3-button w3-block w3-blue">S'inscrire</button>
            </form>
        </div>
    </div>
</body>
</html>
