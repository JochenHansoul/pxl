getal_string = input("Geef een reëel getal in: ")
if getal_string.find("." or ",") != -1:
    #voor comma berekenen:
    list = getal_string.split("." or ",")
    getal = list[0]
    getal_comma = "0." + list[1]
    getal = int(getal)
    string = ""
    while getal != 0:
        string += str(getal % 2)
        getal //= 2
    # na comma berekenen:
    getal_comma = float(getal_comma)
    string_comma = ""
    teller = 0
    while not (getal_comma == 1 or teller > 10):
        getal_comma *= 2
        if getal_comma > 1:
            string_comma += "1"
            getal_comma -= 1
        else:
            string_comma += "0"
        teller += 1
    print(string[-1::-1] + ".", end="")
    print(string_comma)
else:
    getal = int(getal_string)
    string = ""
    while getal != 0:
        string += str(getal % 2)
        getal //= 2
    print(string[-1::-1])