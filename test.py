import sys

input = "hello cat hello to the world of running dogs never world to say hello"
word1 = "hello"
word2 = "world"

g1 = False
g2 = False

mindist = sys.maxsize
counter = 0;
for word in input.split():
    g1 = True if word == word1 else g1
    counter = 0 if g1 ^ g2 == True and word == word1 else counter
    g2 = True if word == word2 else g2
    counter = 0 if g1 ^ g2 == True and word == word2 else counter
    
    counter = counter + 1 if g1 ^ g2 == True else counter
    if g1 and g2:
        if counter < mindist:
            mindist = counter - 1
        counter = 0
        g1 = False if word == word2 else g1
        g2 = False if word == word1 else g2

print("Min distance is :", mindist)

