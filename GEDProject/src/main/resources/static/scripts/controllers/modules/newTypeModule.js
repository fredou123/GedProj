angular.module('newTypeModule', ['viewService'])
.controller('NewTypeDocumentCtrl', ['$scope','ViewService','$http','$window', function($scope,ViewService,$http,$window){

$scope.typeMetas = ViewService.typeMetas;
$scope.typeDos = ViewService.typeDos;
$scope.typeMetadonnee = {};
$scope.typeDossier = {};

$scope.vueIf = false;

$scope.vue = function(){
	$scope.vueIf = true;
};

$scope.typeDocumentTypeMetadonnees = [];
$scope.idsTab = [];
$scope.ajouter = function(elt,mtd,name){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	
	elt.typeMetadonnee=mtd;
	elt.nom=name;

	function seuil(element) {
  		return element == mtd.id;
	}
	var test = $scope.idsTab.find(seuil)
	console.log(test);
	if (test){
		alert('Métadonnée déjà existante');
	}else{
		$scope.idsTab.push(mtd.id);
		$scope.typeDocumentTypeMetadonnees.push(elt);
		$scope.vueIf = false;
	}
	console.log($scope.idsTab);
	
	$scope.typeDocumentTypeMetadonnee ={
            isObligatoire:true,
            regex:null,
            defaultValue:null,
            typeMetadonnee:null
    };

};

$scope.typeDocumentTypeMetadonnee = {
            isObligatoire:null,
            regex:null,
            defaultValue:null,
            typeMetadonnee:null
    };

$scope.typeDossierTypeDocuments = [];

$scope.vueIf1 = false;
$scope.vue1 = function(){
	$scope.vueIf1 = true;
};


$scope.idsTabDoc = [];


$scope.ajouterDos = function(elt,mtd,name){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	elt.typeDossier=mtd;
	elt.nom = name;

	function seuil(element) {
  		return element == mtd.id;
	}
	var test = $scope.idsTabDoc.find(seuil)
	console.log(test);
	if (test){
		alert('Document déjà existant');
	}else{
		$scope.idsTabDoc.push(mtd.id);
		$scope.typeDossierTypeDocuments.push(elt);
		console.log($scope.typeDossierTypeDocuments);
		console.log($scope.typeDossier);
		$scope.vueIf1 = false;
	}
	console.log($scope.idsTab);
	
	$scope.typeDossierTypeDocument ={
            isObligatoire:true,
            typeDossier:null
    };

};

$scope.typeDossierTypeDocument = {
            isObligatoire:null,
            typeDocument:null
};

$scope.typeDocument = {
        nom:null,
        date_creation:null,
        date_last_modification: null,
        typeDocumentTypeMetadonnees:$scope.typeDocumentTypeMetadonnees,
        typeDossierTypeDocuments:$scope.typeDossierTypeDocuments
    };

$scope.save = function(nom){

	$scope.typeDocument.nom = nom;
	if ($scope.typeDocument.nom == null || $scope.typeDocument.nom == ""){
		alert ("nom du type de document manquant");
	}else{
		var data = $scope.typeDocument;
	console.log($scope.typeDocument);
	console.log(data);
	$http.post("/typeDocuments/", JSON.stringify(data) )
            .success(function(response){ 
                console.log(response);
             })
            .error(function(response){
                console.log(response.message);
                console.log("erreur+++++++++");
    });
    $window.location.href = '#/typeDocument';
	}
	
}

$scope.close = function(){
	$window.location.href = '#/typeDocument';
}

}])
.controller('NewTypeDossierCtrl', ['$scope','ViewService','$http','$window', function($scope,ViewService,$http,$window){

$scope.typeMetas = ViewService.typeMetas;
console.log($scope.typeMetas);
console.log("+++++++++++++");
$scope.typeDocs = ViewService.typeDocs;
$scope.typeMetadonnee = {};
$scope.typeDocument = {};

$scope.vueIf = false;
$scope.vue = function(){
	$scope.vueIf = true;
};

$scope.typeDossierTypeMetadonnees = [];
$scope.idsTab = [];

$scope.ajouterMeta = function(elt,mtd,name){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	
	elt.typeMetadonnee=mtd;
	elt.nom = name;

	function seuil(element) {
  		return element == mtd.id;
	}
	var test = $scope.idsTab.find(seuil)
	console.log(test);
	if (test){
		alert('Métadonnée déjà existante');
	}else{
		$scope.idsTab.push(mtd.id);
		$scope.typeDossierTypeMetadonnees.push(elt);
		$scope.vueIf = false;
	}
	console.log($scope.idsTab);
	
	$scope.typeDossierTypeMetadonnee ={
            isObligatoire:true,
            regex:null,
            defaultValue:null,
            typeMetadonnee:null
    };

};

$scope.typeDossierTypeDocuments = [];

$scope.vueIf1 = false;
$scope.vue1 = function(){
	$scope.vueIf1 = true;
};


$scope.idsTabDoc = [];


$scope.ajouterDoc = function(elt,mtd,name){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	elt.typeDocument=mtd;
	elt.nom = name;

	function seuil(element) {
  		return element == mtd.id;
	}
	var test = $scope.idsTabDoc.find(seuil)
	console.log(test);
	if (test){
		alert('Document déjà existant');
	}else{
		$scope.idsTabDoc.push(mtd.id);
		$scope.typeDossierTypeDocuments.push(elt);
		console.log($scope.typeDossierTypeDocuments);
		console.log($scope.typeDossier);
		$scope.vueIf1 = false;
	}
	console.log($scope.idsTab);
	
	$scope.typeDossierTypeDocument ={
            isObligatoire:true,
            typeDocument:null
    };

};

$scope.typeDossierTypeMetadonnee = {
            isObligatoire:null,
            regex:null,
            defaultValue:null,
            typeMetadonnee:null
};

$scope.typeDossierTypeDocument = {
            isObligatoire:null,
            typeDocument:null
};

$scope.typeDossier = {
        nom:null,
        date_creation:new Date(),
        date_last_modification: new Date(),
        typeDossierTypeMetadonnees:$scope.typeDossierTypeMetadonnees,
        typeDossierTypeDocuments:$scope.typeDossierTypeDocuments
};

$scope.save = function(nom){

	$scope.typeDossier.nom = nom;

	if ($scope.typeDossier.nom == null || $scope.typeDossier.nom == ""){
		alert("nom du type de dossier manquant");
	}else{
		var data = $scope.typeDossier;
	console.log($scope.typeDossier.nom);
	console.log(data);
	$http.post("/typeDossiers/", JSON.stringify(data) )
            .success(function(response){ 
                console.log(response);
             })
            .error(function(response){
                console.log(response.message);
    });
    $window.location.href = '#/typeDossier';
	}
}

$scope.close = function(){
	$window.location.href = '#/typeDossier';
}

}])
.controller('NewTypeMetadonneeCtrl', ['$scope','ViewService','$http','$window', function($scope,ViewService,$http,$window){
	
	$scope.typeDos = ViewService.typeDos;
	$scope.typeDossier = {};
	$scope.typeDocs = ViewService.typeDocs;
	$scope.typeDocument = {};

	$scope.vueIf = false;
	$scope.vue = function(){
		$scope.vueIf = true;
	};

	$scope.typeDocumentTypeMetadonnees = [];
	$scope.idsTabDoc = [];
	$scope.ajouterDoc = function(elt,mtd,name){

		if (elt.isObligatoire == null){
			elt.isObligatoire = true;
		}
		if (elt.isObligatoire == "Oui"){
			elt.isObligatoire = true;
		}
		if (elt.isObligatoire == "Non"){
			elt.isObligatoire = false;
		}
		
		elt.typeDocument=mtd;
		elt.nom=name;

		function seuil(element) {
	  		return element == mtd.id;
		}
		var test = $scope.idsTabDoc.find(seuil)
		console.log(test);
		if (test){
			alert('Métadonnée déjà existante');
		}else{
			$scope.idsTabDoc.push(mtd.id);
			$scope.typeDocumentTypeMetadonnees.push(elt);
			$scope.vueIf = false;
		}
		console.log($scope.idsTabDoc);
		
		$scope.typeDocumentTypeMetadonnee ={
	            isObligatoire:true,
	            regex:null,
	            defaultValue:null,
	            typeDocument:null
	    };

	};

	$scope.typeDocumentTypeMetadonnee = {
	            isObligatoire:null,
	            regex:null,
	            defaultValue:null,
	            typeDocument:null
	    };
	
	$scope.vueIf1 = false;
	$scope.vue1 = function(){
		$scope.vueIf1 = true;
	};

	$scope.typeDossierTypeMetadonnees = [];
	$scope.idsTab = [];

	$scope.ajouterDos = function(elt,mtd,name){

		if (elt.isObligatoire == null){
			elt.isObligatoire = true;
		}
		if (elt.isObligatoire == "Oui"){
			elt.isObligatoire = true;
		}
		if (elt.isObligatoire == "Non"){
			elt.isObligatoire = false;
		}
		
		elt.typeDossier=mtd;
		elt.nom = name;

		function seuil(element) {
	  		return element == mtd.id;
		}
		var test = $scope.idsTab.find(seuil)
		console.log(test);
		if (test){
			alert('Métadonnée déjà existante');
		}else{
			$scope.idsTab.push(mtd.id);
			$scope.typeDossierTypeMetadonnees.push(elt);
			$scope.vueIf1 = false;
		}
		console.log($scope.idsTab);
		
		$scope.typeDossierTypeMetadonnee ={
	            isObligatoire:true,
	            regex:null,
	            defaultValue:null,
	            typeDossier:null
	    };

	};
	
	$scope.typeDossierTypeMetadonnee ={
            isObligatoire:true,
            regex:null,
            defaultValue:null,
            typeDossier:null
    };
	
	$scope.typeMetadonnee = {
	        nom:null,
	        date_creation:null,
	        date_last_modification: null,
	        typeDocumentTypeMetadonnees:$scope.typeDocumentTypeMetadonnees,
	        typeDossierTypeMetadonnees:$scope.typeDossierTypeMetadonnees
	    };

$scope.save = function(nom){

	if (nom == null || nom == ""){
		alert("nom du type de la metadonnéé manquant");
	}else{
		$scope.typeMetadonnee.nom = nom;
		var data = $scope.typeMetadonnee;
		console.log(data);
	$http.post("/typeMetadonnees/", JSON.stringify(data) )
            .success(function(response){ 
                console.log(response);
             })
            .error(function(response){
                console.log(response.message);
                console.log("erreur+++++++++");
    });
    $window.location.href = '#/typeMetadonnee';
	}
}

$scope.close = function(){
	$window.location.href = '#/typeMetadonnee';
}

}]);