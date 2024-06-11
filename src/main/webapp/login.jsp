<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container">
        <h2 class="w3-center">Connexion</h2>
        <div class="w3-card-4 form-container">
            <form action="login" method="post">
                <div class="w3-section">
                    <label for="username">Nom d'utilisateur:</label>
                    <input type="text" class="w3-input" id="username" name="username" required>
                </div>
                <div class="w3-section">
                    <label for="password">Mot de passe:</label>
                    <input type="password" class="w3-input" id="password" name="password" required>
                </div>
                <button type="submit" class="w3-button w3-block w3-blue">Se connecter</button>
            </form>
            <c:if test="${not empty param.error}">
                <p class="w3-text-red w3-center">Nom d'utilisateur ou mot de passe incorrect</p>
            </c:if>
        </div>
    </div>
</body>
</html>
