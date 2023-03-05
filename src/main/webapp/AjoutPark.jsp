<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>SOLUPARK - Ajout Parking</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
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
                            <li class="nav-item"><a class="nav-link" href="login.jsp">Se déconnecter</a></li>
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
                            <h1 class="fw-bolder">AJOUT D'UN PARKING</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form method="post" action="/Solupark/Ajoutparking">
                                <input name="email" type="text" value="${ sessionScope.email }"/>
                                
                                    <!-- Entrees de l'adresse -->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="address" type="text" placeholder="Adresse" maxlength="40" data-sb-validations="nom valide" />
                                        <label for="Adress">Adresse</label>
                                    </div>
                                    <!-- Entrï¿½e du code postal -->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="codePostal" type="number" placeholder="Code Postal" data-sb-validations="Code Postal" />
                                        <label for="CodePostal">Code Postal</label>
                                    </div>
                                     <!-- Entrï¿½e de la ville-->
                                     <div class="form-floating mb-3">
                                        <input class="form-control" name="ville" type="text" placeholder="Ville" data-sb-validations="Ville" />
                                        <label for="Ville">Ville</label>
                                    </div>
                                     <div class="form-floating mb-3">
                                        <input class="form-control" name="pays" type="text" placeholder="Pays" data-sb-validations="Pays" />
                                        <label for="Ville">Pays</label>
                                    </div>
                                    <!-- Entrees des dimensions-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="longueur" type="number" placeholder="Longueur" data-sb-validations="Longueur" />
                                        <label for="Longueur">Longueur du Parking (en mètre)</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="largeur" type="number" placeholder="Largeur" data-sb-validations="Largeur" />
                                        <label for="Largeur">Largeur du Parking (en mètre)</label>
                                    </div>
                                    <div class="d-none" id="submitSuccessMessage">
                                        <div class="text-center mb-3">
                                            <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                        </div>
                                    </div>
                                    <!-- Bouton Submit-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Ajouter un Parking</button></div>
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
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>