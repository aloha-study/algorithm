import sys


def judge(number):
    number = str(number)

    for i in range(len(number) // 2):
        if number[i] != number[-1 - i]:
            return "no"
    
    return "yes"


while True:
    number = int(sys.stdin.readline().rstrip())

    if not number:
        break

    print(judge(number))

# Thinking Point!
# text == text[::-1]