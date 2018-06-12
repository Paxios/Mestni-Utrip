<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Registracija</title>

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
</head>

<body id="page-top">
<c:set var="user" value="${username}"/>
<c:set var="Anon" value="anonymousUser"/>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index#page-top">Mestni utrip</a>
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
                            <a class="nav-link js-scroll-trigger" href="index#contact"><button class="btn btn-primary btn-m" type="submit">Prijava</button></a>
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

<header class="masthead text-center text-white d-flex">
    <div class="container my-auto">
        <div class="row">
            <div class="col-lg-10 mx-auto">
                <br><br><br>
                <h1 class="text-uppercase">
                    <strong>Registracija podjetja</strong>
                </h1>
                <hr>
            </div>
            <div class="col-lg-8 mx-auto">
                <section class="p-0" id="portfolio">
                    <div class="container-fluid">
                        <form method="post" action ="registracija">
                            <p><i>Polja, ozna&ccaron;ena z * so obvezna!</i></p>
                            <p id="manjkajoPodatki"></p>
                            <%--<select class="form-control" placeholder="*Podjetje" name=imeP >--%>
                            <%--<option value="Izberite Podjetje">Izberite Podjetje</option>--%>
                            <%--&lt;%&ndash;<c:forEach items="${objekti}" var="objektii">                    NEUPORABNO&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<option value="${objektii.naziv}">${objektii.naziv}</option>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                            <%--</select>--%>
                            <%--<br/>--%>
                            <p><input class="form-control" type="text" placeholder="*Podjetje" name=imeP></p>
                            <p><select class="form-control" name=tip_Podjetja>
                                <option value="tipObjekta">*Izberite tip objekta</option>
                                <c:forEach items="${tip_objekta}" var="tip_objekta">
                                    <option value="${tip_objekta}">${tip_objekta}</option>
                                </c:forEach>
                            </select></p>

                            <span><input type="radio" name="izbira" class="radio" id="prviRadio" checked="checked" >&Zcaron;elim dodati naslov</span><br />
                            <span><input type="radio" name="izbira" class="radio" id="drugiRadio">&Zcaron;elim dodati geografsko dol&zcaron;ino in &scaron;irino</span>
                            <p><input class="form-control" type="number" step="any" placeholder="*Geografska do&zcaron;ina" name="dolzina" id="dolzina"></p>
                            <p><input class="form-control" type="number" step="any" placeholder="*Geografska &scaron;irina" name="sirina" id="sirina"> </p>
                            <p><input class="form-control" type="text" placeholder="*Naslov" name=naslov id="naslov"></p>
                            <p><input class="form-control" type="text" placeholder="*Email" name=mail></p>
                            <p id="napakaE"></p>
                            <p><input class="form-control" type="password" placeholder="*Geslo" name=geslo></p>
                            <p id="napakaG"></p>
                            <p><input class="form-control" type="password" placeholder="*Ponovi geslo" name=istogeslo></p>
                            <p><input class="form-control" type="text" placeholder="Kontaktna oseba" name=lastnik></p>
                            <p><input type="submit" value="Potrdi" class="btn btn-primary btn-xl js-scroll-trigger" onclick="return preveriVnos()"></p>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </div>
</header>
<script>
    var prvi = $("#prviRadio");
    var dolzina =$("#dolzina");
    dolzina.val(0);
    var sirina =$("#sirina");
    sirina.val(0);
    var naslov=$("#naslov");

    dolzina.hide();
    sirina.hide();
    $('input:radio').change(function () {


        if(prvi.is(':checked')){
            dolzina.hide();
            dolzina.val(0);
            sirina.hide();
            sirina.val(0);
            naslov.show();
        }else{
            dolzina.show();
            dolzina.val("");
            sirina.show();
            sirina.val("");
            naslov.hide();
            naslov.val("");

        }
    })
    $('input:radio').change(function () {

        if(prvi.is(':checked')){
            dolzina.hide();
            dolzina.val(0);
            sirina.hide();
            sirina.val(0);
            naslov.show();
        }else{
            dolzina.show();
            dolzina.val("");
            sirina.show();
            sirina.val("");
            naslov.hide();
            naslov.val("");
        }
    })
    function preveriVnos(){
        var naslov = $("[name='naslov']");
        var imeP = $("[name='imeP']");
        var geslo = $("[name='geslo']");
        var istogeslo = $("[name='istogeslo']");
        var email = $("[name='mail']");
        var tip_podjetja=$("[name='tip_Podjetja']")
        var napakaG = $("#napakaG");
        var napakaE = $("#napakaE");
        var manjkajoPodatki = $("#manjkajoPodatki");
        email.css('background-color', 'white');
        manjkajoPodatki.html("");
        geslo.css('background-color', 'white');
        istogeslo.css('background-color', 'white');
        napakaE.html("");
        napakaG.html("");

        if(tip_podjetja.val()=="tipObjekta"||imeP.val()==""||geslo.val()==""||istogeslo.val()==""||email.val()==""||(naslov.val()==""&&(dolzina.val()==""||sirina.val()==""))){
            manjkajoPodatki.html("Vnesite vse obvezne podatke.");
            manjkajoPodatki.css("color","#ffa8a5");
            return false;
        }

        else
        if((email.val().indexOf("@")<0)){
            napakaE.html("Vnesite pravilen mail!");
            email.css('background-color', '#ffa8a5');

            manjkajoPodatki.html("");
            return false
        }
        else if((email.val().indexOf(".")<0)){
            napakaE.html("Vnesite pravilen mail!");
            email.css('background-color', '#ffa8a5');

            manjkajoPodatki.html("");
            return false
        }
        else if(!(geslo.val() == istogeslo.val())){
            napakaG.html("Gesli se ne ujemata!");
            geslo.css('background-color', '#ffa8a5');
            istogeslo.css('background-color', '#ffa8a5');
            return false;

        }else return true;
    }


</script>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
</form>
</body>
</html>