import requests
from flask import Flask, jsonify, json

from model.LeadStatusRequest import LeadStatusRequest

app = Flask(__name__)


def triggerLeadStatusAPI():
    url = "http://localhost:5000/v1/leads/status"
    leadStatusRequest = LeadStatusRequest()
    leadStatusRequest.setReferralIds(["V7LxQ", "QyLyV", "VAJOQ", "r8qx5", "52KjV", "VPZRr", "5DepV", "Vnyz5", "Q4WaV", "5OAaQ",
        "VemXV", "VvKlQ", "rm2p5", "rJnzr", "V1W7r", "r0WvQ", "rq7gV", "rB0zV", "VYdE5", "VjnnV",
        "VGeXr", "VpyZQ", "rWgqr", "VR6MV", "VoA2r", "Q9Wl5", "r3W1r", "5M2RV", "5b0jQ", "VlP9V",
        "QzXe5", "QkDZr", "QxNo5", "QEmqQ", "5LPo5", "rXNOV", "QdJm5", "rN8KV", "rgeJV", "QKD1r",
        "VwgpV", "Qabzr", "QZXB5", "V6W2Q", "V7WxV", "QydyV", "VAWOr", "r8BxV", "52WjV", "ABCDE",
        "5DJpQ", "Vn8zr"])
    strRequest = leadStatusRequest.__str__()
    jsonRequest = eval(strRequest)
    print(jsonRequest)
    res = requests.post(url, json.dumps(jsonRequest))
    print(res.status_code)
    return "Success"
