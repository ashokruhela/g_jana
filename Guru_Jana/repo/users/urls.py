from django.urls import path
from . import views

urlpatterns = [
    path('add-user', views.add_user, name='add-user'),
    path('login/', views.login_html, name='login-html'),
    path('change-password/', views.change_password_html, name='change-password-html'),
    path('reset-password/', views.reset_password_html, name='reset-password-html')
]