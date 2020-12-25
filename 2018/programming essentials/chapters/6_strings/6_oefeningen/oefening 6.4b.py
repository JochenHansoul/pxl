var1 = input("geef een tekst in: ")
var2 = input("geef een tekst in: ")
len1 = len(var1)
len2 = len(var2)
if len1 < 4:
    var1 += "****"
if len2 < 4:
    var2 = var2[-1::-1] + "++++"    #misschien is het toch iets te ingewikkeld om de string om te keren  en er ++++ achter te zetten en deze daarna om te draaien.
nieuw = var1[:4].upper() + var2[4::-1].lower()
print(nieuw)