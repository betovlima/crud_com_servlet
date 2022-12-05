<%-- 
    Document   : AlterarVeiculo
    Created on : 28 de nov. de 2022, 11:33:10
    Author     : roberto.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados de Veículo</title>
        <script type="text/javascript" language="javascript">
            function validar_form() {
                if (document.getElementById("placa").value.length < 3) {
                    alert('Por favor, preencha o campo placa');
                    document.getElementById("placa").focus();
                    return false;
                }

                if (document.getElementById("modelo").value.length < 3) {
                    alert('Por favor, preencha o campo modelo');
                    document.getElementById("modelo").focus();
                    return false;
                }

            }
        </script>
        <style>

            * {
                font-family: Arial, Helvetica, sans-serif;
            }

            .box {
                display: flex;
                flex-direction: column;
                align-items: flex-start;
                width: 30%;
            }

            .box>*:first-child {
                align-self: stretch;
            }

            .box .selected {
                align-self: center;
            }

            .center {
                width:100%;
                left:45%;
                margin-left:35%;
                padding: 1.2rem;
            }

            .footer {
                width:90%;
                left:40%;
                margin-left:43%;
                padding: 1.2rem;
            }

            h1 {
                text-align:center;
                background-color: #e7e7e7;
                color: black;
            }

            label {
                padding: 5px;
                font-weight: bold;
                width: 130px;
                float: left;
            }

            input[type=button], input[type=submit], input[type=reset] {
                background-color: #04AA6D;
                border: none;
                color: white;
                padding: 10px 22px;
                text-decoration: none;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 4px;
            }

            input[type=button],[type=reset]:hover,[type=submit]:hover {
                background: #f44c0e;
                border-radius: 4px;
            }

            input[type=text] {
                width: 255%;
                border: 2px solid #cccccc;
                border-radius: 4px;
                box-shadow: 3px 3px 5px grey;
            }

        </style>
    </head>
    <body>
        <h1>Alterar Dados de Veículo</h1>
        <form name="FrmDadosVeiculo" method="post" action="alterarVeiculo" onSubmit="return validar_form()">
            <div class="box center">
                <input id="acao" type="hidden" name="acao" value="alterar"> 
                <input id="veiculoID" type="hidden" name="veiculoID" value="<%=request.getAttribute("veiculoID")%>"> 
                <div> <label for="placa">Placa:</label></div> 
                <div> <input id="placa" type="text" name="placa" value="<%=request.getAttribute("placa")%>"> </div>
                <div> <label for="modelo">Modelo:</label> </div> 
                <div> <input id="modelo" type="text" name="modelo" value="<%=request.getAttribute("modelo")%>"> </div>
                <div> <label for="marca">Marca:</label> </div> 
                <div> <input id="marca" type="text" name="marca" value="<%=request.getAttribute("marca")%>"> </div>
                <div> <label for="lugares">Lugares:</label></div> 
                <div> <input id="lugares" type="text" name="lugares" value="<%=request.getAttribute("lugares")%>"> </div>
                <div> <label for="valorAluguel">Valor Aluguel:</label> </div> 
                <div> <input id="valorAluguel" type="text" name="valorAluguel" value="<%=request.getAttribute("valorAluguelFormatado")%>"> </div>
            </div>
            <div class="box footer">
                <div>
                    <input type="reset" value="Limpar" value="Limpar"> 
                    <input type="submit" name="Alterar" value="Alterar"> 
                </div>
            </div>
        </form>
    </body> 
</html>
