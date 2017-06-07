angular.module('newTypeModule', ['viewService'])
.controller('NewTypeDocumentCtrl', ['$scope','ViewService','$http','$window', function($scope,ViewService,$http,$window){

$scope.typeMetas = ViewService.typeMetas;
$scope.typeMetadonnee = {};

$scope.vueIf = false;

$scope.vue = function(){
	$scope.vueIf = true;
};

$scope.typeDocumentTypeMetadonnees = [];
$scope.idsTab = [];
$scope.ajouter = function(elt,mtd){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	
	mtd.date_creation = new Date();
	mtd.date_last_modification = new Date();
	elt.typeMetadonnee=mtd;

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

$scope.typeDocument = {
        nom:null,
        date_creation:new Date(),
        date_last_modification: new Date(),
        typeDocumentTypeMetadonnees:$scope.typeDocumentTypeMetadonnees
    };

$scope.save = function(nom){

	$scope.typeDocument.nom = nom;
	if ($scope.typeDocument.nom == null || $scope.typeDocument.nom == ""){
		alert ("nom du type de document manquant");
	}else{
		var data = $scope.typeDocument;
	console.log($scope.typeDocument.nom);
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
$scope.typeDocs = ViewService.typeDocs;
$scope.typeMetadonnee = {};
$scope.typeDocument = {};

$scope.vueIf = false;

$scope.vue = function(){
	$scope.vueIf = true;
};

$scope.typeDossierTypeMetadonnees = [];
$scope.idsTab = [];

$scope.ajouterMeta = function(elt,mtd){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	
	mtd.date_creation = new Date();
	mtd.date_last_modification = new Date();
	elt.typeMetadonnee=mtd;

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


$scope.ajouterDoc = function(elt,mtd){

	if (elt.isObligatoire == null){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Oui"){
		elt.isObligatoire = true;
	}
	if (elt.isObligatoire == "Non"){
		elt.isObligatoire = false;
	}
	
	mtd.date_creation = new Date();
	mtd.date_last_modification = new Date();
	elt.typeDocument=mtd;

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



$scope.save = function(nom){

	if (nom == null || nom == ""){
		alert("nom du type de la metadonnéé manquant");
	}else{
		var typeMetadonnee = {
		nom:nom,
		date_creation: new Date(),
		date_last_modification: new Date()
		};
	$http.post("/typeMetadonnees/", JSON.stringify(typeMetadonnee) )
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