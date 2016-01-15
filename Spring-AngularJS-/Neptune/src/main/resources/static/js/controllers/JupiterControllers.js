/**
 * 
 */
app.controller("MainCtrl", function($scope) {
	$scope.home="Welcome";
});

/**
 * controller login
 */
app.controller("LoginCtrl", function($scope, AuthenticationService) {
	
	$scope.connected = false;
	 $scope.credentials = { username: "", password: ""};
	 
	  $scope.login = function() {
		AuthenticationService.login($scope.credentials);
	  };
	console.log($scope.connected );
});


/**
 * router pour la page home
 */
app.controller("HomeCtrl", function($scope) {
	 $scope.logout = function () {
		 AuthenticationService.logout();
     };
	
});

/**
 * router pour la page companies
 */
app.controller("CompanyCtrl", function($scope, $http) {
	$scope.comanies = [];
	$http({
		 method: "GET",
		 url: "http://localhost:8080/companies"
		 }).success(function(data){
			 $scope.companies = data;
			 console.log(data);
		 }).catch(function(response) {
			console.log("response", response);
	});
});
	
/**
 * router pour la page prosepections
 */
app.controller("ProspectionsCtrl", function($scope, $http) {
	$scope.prospections = [];
	$http({
		 method: "GET",
		 url: "http://localhost:8080/prospections"
		 }).success(function(data){
			 $scope.prospections = data;
		 }).catch(function(response) {
			console.log("response", response);
	});
});

/**
 * router pour la page Contacts
 */
app.controller("ContactsCtrl", function($scope, $http) {
	$scope.contacts = [];
	$scope.pageCourante=0;
	$http({
		 method: "GET",
		 url: "http://localhost:8080/customers?=page="+$scope.pageCourante
		 }).success(function(data){
			 $scope.contacts = data;
		 }).catch(function(response) {
			console.log("response", response);
	});
});

/**
 * router pour la page Workflows
 */
app.controller("WorkflowsCtrl", function($scope) {
	
});

/**
 * router pour la page Tasks
 */
app.controller("TaskstCtrl", function($scope) {
	
});

/**
 * router pour la page Reporting
 */
app.controller("ReportingCtrl", function($scope) {
	
});

/**
 * router pour la page Calendar
 */
app.controller("alendarCtrl", function($scope) {
	
});

/**
 * router pour la page Messagerie
 */
app.controller("MessagerieCtrl", function($scope) {
	
});

/**
 * router pour la page Calendar
 */
app.controller("CalendarCtrl", function($scope) {
	
});
	
/**
 * router pour la page about
 */
app.controller("AboutCtrl", function($scope) {
	
});
	

	
	
	
