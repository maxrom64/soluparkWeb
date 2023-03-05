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
                                <li class="nav-item"><a class="nav-link" href="about.jsp">Comment �a marche</a></li>
                                <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
                                <li class="nav-item"><a class="nav-link" href="login.jsp">Se d�connecter</a></li>
                                <a href="<c:url value = 'ListParking'/>">
                                	<span>Lister les parkings</span>
                				</a>
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
                                <h1 class="display-5 fw-bolder text-black mb-2">Bienvenue sur le site d'�change de parking !</h1>
                                <p class="lead fw-normal text-black-50 mb-4">Avant tout �change vous devez mettre � disposition votre parking pour pouvoir l'�changer. Rajouter ici ce parking </p>
                                
                                <form method="post" action="/Solupark/Ajoutparking">
                                    	<input name="email" type="hidden"/>
                                        
                                
		                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
		                                    <a class="btn btn-primary btn-lg px-4 me-sm-3" href="AjoutPark.jsp">Ajouter un Parking</a>
		                        			<a class="btn btn-primary btn-lg px-4 me-sm-3" href="DelPark.jsp">Supprimer un Parking</a>
		       							<p>Vous �tes ${ sessionScope.email }  !</p>
		    							
		                                </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	    <script>
      var geocoder;
      var map;
      var address = "10 impasse des atriers 64140 LONS";
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: {lat: -34.397, lng: 150.644}
        });
        geocoder = new google.maps.Geocoder();
        codeAddress(geocoder, map);
      }

      function codeAddress(geocoder, map) {
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: map,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXwLgKExLrciBvKknXo1Igo8P4G-a07Co&callback=initMap&libraries=&v=weekly">
    </script>

</head>
	 	<div id="map" style="height:100%; width:100%"></div>           
      
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
