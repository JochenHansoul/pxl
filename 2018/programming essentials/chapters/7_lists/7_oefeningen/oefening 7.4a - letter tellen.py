string = "DDDDit is en qsdfze16345634 string"
list = 26 * [0]
# alfabet list maken
alphabet_list = []
eerste_letter = ord("a")
for i in range(26):
    alphabet_list.append(chr(eerste_letter + i))
# telt kleine letters
plaats = 0
for i in "abcdefghijklmnopqrstuvqxyz":
    for j in string:
        if j.islower():
            if j == i:
                list[plaats] += 1
    plaats += 1
# telt grote letters
plaats = 0
for i in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
    for j in string:
        if j.isupper():
            if j == i:
                list[plaats] += 1
    plaats += 1
# print resultaat
for i in range(len(alphabet_list)):
    print(alphabet_list[i] + ":", list[i])