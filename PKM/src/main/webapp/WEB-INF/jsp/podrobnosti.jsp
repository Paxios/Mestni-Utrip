<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Podrobnosti dogodka</title>

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

    <style>
        * {box-sizing: border-box}
        body {font-family: Verdana, sans-serif; margin:0}
        .mySlides {display: none}
        img {vertical-align: middle;}

        /* Slideshow container */
        .slideshow-container {
            max-width: 1000px;
            position: relative;
            margin: auto;
        }

        /* Next & previous buttons */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
        }

        /* Position the "next button" to the right */
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover, .next:hover {
            background-color: rgba(0,0,0,0.8);
        }

        /* Fading animation */
        .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 1.5s;
            animation-name: fade;
            animation-duration: 1.5s;
        }

        @-webkit-keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        @keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {
            .prev, .next,.text {font-size: 11px}
        }

        input {
            font-size: 2.4em;
            background-color: transparent;
            text-align: center;
            border-width: 0;
            width: 100%;
            margin: 0 0 .1em 0;
            color: #fff;
        }

        label {
            display: block;
            font-size: .8em;
        }

        button {
            /* basics */
            color: #444;
            background-color: #B5B198;
            /* rounded corners */
            -webkit-border-radius: 6px;
            border-radius: 6px;
            -moz-background-clip: padding; -webkit-background-clip: padding-box; background-clip: padding-box;
            font-weight: bold;

        }

        button:hover, button:active, button:focus {
            background-color: #CBC7AE;
        }

        .box {
            /* basics */
            background-color: #444;
            color: #C4BE92;
            text-align: center;

            /* rounded corners */
            -webkit-border-radius: 12px;
            border-radius: 12px;
            -moz-background-clip: padding; -webkit-background-clip: padding-box; background-clip: padding-box;
            padding: .8em .8em 1em;
            width: 8em;
            margin: 0 auto;
            -webkit-box-shadow: 0px 0px 12px 0px #000;
            box-shadow: 0px 0px 12px 0px #000;

        }
    </style>
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
                            <a class="nav-link js-scroll-trigger" href="#about">O nas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#services">Maribor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#portfolio">Lokacije</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#contact">Prijava</a>
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
                            <a class="nav-link js-scroll-trigger" href="#about">O nas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#services">Maribor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#portfolio">Lokacije</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#contact">Prijava</a>
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
            <p class="col-lg-8 mx-auto">
            <p class="text-faded mb-5">
                <div class="container">
                    <c:forEach items="${pod}" var="a"><br>
                    <h1 class="text-uppercase"> ${a.naziv}</h1>
                    <div class="row">
                        <div class="col-sm">
                            <hr>
                            <h4>OPIS:</h4>
            <p style="color:#9c9c9c"> ${a.opis}</p>
            <hr>
        </div>
        <div class="col-sm">
            <hr>
            <h4>LOKACIJA:</h4>  <p style="color:#9c9c9c" class="text-uppercase"> ${a.objekt.naziv}</p>
            <h4>DATUM:</h4> <p style="color:#9c9c9c"> ${a.datumZacetka} - ${a.datumKonca}</p>
            <h4>VSTOPNINA:</h4> <p style="color:#9c9c9c"> ${a.vstopnina}&euro;</p>
            <h4>KAPACITETA:</h4> <p style="color:#9c9c9c"> ${a.kapaciteta} ljudi</p>
            <hr>
        </div>


        <div class="col-sm">
            <hr>
            <h4>ZANIMANJE ZA DOGODEK </h4><br>
            <div class="box">
                <label for="qty"><abbr title="Aktivne prijave">&Scaron;tevilo ljudi, ki jih dogodek zanima:</abbr></label>
                <input id="qty" value="0" />
                <button id="up" onclick="modify_qty(1)">Zanima me</button>
            </div>
            <hr>
        </div>
    </div>
    </c:forEach>

    <c:if test="${!(empty sli)}">
        <div class="slider-pro" id="my-slider" style="margin-top: 30px">
            <div class="sp-slides">
                <c:forEach  items="${sli}" var ="slika">
                    <div class="sp-slide">
                        <img src="data:image/jpeg;base64,${slika.URLSlike}" style=" width: 100%" />
                    </div>
                </c:forEach>
            </div>
            <div class="sp-thumbnails">
                <c:forEach  items="${sli}" var ="slika">
                    <img class="sp-thumbnail" src="data:image/jpeg;base64,${slika.URLSlike}" />
                </c:forEach>
            </div>
        </div>
    </c:if>
    <c:if test="${empty sli}">
        <div class="col-12">
            <div class="search-field">
                <div class="row">
                    <div class="col-3">
                    </div>
                    <div class="col-6 text-center">
                        <p style="margin-bottom:0px; font-weight:bold;">Ni slik za prikaz.</p>
                    </div>
                    <div class="col-3">
                    </div>
                </div>
            </div>
            <br/>
        </div>
    </c:if>
    <%--<div class="slideshow-container">--%>
    <%--<div>--%>
    <%--<hr>--%>
    <%--<h3>GALERIJA SLIK:</h3>--%>
    <%--<c:forEach items="${sli}" var="a">--%>
    <%--<div>--%>
    <%--<img src="data:image/jpeg;base64,${sli.URLSlike}" style="width:100%">--%>
    <%--</div>--%>
    <%--</c:forEach>--%>
    <%--<hr>--%>
    <%--</div>--%>
    <%--</div>--%>
    <hr>
    <!-- begin wwww.htmlcommentbox.com -->
    <div class="container-fluid" id="HCB_comment_box"><a href="http://www.htmlcommentbox.com">Comment Box</a> is loading comments...</div>
    <link rel="stylesheet" type="text/css" href="//www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
    <script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=hcb_user.PAGE || (""+window.location).replace(/'/g,"%27"), h="//www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&mod=%241%24wq1rdBcg%24eYnUNqb5W8RlX.n%2F0pBwi0"+"&opts=16862&num=10&ts=1528193098550");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>
    <!-- end www.htmlcommentbox.com -->
    <hr>
    </div>
    </div>
    </div>
</header>
<%--javascript za galerijo slik--%>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
    }
</script>
<%--javascript za komentarje--%>
<script>
    hcb_user = {
        /* L10N */
        comments_header : 'Komentarji',
        name_label : 'Ime',
        content_label: 'Vnesite svoj komentar',
        submit : 'Komentiraj',
        no_comments_msg: 'Trenutno ni nobenega komentarja. Bodite prvi, ki bo napisal svoje mnenje!',
        add:'Dodaj svoj komentar',
        again: 'Dodaj nov komentar',
        said:'Je objavil:',
        prev_page:'<img src="//www.htmlcommentbox.com/static/images/arrow_left.png" class="hcb-icon" title="prejsnja stran" alt="[prev]"/>',
        next_page:'<img src="//www.htmlcommentbox.com/static/images/arrow_right.png" class="hcb-icon" title="naslednja stran" alt="[next]"/>',
        showing:'Prikazujemo',
        to:'za',
        website_label:'website (optional)',
        email_label:'email',
        anonymous:'Anonimni uporabnik',
        subscribe:'Prijavljam se na obvestila',
        are_you_sure:'Je ta komentar neprimeren?',

        reply:'<img src="//www.htmlcommentbox.com/static/images/reply.png"/> odgovor',
        flag:'<img src="//www.htmlcommentbox.com/static/images/flag.png"/> zastavica',
        like:'<img src="//www.htmlcommentbox.com/static/images/like.png"/> v&scaron;e&ccaron;ek',

        /* dates */
        days_ago:'dni nazaj',
        hours_ago:'ur nazaj',
        minutes_ago:'minut nazaj',
        within_the_last_minute:'v zadnji minuti',

        msg_thankyou:'Hvala za komentar!',
        msg_approval:'(komentar ne bo objavljen, dokler to ne bo dovoljeno)',
        msg_approval_required:'Hvala za komentar! Objavljen bo, ko bo ga odobril administrator.',

        err_bad_html:'Objavili ste komentar z nepravilnim html-jem.',
        err_bad_email:'Vnesite veljaven email.',
        err_too_frequent:'Komentirate lahko 1x na minuto',
        err_comment_empty:'Prazen komentar! S tem si ne moremo pomagati',
        err_denied:'Komentar ni bil sprejet.',

        /* SETTINGS */
        MAX_CHARS: 8192,
        PAGE:'', /* ID of the webpage to show comments for. defaults to the webpage the user is currently visiting. */
        ON_COMMENT: function(){}, /* Function to call after commenting. */
        RELATIVE_DATES:true /* show dates in the form "X hours ago." etc. */
    };
</script>
<%--javascript za pregled zanimanja za dogodek--%>
<script>
    function modify_qty(val) {
        var qty = document.getElementById('qty').value;
        var new_qty = parseInt(qty,10) + val;

        if (new_qty < 0) {
            new_qty = 0;
        }

        document.getElementById('qty').value = new_qty;
        return new_qty;
    }
</script>


<script>
    $(document).ready(function (){
        $("#my-slider").sliderPro({
            width: 800,
            height:400,
            orientation: 'vertical',
            thumbnailsPosition: 'right',
            buttons: false,
            thumbnailArrows: true,
            thumbnailPointer: true,
            autoplay: false
        });
    });
</script>
</body>
</html>