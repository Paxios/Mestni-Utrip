<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org" lang="en">

<head>
    <style>
        .vrstica tr:hover{
            cursor: pointer;
            background-color: rgba(202, 202, 202, 0.5);
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Vsi dogodki</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">
</head>

<body id="page-top">

<c:set var="user" value="${username}"/>
<c:set var="Anon" value="anonymousUser"/>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index">Mestni utrip</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <c:choose>
            <c:when test="${user == 'anonymousUser'}">
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#about">O nas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#services">Maribor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#portfolio">Lokacije</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#contact" style="color:#f05f40;">Prijava</a>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="/dodajanjeDogodka">Dodajanje dogodka</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#about">O nas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#services">Maribor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index#portfolio">Lokacije</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="/mojiDogodki">Moji dogodki</a>
                        </li>
                        <li>
                            <a onclick="document.forms['logoutForm'].submit()"><button class="btn btn-primary btn-m" type="submit" id="logout2">Logout</button></a>
                        </li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</nav>
<header class="masthead text-center text-white d-flex" >
    <div class="container my-auto">
        <div class="row">
            <div class="col-lg-10 mx-auto">
                <br><br><br>
                <h1 class="text-uppercase">
                    <strong>Aktualno</strong>
                </h1>
                <hr>
            </div>
            <div class="col-lg-8 mx-auto">
                <h4>RAZVR&Scaron;&Ccaron;ANJE:</h4>
                <form method="post">
                <input class="btn btn-primary btn-xl" type="submit" value="Po datumu" name="preveri">
                <input class="btn btn-primary btn-xl" type="submit" value="Po objektu" name="preveri">
                </form>
                <hr>
                    <c:forEach items="${akt}" var="a">
                        <h3 class="text-uppercase" onclick="document.location='/podrobnosti?id=${a.id_dogodek}'" style="cursor:pointer;  color:#f05f40;">${a.naziv}</h3>
                        <p>LOKACIJA: ${a.objekt.naziv} </p>
                        <p>DATUM: ${a.datumZacetka}</p>
                        <p>VSTOPNINA: ${a.vstopnina}&euro;</p>
                        <img src="data:image/jpeg;base64,${a.predogled}" style=" width: 100%" />
                        <hr>
                    </c:forEach>
            </div>
        </div>
    </div>
</header>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
</form>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="vendor/scrollreveal/scrollreveal.min.js"></script>
<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/creative.min.js"></script>
</body>
</html>