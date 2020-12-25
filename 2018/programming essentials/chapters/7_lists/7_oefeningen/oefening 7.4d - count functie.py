string = "DDDDit is en qsdfze16345634 string"
string = string.lower()
list = 26 * [0]
# alfabet list maken
alphabet_list = []
eerste_letter = ord("a")
for i in range(26):
    alphabet_list.append(chr(eerste_letter + i))
# telt en print aantal letters
plaats = 0
for i in "abcdefghijklmnopqrstuvqxyz":
    tel = string.count(i)
    if tel > 0:
        print(i, "komt", tel, "keer voor")