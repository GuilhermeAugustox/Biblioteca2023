<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <title>Gêneros</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
        <h1>Gêneros</h1>
            <a href="/autor/insert" class="btn btn-primary">Novo Gêneros</a>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>$nbsp;</th>
                </tr>
                <c:forEach var="item" items="${autor}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nome}</td>
                        <td>
                            <a href="/autor/update?id=${item.id}" class="btn btn-warning">Editar</a>
                            <a href="/autor/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>