from django.shortcuts import render
from django.http import HttpResponse
from django.contrib.auth.decorators import login_required
from django.conf import settings
import json
import os
import sys
from django.views.decorators.csrf import csrf_exempt

def login_html(request):
    return render(request, 'login.html')

def change_password_html(request):
    return render(request, 'change-password.html')

def reset_password_html(request):
    return render(request, 'reset-password.html')

def add_user(request):
    return render(request, 'add-user.html')
