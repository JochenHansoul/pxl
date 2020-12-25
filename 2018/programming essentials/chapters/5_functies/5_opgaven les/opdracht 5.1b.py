#als ge bijvoorbeeld twee regels krijgt wordt het moeilijker
def print_regel(aantal, teken):
    for i in range(aantal):
        print(teken, end="")
    print()


print_regel(5, "*")
print_regel(15, "&")