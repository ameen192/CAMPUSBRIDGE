from django.urls import path

from . import views

urlpatterns = [
	path('', views.index, name='index'),
	path('login', views.login, name='login'),
	path('afterlogin', views.afterlogin, name='afterlogin'),
    path('home', views.home, name='home'),
    path('serverdetails', views.serverdetails, name='serverdetails'),
    #path('get_servers', views.get_servers, name='get_servers'),
    path('csv_upload', views.csv_upload, name='csv_upload'),
    #path('usertoqueue', views.usertoqueue, name='usertoqueue')
]