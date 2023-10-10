# -*- coding: utf-8 -*-
"""
Created on Sun Feb 26 19:35:45 2023

@author: Barbichou
"""

import requests
import json

url='https://34d5-192-58-125-17.ngrok-free.app'

data={"Frequency":"100"}
json_data=json.dumps(data)

#headers={'Content-Type':'data/json'}

response=requests.post(url, json=data)

if response.status_code==200:
    print('Put request sucessful')
    
else:
    print(f'error {response.status_code}')