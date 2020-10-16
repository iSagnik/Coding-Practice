#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'avgRotorSpeed' function below.
#
# URL for cut and paste
# https://jsonmock.hackerrank.com/api/iot_devices/search?status={statusQuery}&page={number}
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING statusQuery
#  2. INTEGER parentId
#
import requests
import json
import math

def avgRotorSpeed(statusQuery, parentId):
    url = 'https://jsonmock.hackerrank.com/api/iot_devices/search?status='+ statusQuery + '&page='
    pageCount = 0
    response = requests.get( url + str(pageCount) )
    dataJSON = json.loads( response.content )
    rotorDataList = []
    pages = dataJSON['total_pages']
    
    for pageCount in range(1, pages + 1):
        response = requests.get( url + str(pageCount) )
        dataJSON = json.loads( response.content )
        for device in dataJSON['data']:
            #print( device )
            try:
                pId = device['parent']['id']
                #print(device['parent']['id'])
                if pId == parentId:
                    rotorSpeed = int(device['operatingParams']['rotorSpeed'])
                    rotorDataList.append( rotorSpeed )
            except:
                pass
    if len( rotorDataList ) == 0:
        return 0
    #print( rotorDataList )
    return math.floor( sum(rotorDataList) / len( rotorDataList ))