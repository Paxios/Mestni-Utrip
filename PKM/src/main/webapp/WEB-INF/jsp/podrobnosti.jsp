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
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <style>
        * {box-sizing:border-box}

        /* Slideshow container */
        .slideshow-container {
            max-width: 1000px;
            position: relative;
            margin: auto;
        }

        /* Hide the images by default */
        .mySlides {
            display: none;
        }

        /* Next & previous buttons */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 250px;
            width: auto;
            margin-top: -22px;
            padding: 16px;
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

        .prev {
            left: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover, .next:hover {
            background-color: rgba(0,0,0,0.8);
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
            <h4>LOKACIJA:</h4>  <p style="color:#9c9c9c" class="text-uppercase" id="naziv"> ${a.objekt.naziv}</p>
            <h4>DATUM:</h4> <p style="color:#9c9c9c"> ${a.datumZacetka} - ${a.datumKonca}</p>
            <h4>VSTOPNINA:</h4> <p style="color:#9c9c9c"> ${a.vstopnina}&euro;</p>
            <h4>KAPACITETA:</h4> <p style="color:#9c9c9c"> ${a.kapaciteta} ljudi</p>
            <hr>
        </div>
        <div class="col-sm">
            <hr>
            <h4>ZANIMANJE ZA DOGODEK </h4><br>
            <div class="box">
                <p style="color:#9c9c9c" class="text-uppercase" id="like">${a.lajk}</p><br>
            </div>
            <button class="btn btn.primary btn-m" onclick="lajk()">Like</button>
            <hr>
        </div>
        </c:forEach>
    </div>
    <%-- Google maps --%>
    <div class="col-lg-12 mx-auto text-dark">
        <h2 class="text-white">ZEMLJEVIDI</h2>
        <hr>
        <div id="map" style="width:100%;height:400px;"></div>
        <c:forEach items="${opis}" var="opis">
            <input type="hidden" id="naslov" name="lokacija"  value="${opis}">
        </c:forEach>
        <%--</c:forEach>
        <c:forEach items="${z_sirina}" var="l">
            <input type="hidden" id="lat" value="${l.Z_sirina}">
        </c:forEach>
        <c:forEach items="${z_dolzina}" var="l">
            <input type="hidden" id="lat" value="${l.Z_dolzina}">
        </c:forEach> --%>

        <%--<c:forEach items="${Z_sirina}" var="l">
        <<input type="hidden" id="latitude" value="${l.lat}">
        </c:forEach>--%>
    </div>
    <%-- konec zemljevidov --%>
    <hr>

    <div>
        <h4> GALERIJA SLIK:</h4>
        <!-- Slideshow container -->
        <div class="slideshow-container">
            <c:forEach  items="${sli}" var ="slika">
                <!-- Full-width images with number and caption text -->
                <div class="mySlides">
                    <img src="data:image/jpeg;base64,${slika.URLSlike}" style=" width: 100%" />
                </div>
            </c:forEach>

            <!-- Next and previous buttons -->
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
        </div>
        <br>

        <div>
            <hr>
            <!-- begin wwww.htmlcommentbox.com -->
            <div class="container-fluid" id="HCB_comment_box"><a href="http://www.htmlcommentbox.com">Comment Box</a> is loading comments...</div>
            <link rel="stylesheet" type="text/css" href="//www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
            <script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=hcb_user.PAGE || (""+window.location).replace(/'/g,"%27"), h="//www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&mod=%241%24wq1rdBcg%24eYnUNqb5W8RlX.n%2F0pBwi0"+"&opts=16862&num=10&ts=1528193098550");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>
            <!-- end www.htmlcommentbox.com -->
            <hr>
        </div>
    </div>
</header>
<%--javascript za galerijo slik--%>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    // Next/previous controls
    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    // Thumbnail image controls
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
        comments_header : 'KOMENTARJI',
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
    function lajk() {

        var like = document.getElementById("like").value;
        like.innerHTML = like++;
    }

</script>
<script>
    function myMap() {
        //var lat = document.getElementById("latitude").value;
        //alert (lat);
        var lokacija= document.getElementById("naslov").value;
        var naslov = document.getElementById("naziv").innerHTML;
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center: new google.maps.LatLng(46.5541067, 15.6456613),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });
        var marker;
        var geocoder = new google.maps.Geocoder();
        var infowindow = new google.maps.InfoWindow({
            content:  naslov + "<br>" + lokacija
        });
        geocoder.geocode({'address': lokacija}, function (results, status) {
            if (status === 'OK') {
                center: results[0].geometry.location,
                    marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                marker.addListener('click', function() {
                    infowindow.open(map, marker);
                    map.setZoom(15);
                    map.setCenter(marker.getPosition());
                });
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }

</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB1SQXaPVqPhXb-QL0via91d49xtzrql0o
&callback=myMap"></script>
<%--<script>--%>
<%--$(document).ready(function (){--%>
<%--$("#my-slider").sliderPro({--%>
<%--width: 800,--%>
<%--height:400,--%>
<%--orientation: 'vertical',--%>
<%--thumbnailsPosition: 'right',--%>
<%--buttons: false,--%>
<%--thumbnailArrows: true,--%>
<%--thumbnailPointer: true,--%>
<%--autoplay: false--%>
<%--});--%>
<%--});--%>
<%--</script>--%>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
</form>
</body>
</html>