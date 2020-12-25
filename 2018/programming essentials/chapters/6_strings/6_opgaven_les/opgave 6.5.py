voor = input("geef een voornaam in").strip() #dit laatste wordt gebruikt om de eerste spatie te verwijderen mochten ze die het erbij zetten om dit duidelijker te maken.
achter = input("geef een achternaam in").strip()
eerste_voor = voor[0].upper()
eerste_achter = achter[0].upper()
rest_achter = achter[1:].lower()
nieuw = eerste_voor + ". " + eerste_achter + rest_achter
print(nieuw)
print()

voor = "jochen"
achter = "hansoul"
eerste_voor = voor[0].upper()
eerste_achter = achter[0].upper()
laatst_achter = achter[1:].lower()
naam = eerste_voor + ". " + eerste_achter + laatst_achter
print(naam)