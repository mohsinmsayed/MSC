import requests
import json

# GET & Response
api_url = "https://jsonplaceholder.typicode.com/todos/1"
response = requests.get(api_url)
print(response.json())
print(response.status_code)

# Put & Patch
todo = {'userId': 1, 'id': 1, 'title': 'Complete Practicals', 'completed': False}
headers = {"Content-Type":"application/json"}
response = requests.patch(api_url,data=json.dumps(todo),headers=headers)
print(response.json())

todo = {'userId': 1, 'id': 1, 'title': 'Complete Assignments', 'completed': False}
response = requests.put(api_url,json=todo)
print(response.json())

# Delete
api_url = "https://jsonplaceholder.typicode.com/todos/1"
response = requests.delete(api_url)
print(response.json())
print(response.status_code)