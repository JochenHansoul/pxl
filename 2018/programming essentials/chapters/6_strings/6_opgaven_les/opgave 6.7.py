tekst = "Barefoot on the grass,\
 # listening to our favorite song"
positie = tekst.find("#")
nieuw = tekst[positie + 1:].strip() #al de spaces ' ' worden verwijderd voor de eerste spatie te verwijderen.
print(nieuw)