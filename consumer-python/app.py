import datetime
import hashlib
import hmac
import json

from flask import Flask, request, abort

from service import TriggerEndPoint, ValidateHMACEndPoint, TriggerLeadStatusAPI, ValidateOAUTHEndPoint, FindLeadStatus


app = Flask(__name__)
app.config.from_object('config')


@app.route('/api/referral/v1/leads/status', methods=['POST'], endpoint='func2')
def getLeadsStatus():
    response = FindLeadStatus.findLeadStatus(request)
    return response.__str__()


@app.route('/api/referral/v1/consumer/trigger/leads/status', methods=['POST'], endpoint='func3')
def triggerLeadsStatus():
    return TriggerLeadStatusAPI.triggerLeadStatusAPI()


@app.route('/v1/lead/history/endpoint', methods=['POST'], endpoint='func1')
def getLeadHistory():
    print(request.json)
    return "200"


@app.route('/v1/trigger/lead/history/endpoint', methods=['POST'], endpoint='func8')
def triggerLeadHistory():
    return TriggerEndPoint.triggerEndPoint(request)


@app.route('/v1/hmac/lead/history/endpoint', methods=['POST'], endpoint='func4')
def getLeadHistoryWithHmac():
    return ValidateHMACEndPoint.validateHMACEndPoint(request)


@app.route('/v1/trigger/hamc/lead/history/endpoint', methods=['POST'], endpoint='func5')
def triggerLeadHistoryEndPointWithHmac():
    return TriggerEndPoint.triggerHMACEndPoint(request)


@app.route('/v1/oauth/lead/history/endpoint', methods=['POST'], endpoint='func6')
def getLeadHistoryWithOAuth():
    return ValidateOAUTHEndPoint.validateOAUTHEndPoint(request)


@app.route('/v1/trigger/oauth/lead/history/endpoint', methods=['POST'], endpoint='func7')
def triggerLeadHistoryEndPointWithOAuth():
    return TriggerEndPoint.triggerOAUTHEndPoint(request)
