from typing import *

# Brute force, checking every single pair O(n^2) time
def numberOfWeakCharacters2(self, properties: List[List[int]]) -> int:
    count = 0
    for i in range(len(properties)):
        chari = properties[i]
        for j in range(len(properties)):
            charj = properties[j]
            if i != j:
                if chari[0] < charj[0] and chari[1] < charj[1]:
                    count += 1
                    break
    return count

# This is a good approach, enumerating over all the possible 100000
# attacks and defense. The idea is to store a array where index
# of the array represent the attack, the value inside represent
# the defense. 
# The first loop will go over the properties to find out the max
# defense for each corresponding attack.
# The second loop goes from max attack down to 0 attack
# to basically create the area which where the weak character are
# located. If we have this then we can just iterate over the properties
# and use the attack as index to check the highest defense for that particular
# attack value. If it is less then we will add to count.
# When you compare you want to compare the one that's right after attack + 1
# cuz if you compare the same attack then it won't work.
def numberOfWeakCharacters3(self, properties: List[List[int]]) -> int:
    count = 0
    # Why do we need 100001 x? There are only 1 to 100000 possible attack
    # which is only 100000 numbers. But the numbers are indexed using
    # attack which starts from 1, but indices starts from 0, add 1
    # to accomodate that.
    maxHeight = [0] * 100002
    
    # maxHeight's index will be the attack, the value contain at
    # maxHeight[x] will store the maximum defenses for that
    # particular attack
    for v in properties:
        maxHeight[v[0]] = max(maxHeight[v[0]], v[1])         
        
    for i in range(100000, -1, -1):
        maxHeight[i] = max(maxHeight[i + 1], maxHeight[i])
    
    for point in properties:
        # You compare with the maximum height achieved by
        # the one after it. Otherwise, you might be comparing
        # [2,1] with max of [2,2] which will result in count += 1
        # so you should be looking at 3's maxHeight instead
        if point[1] < maxHeight[point[0] +1]:
            count += 1
    return count
    
def numberOfWeakCharacters(properties: List[List[int]]) -> int:
    # An even smarter approach that goes O(nlogn) time.
    # This involves sorting the list. Sort first the
    # list descending by attack. Then ascending by defense
    # Sorting always help!
    sort_prop = sorted(properties, key=lambda x : (-x[0], x[1]))

    # After sorting then you can just iterate over the properties
    # maintaining a count and a highest_defense
    # Because the list is sorted decescending by attack, you never
    # have to check for attack. It will either be greater than
    # or equal to the element after. Because you break tie by
    # ascending the defense, the higher defense one will always
    # come after the ones with same attack -> [1, 4] [1, 5] [1, 6]
    # Then all you have to do is maintain a highest_defense, which starts with 0
    # if it is greater than current element's defense you add 1
    # otherwise update highest_defense to current defense cuz is greater
    count = 0
    highest_defense = 0     
    for prop in sort_prop:
        if prop[1] < highest_defense:
            count += 1
        else:
            highest_defense = prop[1]
            
    return count

input1 = [[[5,5],[6,3],[3,6]],
[[2,2],[3,3]],
[[1,5],[10,4],[4,3]]]

for input in input1:
    print(numberOfWeakCharacters(input))