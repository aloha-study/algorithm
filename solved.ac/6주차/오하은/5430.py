import sys
inputf = sys.stdin.readline

T = int(inputf())
for _ in range(T):
    p = inputf().strip()
    n = int(inputf())
    arr = inputf().strip()[1:-1].split(',')
    
    if n == 0:
        arr = []
    else:
        arr = list(map(int, arr)) if arr[0] else []

    R = False 

    try:
        for i in p:
            if i == "R":
                R = not R  
            elif i == "D":
                if arr:
                    if R:
                        arr.pop() 
                    else:
                        arr.pop(0) 
                else:
                    raise IndexError  
    except IndexError:
        print("error")
        continue
    
    if R:
        arr.reverse()
    print('[' + ','.join(map(str, arr)) + ']')
