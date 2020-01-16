# Hänga Gubbe
## Syfte
Syftet med programmet är att designa och utveckla en konsolbaserad implementation av papper-och-penna leken [hänga gubbe](https://en.wikipedia.org/wiki/Hangman_game).
## Metod
Implementationen kommer använda biblioteket [JAnsi](https://fusesource.github.io/jansi/) för färgläggning av konsolgränssnittet. Lekens regler hämtas från Wikipedia.
##Regler
Datorn genererar ett ord, den ritar sedan ut lika många horisontella streck som antalet bokstäver i ordet på skärmen. Deltagarnas uppgift är att gissa det rätta ordet genom att i tur och ordning föreslå bokstäver. Om den föreslagna bokstaven finns i ordet skriver spelledaren in bokstaven på rätt plats eller platser över strecken. Finns bokstaven inte i ordet kommer datorn istället rita ett streck till den figur som när den är färdigställd kommer föreställa en hängd streckgubbe. Spelet är slut när alla bokstäver i ordet har blivit framgissade eller när streckfiguren är helt ritad.