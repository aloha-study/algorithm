import sys


def convertText(number):
    if number % 3 == 0 and number % 5 == 0:
        return "FizzBuzz"
    if number % 3 == 0:
        return "Fizz"
    if number % 5 == 0:
        return "Buzz"
    return number

result = ''

for i in range(3):
    text = sys.stdin.readline().rstrip()
    if text.isnumeric():
        result = convertText(int(text) + 3 - i)

print(result)
