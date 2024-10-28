import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    cards = []
    d = [[0] * (n + 1) for _ in range(2)]

    for _ in range(2):
        cards.append(list(map(int, sys.stdin.readline().rstrip().split())))

    d[0][1] = cards[0][0]
    d[1][1] = cards[1][0]

    for i in range(2, n + 1):
        d[0][i] = max(d[1][i - 1], d[1][i - 2], d[0][i - 2]) + cards[0][i - 1]
        d[1][i] = max(d[0][i - 1], d[1][i - 2], d[0][i - 2]) + cards[1][i - 1]
    
    max_result = 0

    for card in d:
        max_result = max(max_result, max(card))

    print(max_result)
