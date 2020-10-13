import requests
import datetime
import hashlib
import hmac
import json
import uuid
import codecs

from flask import Flask, jsonify, json, abort, make_response
import os

app = Flask(__name__)
app.config.from_object('config')


def triggerEndPoint(request):
    # parsed = json.loads(request.data)
    # print(json.dumps(parsed, indent=4, sort_keys=True))
    # return "Success"
    filename = os.path.abspath('static/json/ApplicationHistory.json')
    with open(filename) as f:
        payload = json.load(f)

    url = "http://localhost:5000/v1/lead/history/endpoint"
    headers = {'Content-Type': 'application/json'}
    res = requests.post(url, data=json.dumps(payload), headers=headers)
    if res.status_code == 200:
        return "Success"
    else:
        return "Failure"


def triggerHMACEndPoint(request):
    filename = os.path.abspath('static/json/ApplicationHistory.json')
    with open(filename) as f:
        payload = f.read()

    timestamp = datetime.datetime.now().minute.__str__()
    secret = app.config.get("HMAC_SECRET")
    apiKey = app.config.get("API_KEY")
    nonce = str(uuid.uuid4()).replace("-", "")

    hmacstr = apiKey + timestamp + nonce

    hmackey = hmac.new(codecs.encode(hmacstr), payload.encode('utf-8'),
                       digestmod=hashlib.sha256).hexdigest()

    authorizationkey = "HMAC " + apiKey + ":" + hmackey + ":" + nonce + ":" + timestamp

    print("authorizationKey+++" + authorizationkey)

    url = "http://localhost:5000/v1/hmac/lead/history/endpoint"
    headers = {'Authorization': authorizationkey, 'apikey': apiKey, 'pzsecret': secret, 'timestamp': timestamp, 'nonce': nonce, 'Content-Type': "application/json"}
    res = requests.post(url, headers=headers, data=json.dumps(payload))
    if res.status_code == 200:
        return "Success"
    return abort(make_response(jsonify(message="HMAC token mismatch"), 401))


def triggerOAUTHEndPoint(request):
    # parsed = json.loads(request.data)
    # print(json.dumps(parsed, indent=4, sort_keys=True))
    # return "Success"
    filename = os.path.abspath('static/json/ApplicationHistory.json')
    with open(filename) as f:
        payload = json.load(f)

    authorization = app.config.get("OAUTH_KEY")

    url = "http://localhost:5000/v1/oauth/lead/history/endpoint"
    headers = {'Content-Type': 'application/json', 'Authorization': authorization}
    res = requests.post(url, data=json.dumps(payload), headers=headers)
    if res.status_code == 200:
        return "Success"
    else:
        return "Failure"