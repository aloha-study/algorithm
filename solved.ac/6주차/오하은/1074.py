import sys

input = sys.stdin.readline

N, r, c = map(int,input().split())

ans = 0

while N != 0:

	N -= 1

	# 0
	if r < 2**N and c < 2**N:
		ans += (2**N) * (2**N) * 0

	# 1
	elif r < 2**N and c >= 2**N: 
		ans += (2**N)*(2**N) * 1
		c -= (2**N)
        
	# 2
	elif r >= 2**N and c < 2**N: 
		ans += (2**N)*(2**N) * 2
		r -= (2**N)
        
	# 3
	else:
		ans += (2**N)*(2**N) * 3
		r -= 2**N
		c -= 2**N
    
print(ans)