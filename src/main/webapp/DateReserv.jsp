<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    	<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	    <title>Java Date Picker</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                //$("#date_debut").datepicker();
    				$( ".form1" ).datepicker({
    				showOtherMonths : true,
    				showButtonPanel : true,
    				selectOtherMonths : true,
    				changeMonth : true,
    				changeYear : true,
    				numberOfMonths : 1,
    				dateFormat: "dd/mm/yy",
    				regional: "fr",
    				showWeek: true,
    				firstDay: 1,
    				});
    			});
                $("#date_fin").datepicker();
            });
        </script>
  
</head>
  <body class="d-flex flex-column">
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
                            <li class="nav-item"><a class="nav-link" href="inscription.jsp">S'inscrire</a></li>
                            <li class="nav-item"><a class="nav-link" href="login.jsp">Se connecter</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        <Pre>
        <form action="DateReserv">
            <label for="date_debut">Entrez votre date de début de Réservation</label>
                <input type="text" name="date_debut" id="date_debut">
            <label for="date_fin">Entrez votre date de fin de Réservation</label>
                <input type="text" name="date_fin" id="date_fin">
            <p>
    		<input type="submit" value="Réservez">
  			</p>
        </form>
        </pre>

        </main>
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
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>