import requests
import datetime
import hashlib
import hmac
import json
import uuid
import codecs

from flask import Flask, jsonify, json, abort, make_response
import os

from model.LeadHistoryResponse import LeadHistoryResponse

app = Flask(__name__)
app.config.from_object('config')

def validateOAUTHEndPoint(request):
    authorization = request.headers.get('Authorization')
    newAuthorization = app.config.get("OAUTH_KEY")
    payload = request.json

    if authorization == newAuthorization:
        leadHistoryResponse = LeadHistoryResponse(json.dumps(payload))
        print(leadHistoryResponse)
        return "Success"
    return abort(make_response(jsonify(message="OAUTH token mismatch"), 401))
