# Schrijf een programma om van 2 tekstvariabelen één tekstvariabele te maken.
# De nieuwe variabele bekom je door de eerste 4 letters van 1ste tekstvariabele te nemen (indien deze minder dan 4 letters bevat dient dit van achter aangevuld te worden met `*`) in hoofdletters
# gevolgd door de laatste 4 letters van de 2de tekst variabele indien deze minder dan 4 letters bevat dient dit van voor aangevuld te worden met `+`) in kleine letters.

# als eerste had ik te veel berekeningen gemaakt
# ik had gewoon asterixen achter en kruisen voor de variabelen kunnen zetten!
# daarna moest ik gewoon de lengte nemen va nde 2e variabele met de kruisen erbij, voor het afprinten moet je dan gewoon de totale lengte nemen en hier vier van aftrekken.
# doordat je altijd 4 kruisen toevoegt is dit geen probleem en wanneer je 4 of meer letters ingeeft wordt dit 0 en zal er worden geteld na de positieve getallen.
var1 = input("geef een tekst in: ") + "****"
var2 = "++++" + input("geef een tekst in: ")

len2 = len(var2)

nieuw = var1[:4].upper() + var2[len2 -4:].lower()
print(nieuw)