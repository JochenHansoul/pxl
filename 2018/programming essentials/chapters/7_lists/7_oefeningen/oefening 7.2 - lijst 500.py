from random import randint
list = []
groter_list = []
som = 0
for i in range(500):
    list.append(randint(0, 10000))
    if list[i] > 5000:
        groter_list.append(list[i])
if len(groter_list) < 250:
    print(sum(groter_list))
else:
    for i in list:
        if i > 8000:
            som += i
    print(som)