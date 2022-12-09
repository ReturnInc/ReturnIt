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
    <script src='main.js'></script>
</head>
<body>
    <header>
        <div class ="header">
         <h1> Return It! </h1>
         <form method="post">
         </form>
        </div>
     </header>

     <div class = "Passo1">

         <h1> Return Inc </h1>
         <form method="post"> 

         <h2> Passo 1 - Informações Básicas </h2>
         <form method="post">

            <div class ="NomeFantasia"> 
                <input type ="text" required>
                <span> </span>
                <label> Nome Fantasia </label>   
            </div>

            <div class ="CNPJ"> 
                <input type ="text" required>
                <span> </span>
                <label> CNPJ </label>    
            </div>
         
            <div class ="NomeFantasia"> 
                <input type ="text" required>
                <span> </span>
                <label> Email </label>   
            </div>

            <div class ="CNPJ"> 
                <input type ="text" required>
                <span> </span>
                <label> Telefone/Celular </label>    
            </div>
            <div class = "Rua">
                <input type ="text" required>
                <span> </span>
                <label> Rua </label>
            </div>
           
         <div class = "Dados"> 
            
            <div class = "Numero">
                <input type ="text" required>
                <span> </span>
                <label> Numero </label>
            </div>
            
            <div class = "CEP">
                <input type ="text" required>
                <span> </span>
                <label> CEP </label>
            </div>
            
            <div class = "Bairro">
                <input type ="text" required>
                <span> </span>
                <label> Bairro </label>
            </div>
            </div>  
            
            <div class = "Complemento">
                <input type ="text" required>
                <span> </span>
                <label> Complemento </label>
            </div>
            
            <div class ="NomeFantasia"> 
                <input type ="Password" required>
                <span> </span>
                <label> Senha </label>   
            </div>

            <div class ="CNPJ"> 
                <input type ="password" required>
                <span> </span>
                <label> Confirmar Senha </label>    
            </div>

            <input type ="submit" value="Avançar">

            <div class="signup_link"> 
                Já possui cadastro? <a href="#"> Fazer Login </a> 
             </div>

     </div>
</body>
</html>