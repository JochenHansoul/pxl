woord1 = "mango"
woord2 = "banaan"
letters_hetzelfde = ""
for letter in woord1:
    if letter in woord2:
        letters_hetzelfde += letter + " "
print("{} en {} hebben {}gemeen.".format(woord1, woord2, letters_hetzelfde))