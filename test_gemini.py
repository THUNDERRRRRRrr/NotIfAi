import requests
import json
import sys

api_key = sys.argv[1]
url = f"https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key={api_key}"

payload = {
    "system_instruction": {
        "parts": [{"text": "You are a helpful assistant."}]
    },
    "contents": [{
        "role": "user",
        "parts": [{"text": "Hello"}]
    }]
}

response = requests.post(url, headers={"Content-Type": "application/json"}, data=json.dumps(payload))
print("With system_instruction:", response.status_code, response.text[:200])

payload2 = {
    "systemInstruction": {
        "parts": [{"text": "You are a helpful assistant."}]
    },
    "contents": [{
        "role": "user",
        "parts": [{"text": "Hello"}]
    }]
}
response2 = requests.post(url, headers={"Content-Type": "application/json"}, data=json.dumps(payload2))
print("With systemInstruction:", response2.status_code, response2.text[:200])
