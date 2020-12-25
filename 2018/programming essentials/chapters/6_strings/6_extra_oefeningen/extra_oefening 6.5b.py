# Vul een variabele teken per teken op met de letters van het alfabet (kleine letters). Druk de inhoud af.
# Zorg er vervolgens voor dat telkens de tweede letter in een hoofdletter omgezet wordt, aBcDeF….yZ. Druk de inhoud op nieuw af.
# Vervang de letter ‘H’ door een ‘X’.
lettervar = input("Geef letters in: ").lower()
print(lettervar)
nieuw = ""
for i in range(len(lettervar)):
    if i % 2 != 0:
        nieuw += lettervar[i].upper()
    else:
        nieuw += lettervar[i]
print(nieuw)
print(nieuw.replace("H", "X"))