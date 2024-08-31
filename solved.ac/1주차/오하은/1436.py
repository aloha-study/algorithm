import sys
inputf = sys.stdin.readline
N = int(inputf())
num = 666
cnt = 0
while True:
    if '666' in str(num):
        cnt +=1
    if cnt == N:
        print(num)
        break
    num +=1