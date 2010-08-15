var geocoder = null;
var lon = 0;
var lat = 0;

function initializeMapEmpty(stringDivMap)
{
	var centreCarte = new google.maps.LatLng(47.390293,0.688834);
	 // OPtion carte
	 var optionsCarte = {
				zoom: 4,
				center: centreCarte,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};

	// Création de la carte
	var gMap = new google.maps.Map(document.getElementById(stringDivMap), optionsCarte);
}
function initializePosition()
{
	
	var longitude = $('#geolocLongitude').text();
	var latitude = $('#geolocLatitude').text();

	var centreCarte = new google.maps.LatLng(longitude,latitude);
	 // OPtion carte
	 var optionsCarte = {
				zoom: 13,
				center: centreCarte,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};

	// Création de la carte
	var maCarte = new google.maps.Map(document.getElementById("map"), optionsCarte);

	printPoint(maCarte, longitude, latitude);
}

function autoriezdNewPosition(marker,divInputAddress,divInputTown)
{
	marker.setDraggable(true);

    google.maps.event.addListener(marker, 'drag', function() {
        geocoder.geocode({'latLng': marker.getPosition()}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
            	//alert(results[0].formatted_address);
            	divInputAddress.value = results[0].formatted_address;
 
            	//alert(results[0].address_components[0].street_address );
            	
              //$('#address').val(results[0].formatted_address);
              //$('#latitude').val(marker.getPosition().lat());
              //$('#longitude').val(marker.getPosition().lng());
            }
            if(results[1])
            {
            	//alert("alert 1 ok");
            	divInputTown.value = results[1].formatted_address;
            }else
            	alert("alert 1 ok");
          }
        });
      })
}

function printPointMove(gMap,x,y,divAddress,divTown) {
   	// creation du marqueur0.688834
   	var marqueur = new google.maps.Marker({
   		position: new google.maps.LatLng(x,y),
   		map: gMap
   	});
   	autoriezdNewPosition(marqueur,divAddress,divTown);
}
function printPoint(gMap,lat,lon) {
   	// creation du marqueur0.688834
   	var marqueur = new google.maps.Marker({
   		position: new google.maps.LatLng(lat,lon),
   		map: gMap
   	});
}
    
	    function printParcours(maCarte,tableauLieux) {
	    	// Affiche parcours
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
		 // Poistion
		 var centreCarte = new google.maps.LatLng(47.390293,0.688834);
		 // OPtion carte
		 var optionsCarte = {
					zoom: 8,
					center: centreCarte,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
	
		// Création de la carte
		var maCarte = new google.maps.Map(document.getElementById("map"), optionsCarte);
		
		var x = 47.390293;
		var y = 0.688834;
	
		printPoint(maCarte, x, y);
				
		// Tableaux de lieu
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
	
		// printParcours(maCarte, tableauLieux);
		// geoCodeur = new google.maps.Geocoder();

		// geoCodeur = new google.maps.Geocoder();

		// geocodeAdresse(maCarte,geoCodeur,"13 rue d'hautpoul paris 19") ;
		// var query = "13 rue d'hautpoul paris 19";
		// var latlng = parseLatLng(query);
		// geocode({ 'latLng': latlng });
		// map = maCarte;
		
		// geocode(request,maCarte);
	    }
	 
	 
	 
	// http://gmaps-samples-v3.googlecode.com/svn/trunk/geocoder/v3-geocoder-tool.html#q%3D13%20rue%20d%27hautpoul%20paris%2019%26country%3Dfr%26language%3Dfr

	 // function initialize() {
	// position = new Array();
	 // geocoder = new google.maps.Geocoder();
	 // }

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
			find = true;
			alert( results[0].geometry.location.lat() );
		      lat = results[0].geometry.location.lat();
		      lon = results[0].geometry.location.lng();
		}
	}
	
	function parcoursAll(Vstart,Vstop,maCarte)
	{
		// pour afficher le parcours
		var directionsService = new google.maps.DirectionsService();
		var directionsDisplay = new google.maps.DirectionsRenderer();
		// set la map
		directionsDisplay.setMap(maCarte);
		directionsDisplay.setPanel(document.getElementById("road"));
		
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
	function initializeMapParcoursPost() {
		var Vstart = $('#villeStartPost').text();
		var Vstop = $('#villeStopPost').text();
		var map = document.getElementById("mapPost");

		initializeMapParcours(Vstart,Vstop,map);
	}
	function initializeMapParcoursSearch() {
		var Vstart = $('#start').text();
		var Vstop = $('#stop').text();
		var divMap = document.getElementById("mapSearch");
		
		initializeMapParcours(Vstart,Vstop,divMap);
	}
	
function initializeMapParcours(start,stop,divMap) {
	geocoder = new google.maps.Geocoder();

	// getPositionByAddress(start) ;
	// Poistion
	// alert(position[0],position[1]);

	var centerMap = new google.maps.LatLng(48.0,1.0);
	// OPtion carte
	var optionsMap = {
					zoom: 8,
					center: centerMap,
					mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	
	// Création de la carte
	var gMap = new google.maps.Map(divMap, optionsMap);
		 
	parcoursAll(start,stop,gMap);
}

/*
 * Affiche une position en fonction d'une adresse dans une map
 */
var nameDivMap;
var nameDivaddress;
var nameDivTown;

function initinitializePositionByAdress(divAddressVille,divAddress,divMap)
{
	geocoder = new google.maps.Geocoder();
	nameDivMap = divMap;
	nameDivaddress = divAddress;
	nameDivTown = divAddressVille;
	printPositionByAddress($('#'+divAddressVille).val()+" "+$('#'+divAddress).val());
}

function printPositionByAddress(address) {
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
	geocoder.geocode(request, showResultInMap);
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

function showResultInMap(results, status) {
	if (status == google.maps.GeocoderStatus.OK) {
	      lat = results[0].geometry.location.lat();
	      lon = results[0].geometry.location.lng();
		  var centreCarte = new google.maps.LatLng(results[0].geometry.location.lat(),results[0].geometry.location.lng());
		  
		  
		  // OPtion carte
		  var optionsCarte = {
		 			zoom: 16,
		 			center: centreCarte,
		 			mapTypeId: google.maps.MapTypeId.ROADMAP
		 		};
		 // Création de la carte
		 var maCarte = new google.maps.Map(document.getElementById(nameDivMap), optionsCarte);
		 printPointMove(maCarte,lat,lon,document.getElementById(nameDivaddress),document.getElementById(nameDivTown));
	}
}