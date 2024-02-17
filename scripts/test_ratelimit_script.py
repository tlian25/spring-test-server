#!/usr/bin/env python

import requests
import json
import random
import time


HOSTNAME = 'localhost:8080'

def ping():
    resp = requests.get(f'http://{HOSTNAME}/v1/ping')
    if resp.status_code == 200:
        print(f"Ping: {id} => {resp.content.decode('utf-8')} - {time.time()}")
        return resp.content.decode('utf-8')
    raise Exception("Error getting tinyurl ", resp.content)


def ping_ratelimited():
    resp = requests.get(f'http://{HOSTNAME}/v1/ratelimited/ping')
    if resp.status_code == 200:
        print(f"Ping: {id} => {resp.content}")
        return resp.content.decode('utf-8')
    raise Exception("Error getting tinyurl ", resp.content)



if __name__ == '__main__':
    while True:
        try:
            ping()
            time.sleep(0.01)
        except Exception as e:
            print(e)
            time.sleep(1)