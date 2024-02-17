#!/usr/bin/env python

import requests
import json
import random
import time


HOSTNAME = 'localhost:8080'

def create_tiny_url(url):
    resp = requests.put(f'http://{HOSTNAME}/v1/urls/{url}')
    
    if resp.status_code == 200:
        # resp = json.loads(resp.content)
        print(f"Creating TinyURL: {url} => {resp.content}")
        return resp.content.decode('utf-8')
    raise Exception("Error creating tinyurl ", resp.content)


def get_tiny_url(id):
    resp = requests.get(f'http://{HOSTNAME}/v1/urls/{id}')
    if resp.status_code == 200:
        print(f"Getting TinyURL: {id} => {resp.content}")
        return resp.content.decode('utf-8')
    raise Exception("Error getting tinyurl ", resp.content)

    

with open("urls.txt") as f:
    URLS = [x.replace('\n', '') for x in f.readlines()]
    print(URLS)
    L = len(URLS)

if __name__ == '__main__':
    
    while True:
        try:
            i = random.randint(0, L-1)
            id = create_tiny_url(URLS[i])
            original = get_tiny_url(id)
            assert original == URLS[i], original
        except Exception as e:
            print(e)
            time.sleep(1)
        
        


