var version = "1.0.0"; // 版本

var app = new Framework7({
	id : 'dmsxcx',
	name : 'My App dcmsxcx',
	varsion: '1.0.0',
	theme: 'auto',
	routes : routes,
	root : 'body',
	data: function(){
		return {
			username: 'wwp',
			age: '29'
		};
	},
	methods: {
		alert: function(){
			app.dialog.alert('hollo world');
		}
	},
	on: {
		init: function(){
			console.log('app initialized');
		},
		pageInit: function(){
			console.log('Page initialized');
		}
	},
	panel : {
		swipe : 'left',
	},
});

var mainView = app.views.create('.view-main');


function login(){
	alert(3);
}
