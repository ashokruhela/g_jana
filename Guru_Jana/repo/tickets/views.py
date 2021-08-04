from django.shortcuts import render
from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.conf import settings
import json
import os
import sys
from django.views.decorators.csrf import csrf_exempt


def get_current_function_name():
    return sys._getframe().f_back.f_code.co_name


def get_new_ticket_html(request):
    return render(request, 'new-ticket.html')


def get_tickets_list_view_html(request):
    return render(request, 'list-tickets.html')


def get_ticket_view_html(request):
    return render(request, 'view-ticket.html')


def get_ticket_comments(request):
    return HttpResponse(json.dumps({'status': 'Success'}), content_type='application/json')

@csrf_exempt
def post_create_new_ticket(request):
    return HttpResponse(json.dumps({'status': 'Success'}), content_type='application/json')


def post_edit_ticket(request):
    return HttpResponse(json.dumps({'status': 'Success'}), content_type='application/json')


def post_delete_ticket(request):
    return HttpResponse(json.dumps({'status': 'Success'}), content_type='application/json')


def post_ticket_comment(request):
    return HttpResponse(json.dumps({'status': 'Success'}), content_type='application/json')

