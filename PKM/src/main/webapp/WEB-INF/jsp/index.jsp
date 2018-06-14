<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Mestni utrip</title>

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

<header class="masthead text-center text-white d-flex">
  <div class="container my-auto">
    <div class="row">
      <div class="col-lg-10 mx-auto">
        <h1 class="text-uppercase">
          <strong>Mestni utrip</strong><br>
              DOGODKI V MESTU MARIBOR
          </h1>
        <hr>
      </div>
      <div class="col-lg-8 mx-auto">
        <p class="text-faded mb-5">
          Pobuda za nastanek spletne strani je pro&scaron;nja Mestne Ob&ccaron;ine Maribor. Od nekdaj smo
          si prizadevali za olaj&scaron;anje pregleda nad dogajanjem in s to mislijo je nastala spletna
          stran Mestni utrip. Sicer bi &zcaron;eleli, da bi se v na&scaron;em mestu dogajalo ve&ccaron;, pa
          vendarle so tukaj zbrane vse pomembnej&scaron;e informacije o ve&ccaron;jih, pa tudi manj&scaron;ih
          dogodkih v prestolnici na&scaron;e &Scaron;tajerske.
        </p>
        <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Zanima me ve&ccaron;</a>
      </div>
    </div>
  </div>
</header>

<section class="bg-primary" id="about">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 mx-auto text-center">
        <h2 class="section-heading text-white">O nas</h2>
        <hr class="light my-4">
        <p class="text-faded mb-4">
          Primo&zcaron; Stopar<br>
          Aljo&scaron;a Siko&scaron;ek<br>
          Nejc Vnuk<br>
          Uro&scaron; Zagoranski<br>
        </p>
        <p class="text-faded mb-4">
          Smo &scaron;tudentje 1. letnika FERI MB. V leto&scaron;njem letu smo se
          nau&ccaron;ili veliko o programiranju, dobrih praksah ter &zcaron;eljah uporabnikov spletnih re&scaron;itev.
          &Ccaron;e se &zcaron;elite spustiti v prijetno popotovanje skozi
          no&ccaron;no in manj no&ccaron;no dogajanje v 2. najve&ccaron;jem mestu v Sloveniji, kliknite gumb spodaj.</p>
        <a class="btn btn-light btn-xl js-scroll-trigger" href="#services">Za&ccaron;nimo z ogledom Maribora</a>
      </div>
    </div>
  </div>
</section>

<section id="services">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h2 class="section-heading">Maribor</h2>
        <hr class="my-4">
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <a href ="http://www.maribor.si/"><i class="fa fa-4x fa-diamond text-primary mb-3 sr-icons"></i></a>
          <h3 class="mb-3">Biser &Scaron;tajerske</h3>
          <p class="text-muted mb-0">Uradna spletna stran Mestne ob&ccaron;ine Maribor.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <a href="http://www.maribor-airport.si/"><i class="fa fa-4x fa-paper-plane text-primary mb-3 sr-icons"></i></a>
          <h3 class="mb-3">Pristanek v Mariboru</h3>
          <p class="text-muted mb-0">Aerodrom Maribor v Orehovi Vasi je pravi naslov za polet.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <a href="https://maribor-pohorje.si"><i class="fa fa-4x fa-newspaper-o text-primary mb-3 sr-icons"></i></a>
          <h3 class="mb-3">Turisti&ccaron;na zakladnica</h3>
          <p class="text-muted mb-0">Za turiste, ki jih zanima ve&ccaron;.</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-6 text-center">
        <div class="service-box mt-5 mx-auto">
          <a href="http://www.nkmaribor.com/"><i class="fa fa-4x fa-heart text-primary mb-3 sr-icons"></i></a>
          <h3 class="mb-3">En klub, ena &ccaron;ast</h3>
          <p class="text-muted mb-0">Na&scaron;e srce je vedno vijol'&ccaron;no!</p>
        </div>
      </div>
    </div>
    <div class="col-lg-8 mx-auto text-center">
      <br><br>
      <a class="btn btn-primary btn-xl js-scroll-trigger" href="#portfolio">Na dogodke</a>
    </div>
  </div>
</section>

<section class="p-0" id="portfolio">
  <div class="container-fluid p-0">
    <div class="row no-gutters">
      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box" href="restavracije">
          <img class="img-fluid" src="img/portfolio/thumbnails/1.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                Restavracije
              </div>
              <div class="project-name">
                Dogodki, povezani s kulinariko.
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box" href="klubi">
          <img class="img-fluid" src="img/portfolio/thumbnails/2.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                Klubi
              </div>
              <div class="project-name">
                Zabave od ve&ccaron;era do jutranjih ur.
              </div>
            </div>
          </div>
        </a>
      </div>

      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box" href="sport">
          <img class="img-fluid" src="img/portfolio/thumbnails/3.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                &Scaron;port
              </div>
              <div class="project-name">
                Dogodki, povezani s &scaron;portom.
              </div>
            </div>
          </div>
        </a>
      </div>

      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box " href="narava">
          <img class="img-fluid" src="img/portfolio/thumbnails/4.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                Narava
              </div>
              <div class="project-name">
                Na zabavo v naravo.
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box" href="kultura">
          <img class="img-fluid" src="img/portfolio/thumbnails/5.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                Kultura
              </div>
              <div class="project-name">
                Od opere pa vse do Davidovega kipa.
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="col-lg-4 col-sm-6">
        <a class="portfolio-box" href="aktualno">
          <img class="img-fluid" src="img/portfolio/thumbnails/6.jpg" alt="">
          <div class="portfolio-box-caption">
            <div class="portfolio-box-caption-content">
              <div class="project-category text-faded">
                AKTUALNO
              </div>
              <div class="project-name">
                Seznam aktualnih dogodkov.
              </div>
            </div>
          </div>
        </a>
      </div>
    </div>
    <div class="col-lg-8 mx-auto text-center">
      <br>
      <a class="btn btn-primary btn-xl js-scroll-trigger" href="#contact">Na prijavo</a>
    </div>
  </div>
</section>

<c:choose>
<c:when test="${user == 'anonymousUser'}">
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto text-center">
                <h2 class="section-heading">Prijava in registracija</h2>
                <hr class="my-4">
                <p class="mb-5">Za urejanje dogodkov in lokacij se morate v sistem prijaviti.
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 ml-auto text-center">
                <hr>
                <h3>Registracija</h3><br>
                <a href="registracija"><i class="fa fa-sign-in fa-3x mb-3"></i></a>
            </div>
            <div class="col-lg-4 ml-auto text-center">
                <form method="POST" action="${contextPath}/index#log" class="form-signin" id="log">
                    <hr>
                    <h3 class="form-heading">Prijava v sistem</h3><br>
                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${msg}</span>
                        <input name="username" type="text" class="form-control" placeholder="Uporabni&scaron;ko ime"/><br>
                        <input name="password" type="password" class="form-control" placeholder="Geslo"/>
                        <span>${errorMsg}</span><br>
                        <button class="btn btn-primary btn-xl" type="submit">Prijava</button>
                    </div>
                </form>
            </div>
            </c:when>


            <c:otherwise>
            <section id="contact">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto text-center">
                            <hr>
                            <h2 class="section-heading">Odjava</h2>
                            <hr class="my-4">
                            <p class="mb-5">Prijavljeni ste kot ${username}.
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 ml-auto text-center">
                            <hr>
                            <h3>Registracija</h3><br>
                            <a href="registracija"><i class="fa fa-sign-in fa-3x mb-3"></i></a>
                        </div>
                        <div class="col-lg-4 ml-auto text-center">
                            <a onclick="document.forms['logoutForm'].submit()"><button class="btn btn-primary btn-xl" type="submit" id="logout">Logout</button></a>
                            </h3></u>
                            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            </form>
                        </div>
                        </c:otherwise>
                        </c:choose>

                        <div class="col-lg-4 mr-auto text-center">
                            <hr>
                            <h3>Kontakt</h3><br>
                            <a href="mailto:mestniutripmaribor@gmail.com"><i class="fa fa-envelope-o fa-3x mb-3 sr-contact"></i></a>
                        </div>
                    </div>
                </div>
            </section>
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