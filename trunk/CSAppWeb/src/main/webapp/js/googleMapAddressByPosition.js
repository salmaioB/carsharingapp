function getAddress(overlay, latlng) {
	/* Si "latlng" n'est pas null ... */
	    if (latlng != null) {
	    	alert(" latlng not null");
	/* ... alors address = latlng ... */
	        address = latlng;
	/* ... et on demande au géocodeur nommé "geocodeur" de trouver l'adresse postale, en  ... */
	/* ... envoyant une requête au service de géocodage de Google, correspondant au point ... */
	/* ... ayant pour coordonnées "latlng" et, une fois la réponse obtenue, celle-ci sera ... */
	/* ... traitée à l'aide de la fonction "showAdress".                                  ... */
	        geocodeur.getLocations(latlng, showAddressQuery);
	    }
	    else
	    	alert(" latlng null ");
	}
	  
	/* Fonction showAddress(response) */
	/* response : Réponse retournée par le service de géocodage de Google */
	function showAddressQuery(response) {
	/* ... Suppression de tous les recouvrements (info-bulles, marqueurs, etc.) présents sur la carte nommée "maCarte" ... */
	    //maCarte.clearOverlays();
        alert("here");
        alert(response);
	/* ... Si la requête envoyée au service de géocodage de Google ne retourne ... */
	/* ... aucune réponse, ou que le code de la réponse est différent de "200" ... */
	    if (!response || response.Status.code != 200) {
	/* ... Alors un message d'alerte s'affiche à l'écran, indiquant le code de la réponse ... */
	        alert("Code Statut : " + response.Status.code);
	/* ... Sinon, lorsque la requête envoyée au service de géocodage de Google est ok ... */
	    } else {
	/* ... place = sélection de la première réponse générée par le service de géocodage de Google ... */
	        place = response.Placemark[0];
	/* ... Création d'un point nommé "point" aux latitudes et longitudes de l'adresse postale la plus proche du point cliqué ... */
	        point = new GLatLng(place.Point.coordinates[1], place.Point.coordinates[0]);
	/* ... Création d'un marqueur nommé marker ancré sur le point "point" ... */
	        marker = new GMarker(point);
	/* ... Affiche sur la carte nommée "maCarte" le marqueur nommé "marker" ... */
	        maCarte.addOverlay(marker);
	/* ... Latitude_Longitude_point_clique = correspond à la longitude et à la latitude du point cliqué ... */
	        Latitude_Longitude_point_clique = response.name;
	/* ... Latitude_La_Plus_Proche_Adresse = correspond à la latitude de l'adresse postale la plus proche du point cliqué ... */
	        Latitude_La_Plus_Proche_Adresse = place.Point.coordinates[0];
	/* ... Longitude_La_Plus_Proche_Adresse = correspond à la longitude de l'adresse postale la plus proche du point cliqué ... */
	        Longitude_La_Plus_Proche_Adresse = place.Point.coordinates[1];
	/* ... Statut_De_La_Requete = Statut de la requête (équivalent aux codes HTML : 200, 400, 500, 601, 602, 603, 604, 610, 620) ... */
	        Statut_De_La_Requete = response.Status.code;
	/* ... Type_De_Requete = indique le type de requête : geocode ... */
	        Type_De_Requete = response.Status.request;
	/* ... Adresse_Postale_Complete = Adresse postale complète la plus proche du point cliqué ... */
	        Adresse_Postale_Complete = place.address;
	/* ... Niveau_De_Precision_Adresse = Niveau de précision de la réponse (code de 0 à 9) ... */
	        Niveau_De_Precision_Adresse = place.AddressDetails.Accuracy;
	/* ... Code_Pays_Adresse = Code du pays correspondant à l'adresse postale la plus proche du point cliqué (FR : France) ... */
	        Code_Pays_Adresse = place.AddressDetails.Country.CountryNameCode;
	/* ... Region_Adresse = Région correspondant à l'adresse postale la plus proche du point cliqué ... */
	        Region_Adresse = place.AddressDetails.Country.AdministrativeArea.AdministrativeAreaName;
	/* ... Departement_Adresse = Département correspondant à l'adresse postale la plus proche du point cliqué ... */
	        Departement_Adresse = place.AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.SubAdministrativeAreaName;
	/* ... Ville_Adresse = Ville correspondant à l'adresse postale la plus proche du point cliqué ... */
	        Ville_Adresse = place.AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.LocalityName;
	/* ... Rue_Adresse = Rue correspondant à l'adresse postale la plus proche du point cliqué ... */
	        Rue_Adresse = place.AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.Thoroughfare.ThoroughfareName;
	/* ... Code_Postal_Adresse = Code postal correspondant à l'adresse postale la plus proche du point cliqué ... */
	        Code_Postal_Adresse = place.AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.PostalCode.PostalCodeNumber;
	/* ... Ouverture d'une info-bulle ancrée au marqueur nommé "marker"   ... */
	/* ... et dont on construit le contenu à partir des données ci-dessus ... */
	        marker.openInfoWindowHtml(
	            '<b>Latitude, Longitude du point cliqué  : </b>' + Latitude_Longitude_point_clique + '<br />' +
	            '<b>Type de requête : </b>' + Type_De_Requete + '<br />' +
	            '<b>Status de la requête : </b>' + Statut_De_La_Requete + '<br />' +
	            '<b>Niveau de précision : </b>' + Niveau_De_Precision_Adresse + '<br />' +
	            '<b>Latitude adresse : </b>' + Latitude_La_Plus_Proche_Adresse + '<br />' +
            '<b>Longitude adresse : </b>' + Longitude_La_Plus_Proche_Adresse + '<br />' +
				'<b>Adresse postale : </b>' + Adresse_Postale_Complete + '<br />' +
	            '<b>Code pays : </b> ' + Code_Pays_Adresse + '<br />' +
	            '<b>Région : </b> ' + Region_Adresse + '<br />' +
	            '<b>Département : </b> ' + Departement_Adresse + '<br />' +
	            '<b>Ville : </b> ' + Ville_Adresse + '<br />' +
	            '<b>Rue : </b> ' + Rue_Adresse + '<br />' +
	            '<b>Code postal : </b> ' + Code_Postal_Adresse
	        );
	    }
	}