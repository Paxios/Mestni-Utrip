<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

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
</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index">Mestni utrip</a>
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
                <h1 class="text-uppercase">
                    <strong>Registracija podjetja</strong>
                </h1>
                <hr>
            </div>
            <div class="col-lg-8 mx-auto">
                <section class="p-0" id="portfolio">
                    <div class="container-fluid">
                        <form method="post" action ="registracija">
                            <p><input class="form-control" type="text" placeholder="Ime podjetja" name=imeP></p>
                            <p><input class="form-control" type="text" placeholder="Ime" name=ime></p>
                            <p><input class="form-control" type="text" placeholder="Priimek" name=priimek></p>
                            <p><input class="form-control" type="text" placeholder="Email" name=mail></p>
                            <p><input class="form-control" type="password" placeholder="Geslo" name=geslo></p>
                            <p><input class="form-control" type="password" placeholder="Ponovi geslo" name=istogeslo></p>
                            <p><input type="submit" class="btn btn-primary btn-xl js-scroll-trigger" value="Potrdi"></p>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </div>
</header>

</body>
</html>