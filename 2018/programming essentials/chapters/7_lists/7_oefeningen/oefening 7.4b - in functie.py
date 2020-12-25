def alfabet_berekening(string, list, letters):
    plaats = 0
    for i in letters:
        for j in string:
            if j == i:
                list[plaats] += 1
        plaats += 1
    return list


string = "DDDDit is en qsdfze16345634 string"
list = 26 * [0]
# alfabet list maken
alphabet_list = []
eerste_letter = ord("a")
for i in range(26):
    alphabet_list.append(chr(eerste_letter + i))
# berekening telt letters
kleine_letters = "abcdefghijklmnopqrstuvqxyz"
grote_letters= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
list = alfabet_berekening(string, list, kleine_letters)
list = alfabet_berekening(string, list, grote_letters)
# print resultaat
for i in range(len(alphabet_list)):
    print(alphabet_list[i] + ":", list[i])