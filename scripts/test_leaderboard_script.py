#!/usr/bin/env python

import requests
import json
import random
import time


HOSTNAME = 'localhost:8080'


USERS = [chr(ord('A')+i) for i in range(26)]


def add_score(userId:str, score:int):
    resp = requests.put(f'http://{HOSTNAME}/v1/leaderboard/{userId}/{score}')
    print(f"Adding score: {userId} - {score}. {resp.status_code} - {resp.content.decode('utf-8')}")
    return resp.status_code, resp.content.decode('utf-8')


def add_random_score(userId:str):
    return add_score(userId, random.randint(0, 100))


def add_random():
    userId = USERS[random.randint(0, 25)]
    add_random_score(userId)


if __name__ == '__main__':
    while True:
        try:
            add_random()
        except Exception as e:
            print(e)



