# Hansoul Jochen - 1TIN C
# dec getal naar bin getal
getal_string = input("Geef een reëel getal in: ")
list = getal_string.split(".")
getal = list[0]
getal_comma = list[1]
string = ""
while getal != 0:
    string += str((getal % 2 ))
    getal //= 2
print(string[-1::-1])

string_comma = ""
while getal_comma != 0:
    string_comma