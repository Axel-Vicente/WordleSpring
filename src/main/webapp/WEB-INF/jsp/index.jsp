<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Index</title>
    <style>
        .verde {
            color: green;
        }
        .amarillo {
            color: yellow;
        }
    </style>
</head>
<body>
    <div class="container">
    <br><br>
        <form:form action="/play" method="get" modelAttribute="palabra">
            <form:input class="form-control" type="text" placeholder="Escribe la palabra... letras: ${logitudPalabra}" path="palabra" maxlength="${logitudPalabra}" minlength="${logitudPalabra}" />
            <br>
            <c:if test="${!parar}">
                <input class="btn btn-success" type="submit" value="Probar" />
                <a class="btn btn-danger" href="/reset" >Restart</a>
            </c:if>
            <c:if test="${parar}">
                <input class="btn btn-dark disabled" type="submit" value="Probar" />
                <a class="btn btn-danger" href="/reset" > Restart </a>
            </c:if>
            <div>Intentos: ${intentos}</div>
        </form:form>
        <br>
        <div>
            <span><b>Ultima palabra: </b></span>
                <c:forEach var="i" begin="${0}" end="${logitudPalabra - 1}" step="${1}">
                    <c:if test="${palabras[i].toString() == '1'}">
                        <span class="verde">${palabrasProbadas[i]}</span>
                    </c:if>
                    <c:if test="${palabras[i].toString() == '2'}">
                        <span class="amarillo">${palabrasProbadas[i]}</span>
                    </c:if>
                    <c:if test="${palabras[i].toString() != '1' && palabras[i].toString() != '2'}">
                        <span>${palabrasProbadas[i]}</span>
                    </c:if>
                </c:forEach>
            <span><b>Palabras probadas: </b> ${palabrasUsadas}</span>
        </div>
        <div>
            <span><b>Letras encontradas: </b></span>
            <c:forEach items="${letrasEncontradas}" var="letra">
                <span>${letra},</span>
            </c:forEach>
        </div>

        <c:if test="${ganador}">
            <div class="alert alert-success" role="alert">
                <h1>Ganaste enhorabuena!!!</h1>
            </div>
        </c:if>
        <c:if test="${perdedor}">
            <div class="alert alert-danger" role="alert">
                <h1>Perdiste!!!</h1>
            </div>
        </c:if>
    </div>
    </body>
</html>