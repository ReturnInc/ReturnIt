<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='TelaGeral.css'>
</head>

<body>

    <header>
       <div class ="header">
        <h1> Return It! </h1>
        <form method="post">
        </form>
        </div>
    </header>
    
    <div class ="center"> 
        <h1> Fa�a seu cadastro! </h1>
        <form method="post">

        <div class ="txt_field"> 
            <input type ="text" required>
            <span></span>
            <label> Email </label>    
        </div>

        <div class ="txt_field"> 
            <input type ="password" required>
            <span></span>
            <label> Senha </label>    
        </div>

        <div class ="pass"> Esqueceu a senha? </div>

        <input type ="submit" value="Login">

        <div class="signup_link"> 
           N�o tem cadastro? <a href="#"> Fazer cadastro </a> 
        </div>

      </form>
    </div> 
</body>
</html>