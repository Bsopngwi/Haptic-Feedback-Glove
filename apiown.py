# -*- coding: utf-8 -*-
"""
Created on Tue Feb 21 13:15:07 2023

@author: Barbichou
"""
from flask import Flask, request
import requests
import json

app= Flask(__name__)

data_set={'Frequency':'default','TimeBurst':'default','FingerSequencing':'default'}


@app.route('/', methods=['GET','POST'])

def handle_request():
    if request.method=='POST':
        print(request.get_data())
        
        databyte=request.get_data()
        data_str = databyte.decode('utf-8')
        data_json = json.loads(data_str)
        
        if "Frequency" in data_json:
            data_set['Frequency']=data_json['Frequency']
        if "Time Burst" in data_json:
            data_set['TimeBurst']=data_json['Time Burst']
        if "Finger Sequencing" in data_json: 
            data_set['FingerSequencing']=data_json['Finger Sequencing'] 
   
    json_dump=json.dumps(data_set)
           
    return json_dump



if __name__=='__main__':
    app.run(port=7777)
