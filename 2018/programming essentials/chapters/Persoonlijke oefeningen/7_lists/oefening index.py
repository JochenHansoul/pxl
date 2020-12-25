def find_element(list, element):
    amount = list.count(element)
    print(element, "komt", amount, "keer voor")
    plaats = 0
    for i in range(amount):
        plaats = list.index(element, plaats)
        print("op plaats", plaats)
        plaats += 1


list = ["appel", "banaan", "kers", "kiwi", "appel", "banaan", "appel"]
element = "appel"
find_element(list, element)
