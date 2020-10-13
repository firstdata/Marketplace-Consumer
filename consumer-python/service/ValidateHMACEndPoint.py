import requests
import datetime
import hashlib
import hmac
import json
import uuid
import codecs

from model.LeadHistoryResponse import LeadHistoryResponse

from flask import Flask, jsonify, json, abort, make_response
import os

app = Flask(__name__)
app.config.from_object('config')

def validateHMACEndPoint(request):
    authorization = request.headers.get('Authorization')
    apikey = request.headers.get('apikey')
    secret = request.headers.get('pzsecret')
    secret1 = app.config.get('HMAC_SECRET')
    timestamp = request.headers.get('timestamp')
    nonce = request.headers.get('nonce')
    payload = request.json

    hmacStr = apikey + timestamp + nonce

    hmacKey = hmac.new(codecs.encode(hmacStr), str(payload).encode('utf-8'),
                       digestmod=hashlib.sha256).hexdigest()

    newAuthorization = "HMAC " + apikey + ":" + hmacKey + ":" + nonce + ":" + timestamp

    if authorization == newAuthorization and secret == secret1:
        leadHistoryResponse = LeadHistoryResponse(payload)
        print(leadHistoryResponse)
        return "Success"
    return abort(make_response(jsonify(message="HMAC token mismatch"), 401))
