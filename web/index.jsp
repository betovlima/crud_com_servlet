<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora – Multiplicar</title>
    </head>
    <style>
        a:link, a:visited {
            background-color: #f44336;
            color: white;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a:hover, a:active {
            background-color: red;
        }

        h1 {
            text-align:center;
            background-color: #e7e7e7;
            color: black;
        }

        .center {
            position: absolute;
            top: 35%;
            left: 50%;
            margin-top: -50px;
            margin-left: -50px;

        }
    </style>
    <body>

        <h1>Sistema de Cadastro de Veículos</h1>
        <div class="center">
            <a href="CadastroVeiculo.jsp" >Cadastro veiculos</a> <p>
                <a href="listarVeiculos" >Lista de veiculos</a>
        </div>
    </body>
</html>
