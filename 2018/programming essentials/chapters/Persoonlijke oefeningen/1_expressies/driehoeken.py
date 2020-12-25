"""
driehoek van 5, 5
driehoek omkeren
"""
teller = 0
for i in range(5):
    print("\t" * i, end="")
    for j in range(5 - i):
        teller += 1
        print(teller, "\t", end="")
    print()