getala = int(input("Geef getal A in: "))
getalb = int(input("Geef getal B in: "))
bewerkingscode = int(input("Geef de bewerkingscode (1 - 5) in: "))
if bewerkingscode < 1 or bewerkingscode > 5:
    print("Foutieve code")
else:
    if bewerkingscode == 1:
         getalx = getala + getalb
    elif bewerkingscode == 2:
         getalx = getala - getalb
    elif bewerkingscode == 3:
        getalx = getala * getalb
    elif bewerkingscode == 4:
        getalx = getala ** 2
    else:
        getalx = getalb ** 2
    print("Getal a", getala, "en getal b", getalb, "resultaat:", getalx)