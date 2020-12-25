list = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
for i in range(1, len(list)):
    list[i] = list[i] + list[i - 1]
print(list)