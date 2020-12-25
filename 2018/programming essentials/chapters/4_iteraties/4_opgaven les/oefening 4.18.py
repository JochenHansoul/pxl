getal = int(input("geef een getal in >= 0 en <= 10: "))
while getal < 0 or getal > 10:
    getal = int(input("geef een getal in >= 0 en <= 10: "))

#Dit word aangeraden i.p.v. een not(getal > 0 and getal < 10) want dit wordt te complex wanneer er een 3e factor aan toegevoegd wordt.