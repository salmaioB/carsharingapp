
function autoriezdNewPosition(marqueur)
    	{
	    	marqueur.setDraggable(true);
	        google.maps.event.addListener(marqueur, '0.688834dragend', function(event) {
	    		//message d'alerte affichant la nouvelle position du marqueur
	    		alert("La nouvelle coordonnée du marqueur est : "+event.latLng);
	    	});
    	}
	    function printPoint(carte,x,y) {
	    	//creation du marqueur0.688834
	    	var marqueur = new google.maps.Marker({
	    		position: new google.maps.LatLng(x,y),
	    		map: carte
	    	});
	    	//autoriezdNewPosition(marqueur);
	    }
    
	    function printParcours(maCarte,tableauLieux) {
	    	//Affiche parcours
	    	var infobulle = new google.maps.InfoWindow();
	    	var bounds = new google.maps.LatLngBounds();
	    	for (var i = 0; i < tableauLieux.length; i++) {
	    		var Lieu = tableauLieux[i];0.688834
	    		var pointLieu = new google.maps.LatLng(Lieu[1], Lieu[2]);
	    		bounds.extend(pointLieu);
	    		var marqueurLieu = new google.maps.Marker({
	    			position: pointLieu,
	    			map: maCarte,
	    			title: Lieu[0],
	    			contenuInfoBulle: Lieu[3]
	    		});
	    		google.maps.event.addListener(marqueurLieu, "click", function() {
	    			infobulle.setContent(this.contenuInfoBulle);
	    			infobulle.open(maCarte,this);
	    		});
	    	}
	    	maCarte.fitBounds(bounds);
	    }
  
	 function initialize() {
		 //Poistion
		 var centreCarte = new google.maps.LatLng(47.390293,0.688834);
		 //OPtion carte
		 var optionsCarte = {
					zoom: 8,
					center: centreCarte,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
	
		//Création de la carte
		var maCarte = new google.maps.Map(document.getElementById("map"), optionsCarte);
		
		var x = 47.390293;
		var y = 0.688834;
	
		printPoint(maCarte, x, y);
				
		//Tableaux de lieu
		var tableauLieux = [
		        			["Alfa",     47.325371, 1.044195, "Descriptif Alfa"],
		        			["Bravo",    47.345627, 0.894806, "Descriptif Bravo"],
		        			["Charlie",  47.334488, 0.944717, "Descriptif Charlie"],
		        			["Delta",    47.331615, 1.129307, "Descriptif Delta"],
		        			["Echo",     47.270981, 1.375158, "Descriptif Echo"],
		        			["Foxtrot",  47.290585, 1.346169, "Descriptif Foxtrot"],
		        			["Golf",     47.330112, 0.995293, "Descriptif Golf"],
		        			["Hotel",    47.339272, 1.175795, "Descriptif Hotel"],
		        			["India",    47.307144, 1.318617, "Descriptif India"],
		        			["Juiett",   47.328671, 1.288072, "Descriptif Juiett"],
		        			["Kilo",     47.344994, 1.212090, "Descriptif Kilo"],
		        			["Mike",     47.357315, 0.831850, "Descriptif Mike"],
		        			["Novembre", 47.342327, 1.245060, "Descriptif Novembre"]
		        	];
	
		//printParcours(maCarte, tableauLieux);
		//geoCodeur = new google.maps.Geocoder();

		//geoCodeur = new google.maps.Geocoder();

		//geocodeAdresse(maCarte,geoCodeur,"13 rue d'hautpoul paris 19") ;
		//var query = "13 rue d'hautpoul paris 19";
		//var latlng = parseLatLng(query);
		//geocode({ 'latLng': latlng });
		//map = maCarte;
		
		//geocode(request,maCarte);
	    }
	 
	 
	 
	//http://gmaps-samples-v3.googlecode.com/svn/trunk/geocoder/v3-geocoder-tool.html#q%3D13%20rue%20d%27hautpoul%20paris%2019%26country%3Dfr%26language%3Dfr

	 var geocoder = null;
	 var position = null;
	 
	 //function initialize() {
	//	position = new Array();
	 //  	geocoder = new google.maps.Geocoder();
	 //}

	function submitQuery() {
		var query = document.getElementById("query").value;
		if (/\s*^\-?\d+(\.\d+)?\s*\,\s*\-?\d+(\.\d+)?\s*$/.test(query)) {
			var latlng = parseLatLng(query);
			if (latlng == null) {
		    	document.getElementById("query").value = "";
		    } else {
	    		geocode({ 'latLng': latlng });
		    }
		} else {
			geocode({ 'address': query });
		}
	}
	function getPositionByAddress(address) {
		var query = address;
		if (/\s*^\-?\d+(\.\d+)?\s*\,\s*\-?\d+(\.\d+)?\s*$/.test(query)) {
			var latlng = parseLatLng(query);
			if (latlng == null) {
		    	document.getElementById("query").value = "";
		    } else {
	    		geocode({ 'latLng': latlng });
		    }
		} else {
			geocode({ 'address': query });
		}
	}
	function geocode(request) {  
		var hash = '';
		hashFragment = '#' + escape(hash);
		window.location.hash = escape(hash);
		geocoder.geocode(request, showResults);
	}

	function parseLatLng(value) {
		value.replace('/\s//g');
		var coords = value.split(',');
		var lat = parseFloat(coords[0]);
		var lng = parseFloat(coords[1]);
		if (isNaN(lat) || isNaN(lng)) {
			return null;
		} else {
			return new google.maps.LatLng(lat, lng);
		}
	}

	function showResults(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
		      position[0] = results[0].geometry.location.lat();
		      position[1] = results[0].geometry.location.lng();
		}
	}
	
	function parcoursAll(start,stop,maCarte)
	{
		//pour afficher le parcours
		var directionsService = new google.maps.DirectionsService();
		var directionsDisplay = new google.maps.DirectionsRenderer();
		//set la map
		directionsDisplay.setMap(maCarte);
		directionsDisplay.setPanel(document.getElementById("road"));
		
		var Vstart = $('#start').text();
		var Vstop = $('#stop').text();

		var requeteItineraire = {
			origin: Vstart,
			destination: Vstop,
			travelMode: google.maps.DirectionsTravelMode.DRIVING
		};
		directionsService.route(requeteItineraire, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);
			}
		});	
	
	}

	function initializeMapParcours() {

		geocoder = new google.maps.Geocoder();
		position = new Array();
		//getPositionByAddress("paris fr") ;
		 //Poistion
		 var centreCarte = new google.maps.LatLng(48,1);
		 //OPtion carte
		 var optionsCarte = {
					zoom: 8,
					center: centreCarte,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
	
		//Création de la carte
		var maCarte = new google.maps.Map(document.getElementById("map"), optionsCarte);
		 
		parcoursAll("paris","lyon",maCarte);
	 }