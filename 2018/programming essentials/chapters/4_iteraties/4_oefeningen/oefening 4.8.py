aantal_trage_renners = 0
totaal_aanral_renners = 0
invoernummer = int(input("Geef het invoernummer in: "))
tijd_snelste_renner = 999999999
if invoernummer >= 0:
    while invoernummer >= 0:
        tijd = int(input("Geef de tijd in seconden in: "))
        if tijd < tijd_snelste_renner:
            snelste_renner = invoernummer
            tijd_snelste_renner = tijd
        if tijd > 3600:
            aantal_trage_renners += 1
        totaal_aanral_renners += 1
        invoernummer = int(input("Geef het invoernummer in: "))
    print("Snelste renner is renner met inschijvingsnummer:", snelste_renner)#de compiler gaat zich moeien met de invoer maar we zijn zeker dat hier een juiste waarde gaat ingegeven worden. In java gaat dit zelfs niet.
    print("Het percentage renners dat er langer dan 1 uur over doet is", aantal_trage_renners / totaal_aanral_renners * 100)