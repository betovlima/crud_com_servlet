<%-- 
    Document   : CadastroVeiculo
    Created on : 28 de nov. de 2022, 11:33:10
    Author     : roberto.lima
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetoweb.model.Veiculo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Veículos</title>
    </head>
    <style>
        * {
            font-family: Arial, Helvetica, sans-serif;
        }

        .styled-table {
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
            width:100%;
            table-layout: fixed;
            overflow-wrap: break-word;
        }

        .styled-table thead tr {
            background-color: #009879;
            color: #ffffff;
            text-align: left;
        }

        .styled-table th,
        .styled-table td {
            padding: 12px 15px;
        }

        .styled-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        .styled-table tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        .styled-table tbody tr:last-of-type {
            border-bottom: 2px solid #009879;
        }

        .styled-table tbody tr.active-row {
            font-weight: bold;
            color: #009879;
        }

        h1 {
            text-align:center;
            background-color: #e7e7e7;
            color: black;
        }
    </style>
    <body>
        <h1>Listar Veículos</h1>


        <table class="styled-table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">PLACA</th>
                    <th scope="col">MODELO</th>
                    <th scope="col">MARCA</th>
                    <th scope="col">LUGARES</th>
                    <th scope="col">VALOR ALUGUEL</th>
                    <th scope="col">AÇÃO</th>
                </tr>
            </thead>
            <tbody>
                <%ArrayList<Veiculo> std
                            = (ArrayList<Veiculo>) request.getAttribute("veiculos");
                    for (Veiculo s : std) {%>
                <tr>
                    <td><%=s.getId()%></td>
                    <td><%=s.getPlaca()%></td>
                    <td><%=s.getModelo()%></td>
                    <td><%=s.getMarca()%></td>
                    <td><%=s.getLugares()%></td>
                    <td><%=s.getValorAluguelFormatado()%></td>
                    <td><a href="listarVeiculos" >Apagar</a></td>
                </tr>
                <%}%>
        </table>
    </tbody>
</table>
</body> 
</html>
