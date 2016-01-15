angular.module("app").factory('AuthenticationService', function($location) {
	   return {
	     login: function(credentials) {
	       if(credentials.username === "admin") {
	    	  $location.path('/home');
	    	  
	    	  $scope.connected = true;
	        }
	       
	     },
	     logout: function() {
	       $location.path('/login');
	     //  $scope.connected = false;
	     }
	   };
});