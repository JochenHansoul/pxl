tekst = "The quick brown fox jumps over de lazy cat"
tekst = tekst.replace("d", "the")
tekst = tekst.replace("cat", "dog")
# je kan ze ook in 1 string zetten: tekst = tekst.replace("d", "the").replace("cat", "dog")
print(tekst)