var routes = [ {
	name : 'about',
	path : '/about/',
	url : './pages/about.html',
}, {
	name : 'news',
	path : '/news/',
	url : './pages/news.html',
	options : {
		animate : false,
	},
}, {
	name : 'form',
	path : '/form/',
	url : './pages/form.html',
	options : {
		animate : false,
	},
},
{
	path: '/news/',
    content: `
      <div class="page" data-name='news'>
        <div class="page-content">
          <div class="block">
            <p>This page created dynamically</p>
          </div>
        </div>
      </div>
    `,
},
{
	name : 'login',
	path : '/login/',
	url : './pages/login.html',
	options : {
		animate : false,
	},
},{
	name : 'users',
	path : '/users/',
	templateUrl : './pages/users.html',
	options : {
		context : {
			users : [ 'John Doe', 'Vladimir Kharlampidi', 'Timo Ernst' ],
		},
	},
	on : {
		pageAfterIn : function(e, page) {
			// do something after page gets into the view
		},
		pageInit : function(e, page) {
			// do something when page initialized
		},
	}
},
// Default route, match to all pages (e.g. 404 page)
{
	path : '(.*)',
	url : './pages/404.html',
} ]