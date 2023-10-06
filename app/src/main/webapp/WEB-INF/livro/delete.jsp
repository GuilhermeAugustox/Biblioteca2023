<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Remover Gênero</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Remover Livro</h1>
            <p>Tem certeza que deseja remover o livro "${livro.nome}" ?</p>
            <form action="/livro/delete" method="post">
                <input type="hidden" name="id" value="${livro.id}"/>
                <br />
                <a href="/livro/list" class="btn btn-primary">Voltar</a>
                <button type="submit" class="btn btn-danger">Excluir</button>
            </form>
        </div>
    </body>
</html>