var app=angular.module("app", ['ngRoute']);

/**
 * configuration des routers pour la navigation
 */
app.config(function($routeProvider) {
	$routeProvider.when("/login",{
		templateUrl: "views/login.html",
		controller: "LoginCtrl"
	}).when("/home",{
		templateUrl: "views/home.html",
		controller: "HomeCtrl"
	}).when("/prospections",{
		templateUrl: "views/prospections.html",
		controller: "ProspectionsCtrl"
	}).when("/companies",{
		templateUrl: "views/companies.html",
		controller: "CompanyCtrl"
	}).when("/about",{
		templateUrl: "views/about.html",
		controller: "AboutCtrl"
	}).when("/contacts",{
		templateUrl: "views/contacts.html",
		controller: "ContactsCtrl"
	}).when("/workflows",{
		templateUrl: "views/workflows.html",
		controller: "WorkflowsCtrl"
	}).when("/tasks",{
		templateUrl: "views/taskx.html",
		controller: "TasksCtrl"
	}).when("/messagerie",{
		templateUrl: "views/messagerie.html",
		controller: "MessagerieCtrl"
	}).when("/reporting",{
		templateUrl: "views/companies.html",
		controller: "CompaniesCtrl"
	}).when("/calendar",{
		templateUrl: "views/calendar.html",
		controller: "CalendarCtrl"
	});
	
	$routeProvider.otherwise({ redirectTo : '/home' });
});
	