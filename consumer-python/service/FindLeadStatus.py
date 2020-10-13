import json
import os
from model.LeadStatusResponseModel import LeadStatusResponseModel
from model.LeadStatusRequest import LeadStatusRequest

from flask import Flask

app = Flask(__name__)


def findLeadStatus(request):
    filename = os.path.abspath('static/json/LeadStatusResponse.json')
    with open(filename) as payload:
        data = json.load(payload)

    leadStatusResponseModel = LeadStatusResponseModel(json.dumps(data))
    print(leadStatusResponseModel)
    return "Success"
