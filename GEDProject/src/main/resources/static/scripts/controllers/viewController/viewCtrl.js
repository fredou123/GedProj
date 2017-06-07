angular.module('viewModule', ["viewDossierService"])
.controller('ViewTypeDossierCtrl',['$scope','ViewDossierService', function($scope,ViewDossierService){
	$scope.user = ViewDossierService.user;
	$scope.listTypeM = $scope.user.typeDossierTypeMetadonnees;
	
	$scope.listTypeDoc = $scope.user.typeDossierTypeDocuments;
}])
.controller('ViewTypeDocumentCtrl',['$scope','ViewDossierService', function($scope,ViewDossierService){
	$scope.user = ViewDossierService.user;
	$scope.listTypeM = $scope.user.typeDocumentTypeMetadonnees;
	$scope.listTypeDossiers = $scope.user.typeDossierTypeDocuments;
	console.log($scope.user.typeDocumentTypeMetadonnees);
	console.log($scope.listTypeM);
}])
.controller('ViewTypeMetadonneeCtrl',['$scope','ViewDossierService', function($scope,ViewDossierService){
	$scope.user = ViewDossierService.user;
	$scope.listTypeDoc = $scope.user.typeDocumentTypeMetadonnees;
	$scope.listTypeDossiers = $scope.user.typeDossierTypeMetadonnees;
	
}]);