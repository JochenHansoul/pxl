def bereken_belasting(inkomen):
    if inkomen <= 25000:
        belasting = inkomen * 0.384
    else:
        belasint = 250000 * 0.384
        if inkomen <= 55000:
            belasting += 0.5 * (inkomen - 25000)
        else:
            belasting += 0.5 * 3000 + 0.6 * (inkomen - 55000)
    return belasting
    #het vorige is beter dan de kommentaar want hier zitten herhalingen in:
    #elif inkomen <= 55000:
    #    belasting = 25000 * 0.384 + (inkomen - 25000) * 0.5
    #else:
    #    belasting = 25000 * 0.384 + 30000 * 0.5 + (inkomen - 55000) * 0.6


bedrag = int(input("Geef je inkomen in: "))
print("De belasting bedraagt ", bereken_belasting(bedrag))