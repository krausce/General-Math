def gcd(a, b):
    """
    a, b: two positive integers
    Returns the greatest common divisor of a and b
    """
    #YOUR CODE HERE
    a = abs(int(a))
    b = abs(int(b))
    while b != 0:
        (a, b) = (b, a % b)
    return a
a = int(input('Please type the lower integer you would like to test '))
b = int(input('Please type the higher integer you would like to test '))
print(gcd(a,b))
