def dotProduct(listA, listB):
    '''
    listA: a list of numbers
    listB: a list of numbers of the same length as listA
    '''
    return sum([a*b for a,b in zip(listA,listB)])
listA = [1, 2, 3]
listB = [4, 5, 6]
print(dotProduct(listA, listB))