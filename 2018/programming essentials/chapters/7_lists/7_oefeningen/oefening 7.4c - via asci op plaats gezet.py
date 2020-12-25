zin = "DDDDit is en qsdfze16345634 string"
zin = zin.lower()
list = 26 * [0]
# alfabet list maken
alphabet_list = []
for i in range(26):
    alphabet_list.append(chr(97 + i))
# berekening
for letter in zin:
    ascii = ord(letter)
    if ascii >= 97 and ascii <= 122:
        list[ascii-97] += 1
# print resultaat
for i in range(len(alphabet_list)):
    print(alphabet_list[i] + ":", list[i])