<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Solupark Profil</title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <img src="images/LogoSolupark.jpg" alt="logo solupark" id="logoImg" width="120" height="50"/>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                <li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
                                <li class="nav-item"><a class="nav-link" href="about.jsp">Comment ça marche</a></li>
                                <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
                                <li class="nav-item"><a class="nav-link" href="login.jsp">Se déconnecter</a></li>
                            </ul>
                        </div>
                  </div>
            </nav>            
        </main>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-black mb-2">Bienvenue sur le site d'échange de parking !</h1>
                                <p class="lead fw-normal text-black-50 mb-4">Avant tout échange vous devez mettre à disposition votre parking pour pouvoir l'échanger. Rajouter ici ce parking </p>
                                
                                <form method="post" action="/Solupark/Ajoutparking">
                                    	<input name="email" type="hidden"/>
                                        
                                
		                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
		                                    <a class="btn btn-primary btn-lg px-4 me-sm-3" href="AjoutPark.jsp">Ajouter un Parking</a>
		                        
		       							<p>Vous êtes ${ sessionScope.email }  !</p>
		    							
		                                </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXwLgKExLrciBvKknXo1Igo8P4G-a07Co&callback=initMap&libraries=&v=weekly"></script>
	
	<script>
    var map;
    function initialize() {
      var mapOptions = {
        zoom: 1,
        center: new google.maps.LatLng(48.295637, 26.6949621)
      };

      // Display a map on the page
      map = new google.maps.Map(document.getElementById('map-canvas'),mapOptions);

      // Multiple Markers
      var markers = [
            ['Kyiv, Ukraine', 50.401699,30.252508],
            ['Lviv, Ukraine', 49.8326679,23.9421957]
      ];


      // Loop through our array of markers & place each one on the map  
        for( i = 0; i < markers.length; i++ ) {
            var position = new google.maps.LatLng(markers[i][1], markers[i][2]);
            bounds.extend(position);
            marker = new google.maps.Marker({
                position: position,
                map: map,
                title: markers[i][0]
            });

            // Automatically center the map fitting all markers on the screen
            map.fitBounds(bounds);
        }

     // Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
        var boundsListener = google.maps.event.addListener((map), 'bounds_changed', function(event) {
            this.setZoom(14);
            google.maps.event.removeListener(boundsListener);
        });
    }

    google.maps.event.addDomListener(window, 'load', initialize);
    </script>
	
		</head>
	
	 <div id="map-canvas" style="height:300px; width:500px"></div> 

    <h1><c:forEach items="${nsur}" var="item" varStatus="loop">
        ${item}
        ${loop.last ? '' : ''}
    </c:forEach></h1>
    <p>${summary} <br> from ${residence}</p>

    <h2>
        <c:forEach items="${countriesCount}" var="item">
            ${item}
        </c:forEach> visited countries: 
    </h2>

    <c:forEach items="${countries}" var="item" varStatus="loop">
        ${item}
        ${loop.last ? '' : ', '}
    </c:forEach>

    <h2>
    <c:forEach items="${citiesCount}" var="item">
        ${item}
    </c:forEach> visited cities: 
        </h2>

    <c:forEach items="${cities}" var="item" varStatus="loop">
        ${item}
        ${loop.last ? '' : ', '}
    </c:forEach>

    <br/><br/><br/>
    <div id="map-canvas" style="height:300px; width:500px"></div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/scripts.js"></script>
         <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/classic.css">
    <link rel="stylesheet" href="css/classic.date.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

  <!-- Footer-->
        <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; ROMERO Maxime 2022</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="contact.jsp">Contact</a>
                    </div>
                </div>
            </div>
        </footer>

  </body>
</html>
