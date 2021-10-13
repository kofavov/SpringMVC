<html>
<head>
    <title>Login</title>
</head>
<body>
<a href="/sign_up">Добавить пользователя</a>
<form action="/login/process" method="post">
    <div>
        Email: <input name="email" type="email">
    </div>
    <div>
        Password: <input name="password" type="password">
    </div>
    <input type="submit">
</form>
<#if error??>
    Неверный email или пароль
</#if>
</body>
</html>