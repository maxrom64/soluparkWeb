<!DOCTYPE html>
<html lang="fr">
	<head>
    	<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>SOLUPARK - Login</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
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
            <!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                        	<h1 class="fw-bolder">Se connecter</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <c:if test="${ !empty sessionScope.email} ">
       							<p>Vous êtes ${ sessionScope.email }  !</p>
    							</c:if>
                                <form method="post" action="/Solupark/Login">
                                     <!-- Entrée de l'email-->
                                     <div class="form-floating mb-3">
                                        <input class="form-control" name="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                        <label for="email">Adresse Mail</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">Un mail est obligatoire.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Mail non valide.</div>
                                    </div>
                                    <!-- EntrÃ©es des mots de passe-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="mdp" type="password" placeholder="Mot de passe" data-sb-validations="required" />
                                        <label for="mdp">Mot de passe</label>
                                    </div>
                                    <!-- Button Submit-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Connexion</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <hr>
                        <div class="text-center">
                        <a class="small" href="oublipassword.jsp">Mot de passe oublié ?</a>
                        </div>
                        <div class="text-center">
                        <a class="small" href="inscription.jsp">Créer un compte !</a>
                        </div>
                </div>
            </section>
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
