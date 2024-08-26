import sys

n = int(sys.stdin.readline().rstrip())
shrits = list(map(int, sys.stdin.readline().rstrip().split()))
t, p =  map(int, sys.stdin.readline().rstrip().split())

print(sum([count // t if count % t == 0 else count // t + 1 for count in shrits]))
print(n // p, n % p)
