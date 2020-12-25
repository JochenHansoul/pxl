for i in range(0, 10000, 6):
    if i % 28 == 0:
        print(i)

#efficienter:
for i in range(0, 1000, 28):
    if i % 6 == 0:
        print(i)