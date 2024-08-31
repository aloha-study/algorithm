import sys

inputf = sys.stdin.readline
arr = []
ans = 0
for i in range(3):
    arr.append(inputf().strip())

for i,s in enumerate(arr):
    if s!="Fizz" and s!="Buzz" and s!="FizzBuzz":
        ans = int(s)+(3-i)
        break

if ans % 15 == 0 :
    print("FizzBuzz")
elif ans % 5 == 0 :
    print("Buzz")
elif ans % 3 == 0 :
    print("Fizz")
else:
    print(ans)