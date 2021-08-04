from django.urls import path
from . import views

urlpatterns = [
    path('new/', views.get_new_ticket_html, name='new-ticket-html'),
    path('ticketslist/', views.get_tickets_list_view_html, name='tickets-list'),
    path('ticket/', views.get_ticket_view_html, name='view-ticket'),
    path('comments/', views.get_ticket_comments, name='ticket-comments'),
    path('create', views.post_create_new_ticket, name='create-new-ticket'),
    path('edit', views.post_edit_ticket, name='edit-ticket'),
    path('delete', views.post_delete_ticket, name='delete-ticket'),
    path('comment', views.post_ticket_comment, name='add-comment')
]