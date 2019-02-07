def uniqueValues(aDict):
    U_Vals = {}
    # create dict to sum all value counts
    for i in aDict.values():
        U_Vals.setdefault(i,0)
        U_Vals[i] += 1   
    # use each v/val from aDict as the key to vals
    # keeping each k/key from aDict if the count is 1
    return sorted(k for k, v in aDict.items() if U_Vals[v] == 1)

aDict = {0: 4, 9: 4, 3: 4, 5: 2, 1: 1}
print(uniqueValues(aDict))