#maak een rechthoek
def tabel_maker(rijen, kolommen, teken):
    for i in range(rijen):
        for j in range(kolommen):
            print(teken, "\t", end="")
        print()


tabel_maker(10, 10, "$")