bedrag = int(input("Geef het bedrag in centen in: "))
euro2 = bedrag // 200
bedrag %= 200
euro1 = bedrag // 100
bedrag %= 100
cent50 = bedrag // 50
bedrag %= 50
cent20 = bedrag // 20
bedrag %= 20
cent10 = bedrag // 10
bedrag %= 10
cent5 = bedrag // 5
bedrag %= 5
cent2 = bedrag // 2
bedrag %= 2
print("2 euro:", euro2, "1 euro:", euro1, "50 cent:", cent50, "20 cent:", cent20, "10 cent:", cent10, "5 cent:", cent5, "2 cent:", cent2, "1 cent:", bedrag)
