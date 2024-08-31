import sys
inputf = sys.stdin.readline
while True:
    N = list(inputf().strip())
    if int(''.join(N))==0:
        break

    if N == list(reversed(N)):
        print('yes')
    else:
        print('no')