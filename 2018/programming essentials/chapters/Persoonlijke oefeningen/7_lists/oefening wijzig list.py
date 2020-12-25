def wijzig_list(list, index):
    if index >= 0 and index < len(list):
        list[index] = "Fruit"


list = ["appel", "banaan", "kers", "kiwi"]
index = 2
wijzig_list(list, index)
print(list)