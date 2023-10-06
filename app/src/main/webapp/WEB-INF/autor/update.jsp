<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Autor</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editar Gênero</h1>
            <form action="/autor/update" method="post">
                <input type="hidden" name="id" value="${autorid}" />
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" class="form-control" value="$autor.nome" />
                </div>
                <br />
                <a href="/autor/list" class="btn btn-primary">Voltar</a>
                <button type="submit" class="btn btn-sucess">Salvar</button>
            </form>
        </div>
    </body>
</html>