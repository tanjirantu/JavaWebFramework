<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
</head>

<body>
<h1>Weclome Page.</h1>
<jsp:useBean id="logbean" class="models.Faculty" scope = "request" /> 

<jsp:getProperty name="logbean" property="firstName" />

</body>
</html>