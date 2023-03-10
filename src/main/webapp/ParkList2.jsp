<%@page import= "java.util.List" %>
<%

String date_fin   	= (String) request.getAttribute("date_fin");
String date_debut 	= (String) request.getAttribute("date_debut");
String longueurTexte   	= (String) request.getAttribute("longueur");
if (longueurTexte == null) { longueurTexte = "";};
String largeurTexte   	= (String) request.getAttribute("largeur");
if (largeurTexte == null) { largeurTexte = "";};
List<String> list_map_address 	= (List<String>) request.getAttribute("list_address");

%>
<!DOCTYPE html>
<html lang="fr">
	<head>
    	<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>SOLUPARK - Affichage Filtres Parking</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
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
		<br> 
		<table align="center" width="60%" >
			<tr>	
		        <form action="ListParking">
		        	<th>
		            <label for="longueur">Entrez la longueur du parking (en m)</label>
		            </th>
		            <th>
		                <input class="form-control" type="text" name="longueur" id="longueur" value="<%=longueurTexte%>">
		            </th>
		            <th>
		            </th>
		            <th>
		            </th>
		            <th>
		            <input class="btn btn-primary" type="submit" value="Rechercher">
		            </th>
		  		</form>
		  	</tr>
		  	<tr>
		  		<form action="ListParking">
		        	<th>
		            <label for="largeur">Entrez la largeur du parking (en m)</label>
		            </th>
		            <th>
		                <input class="form-control" type="text" name="largeur" id="largeur" value="<%=largeurTexte%>">
		           </th>
		           <th>
		            </th>
		            <th>
		            </th>
		           <th>
		           <input class="btn btn-primary" type="submit" value="Rechercher">
		  			</th>
		  		</form>
		     </tr>
		  	<tr>
		  		 <form action="ListParking">
		  		 <th>
		            <label for="date_debut">Date de début de disponibilité</label>
		         </th>
		         <th>
		                <input type="date" name="date_debut" id="date_debut" value="<%=date_debut%>">
		          </th>
		          <th>
		            <label for="date_fin">Date de fin de disponibilité</label>
		          </th>
		          <th>
		                <input type="date" name="date_fin" id="date_fin" value="<%=date_fin%>">
		          </th>
		          <th>
		            <input class="btn btn-primary" type="submit" value="Rechercher">
		  		 </th>
		  		 </form>
  		 	</tr>
  		 </table>
	<br>
             <%
             List<String> parkings = (List<String>) request.getAttribute("parkings");
        	%> 
 			<table align="center" class="table table-hover" style="width:80%;" >
		<thead> 
			<tr>
			<th>Adresse</th>
			<th>Code Postal</th>
			<th>Ville</th>
			<th>Pays</th>
			<th>Longueur</th>
			<th>Largeur</th>
			<th>Date debut</th>
			<th>Date fin</th>
			<th>Action</th>
			</tr>
		</thead>
			<%  
			for (int i = 0; i< parkings.size ()/8; ++i) {
				String id_proprietaire = parkings.get(0 + (i*8));
				String id_parking=parkings.get(1 + (i*8));
				String address=parkings.get(2 + (i*8));
				String codePostal=parkings.get(3 + (i*8));
				String ville=parkings.get(4 + (i*8));
				String pays=parkings.get(5 + (i*8));
				String longueur=parkings.get(6 + (i*8));
				String largeur=parkings.get(7 + (i*8));
			%>
		<tbody>	
		<tr>
			<td><%=address %></td>
			<td><%=codePostal %></td>
			<td><%=ville %></td>
			<td><%=pays %></td>
			<td><%=longueur %></td>
			<td><%=largeur %></td>
			<td>
					<form method="post" action="DateReserv">
		        	    <input class="form-control" type="date" name="date_debut" id="date_debut">     
		 	</td>
		 	<td>
					 <input class="form-control" type="date" name="date_fin" id="date_fin">   
		 	</td>
       	 	<td>
       	 		  	    <input type="hidden" name="park_id" id="park_id" value="<%=id_parking %>">
		            <p>
		    			<input class="btn btn-primary" type="submit" value="Réservez">
		  			</p>
		        	</form>
       	 </td>			
		</tr>
			<% } 
			%>
		</tbody>
	</table>
	<br>
	<div class="row justify-content-center">
		<div class="col-md-8 row justify-content-center">
			<div id="map" class="map-responsive"></div>
		</div>
	</div>
	</main>
	<br><br>
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
     <script>
			$(function()	{
				$(".date_debut").datepicker({
				showOtherMonths : true,
				showButtonPanel : true,
				selectOtherMonths : true,
				changeMonth : true,
				changeYear : true,
				numberOfMonths : 1,
				dateFormat: "yyyy-mm-dd",
				regional: "fr",
				showWeek: true,
				firstDay: 1,
				defaultDate: '<%=date_debut%>',
				});	
			});
			</script>
			
			<script>
			$(function()	{
				$(".date_fin").datepicker({
				showOtherMonths : true,
				showButtonPanel : true,
				selectOtherMonths : true,
				changeMonth : true,
				changeYear : true,
				numberOfMonths : 1,
				dateFormat: "yyyy-mm-dd",
				regional: "fr",
				showWeek: true,
				firstDay: 1,
				defaultDate:'<%=date_fin%>',
				});	
			});
			</script>
			
 			<script>
     		var geocoder;
     		var map;
     		var address_script1 = '<%=list_map_address%>';
     		var address_script = [<% for (int i = 0; i < list_map_address.size(); ++i) { %>"<%= list_map_address.get(i) %>"<%= i + 1 < list_map_address.size() ? ",":"" %><% } %>];
     		function initMap() {
        		var map = new google.maps.Map(document.getElementById('map'), {
         		zoom: 8,
          		center: {lat: 48.856614, lng: 2.3522219}
        		});
        		geocoder = new google.maps.Geocoder();
        		codeAddress(geocoder, map);
      		}

      		function codeAddress(geocoder, map) {
      			var marker, i;    
        	    for (i = 0; i <address_script.length ; i++) {  
        		geocoder.geocode({'address': address_script[i]}, function(results, status) {
          		if (status === 'OK') {
            		map.setCenter(results[0].geometry.location);
            	    marker = new google.maps.Marker({
            	    	map: map,
            	        position: new google.maps.Marker(address_script[i]),
            	      });
            		var marker = new google.maps.Marker({
              		map: map,
              		position: results[0].geometry.location
            		});
          		} else {
            		alert('Geocode was not successful for the following reason: ' + status);
          		}
        		}
        		);
        		(marker, i);
      		}
      		}	
    		</script>
    		
    		<script async defer
    		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXwLgKExLrciBvKknXo1Igo8P4G-a07Co&callback=initMap&libraries=&v=weekly">
    		</script> 
</html>

