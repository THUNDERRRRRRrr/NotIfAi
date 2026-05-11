import requests
import json

url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=dummy_key"

payload = {
    "systemInstruction_WRONG": {
        "parts": [{"text": "You are a helpful assistant."}]
    },
    "contents": [{
        "role": "user",
        "parts": [{"text": "Hello"}]
    }],
    "generationConfig": {
        "responseMimeType": "application/json"
    }
}

response = requests.post(url, headers={"Content-Type": "application/json"}, data=json.dumps(payload))
print("Status Code:", response.status_code)
print("Response:", response.text)
