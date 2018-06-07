<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Urejanje dogodka</title>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/index">Mestni utrip</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
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
                    <a class="nav-link js-scroll-trigger" href="index#contact">Prijava</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead text-center text-white d-flex">
    <div class="container my-auto">
        <div class="row">
            <div class="col-lg-10 mx-auto">
                <br><br><br>
                <h1 class="text-uppercase">
                    <strong>Urejanje dogodka</strong><br />
                    <strong>${objekt}</strong>
                </h1>
                <hr>
            </div>
            <div class="col-lg-8 mx-auto">
                <section class="p-0" id="portfolio">
                    <div class="container-fluid">
                        <form method="post" action ="urejanjeDogodka" enctype="multipart/form-data">
                            <c:forEach items="${dogodek}" var='a'>

                            <p id="manjkajoPodatki"></p>
                                <input type="text" value="${a.naziv}" name=naziv hidden />
                            <p><input class="form-control" type="text" placeholder="Naziv dogodka" value="${a.naziv}" name=novNaziv></p>
                            <p><input class="form-control" type="number" step="any" placeholder="Vstopnina (eur)" value="${a.vstopnina}" name=vstopnina></p>
                            <p><input class="form-control" type="number" placeholder="&Scaron;tevilo mest" value="${a.kapaciteta}" name="kapaciteta"></p>

                                <select class="form-control" name="tip" id="tip">

                                <option value="*Izberite tip dogodka">*Izberite tip dogodka</option>
                                <%--ZAKAJ TO NE DELA--%>
                                <c:forEach items="${tip_dogodka}" var="tip_dogodka">
                                   <c:choose>
                                       <c:when test= "${tip_dogodka eq izbranTip}">
                                           <option value="${tip_dogodka}" selected>${tip_dogodka}</option>
                                       </c:when>
                                       <c:otherwise>
                                           <option value="${tip_dogodka}" class="option">${tip_dogodka}</option>
                                       </c:otherwise>
                                   </c:choose>

                                </c:forEach>
                                    <input type="text" value="${izbranTip}" id="izbran" hidden>
                            </select><br />
                            <p><textarea class="form-control" type="textarea" rows="3" placeholder="Opis" name=opis>${a.opis}</textarea></p>
                            <input class="form-control" type="hidden" value="${objekt}"  name=imeObjekta>
                                <c:set var ="datZ" scope ="session" value="${datumZacetka}" />
                            <p class="text-left">Datum za&ccaron;etka: <input class="form-control" type="date" value="${datZ}" name=datumZacetka></p>
                            <p class="text-left">Ura za&ccaron;etka: <input class="form-control" type="time"  value="${uraZacetka}" name="uraZacetka"></p>
                            <p class="text-left">Datum konca: <input class="form-control" type="date" value="${datumKonca}"  name=datumKonca></p>
                            <p class="text-left">Ura konca: <input class="form-control" type="time"  value="${uraKonca}" name=uraKonca></p>
                            <p class="text-left">Dodaj fotografije: <input type="file" class="form-control" value="Dodaj slike" name=slike" multiple></p>
                            <p><input type="submit" value="Potrdi" class="btn btn-primary btn-xl js-scroll-trigger"></p>
                            </c:forEach>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </div>
</header>
</body>
</html>