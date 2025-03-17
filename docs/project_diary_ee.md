# CGI suvepraktika kodutöö 2025 projektipäevik 


## 1) Projekti skoobi ja funktsionaalsete nõuete määramine

Lähteülesandes kirjeldatud nõuded:
 - Kasutajale kuvatakse lennuplaan kõigi lendudega.
 - Lennuplaani peab saama filtreerida, sorteerida.
 - Iga lennu mõned istekohad peavad olema eeltäidetud.
 - Kasutaja peab saama valida lennu ja määrata reisijate arvu.
 - Kasutaja näeb valitud lennul olevaid vabu istekohti.
 - Kasutaja saab määrata istekohtade valiku kriteeriumid (eelistused).
 

### Projekti lähteülesandes täpsustamata detailid:
 - mis keeles peab rakendus olema   
	--> otsustasin teha esialgu rakenduse inglise keeles, 
		jättes võimaluse lisada keelevalik edasises arenduses.
 - rakenduse eluiga ja kui kauaks peab rakendus kasutaja valikud salvestama  
	--> arvan, et kui kasutaja valib istekohad, siis peaks need märkima 
		valituks, st järgmine kord sama lendu valides peaksid need olema võetud. 
 - kasutaja identifitseerimise ja meelespidamise vajadus  
	--> proovin esialgu luua lahenduse, mis vastab kirjeldatud nõuetele 
		ning kui see tehtud, kaalun kasutajate identifitseerimist ning 
		broneeringute salvestamise ja muutmise funktsionaalsuse lisamist. 
 - kust saada lendude andmed, kui neid ei laeta mõne reaalse lennufirma API kaudu  
	--> esimene mõte on, et rakenduse käivitades saaks andmed automaatselt 
		lugeda skripti kaudu sisse. Teine variant: juhul, kui lennugraafikus 
		on regulaarsed lennud, saab nendest rakenduse käivitamisel tuleviku lennud genereerida.
		Lennugraafiku järgi saab tulevasi lende genereerida ka dünaamiliselt, 
		nt hetkel, kui tehakse otsing kuupäeva kohta, millel veel lende ei leidu.
		Idee: leidsin Tallinna lennujaama kodulehelt lennuplaani regulaarsete lendudega,
		mis toimuvad kindlatel nädalapäevadel. Kasutan seda näidisena. 

## 2) Andmebaasi struktuur

Andmebaasi disainimisel lähtusin lennu andmetest: igal lend toimub mingit 
marsruuti pidi, sellel on kuupäev, kestvus ning seda lendu opereeriv lennufirma.
Lendu teenindab teatud tüüpi lennuk, millel igaühel on kindel hulk istekohti. 
Igal istekohal on number ning teatud omadused ning igal lennukitüübil on 
alati samasugune komplekt istmeid. Lennud toimuvad vastavalt lennuplaanile. 

Mõttekohad andmebaasi planeerimisel: 
 - kuhu paigutada hinnad, kui need sõltuvad kuupäevast, istme tüübidst ja lennuki täituvusest.
	--> ilmselt võiks hinnad tagarakenduses arvutada, mitte baasis hoida.
		Lahendus: lennuplaanis määratakse baashind ning dünaamiline hind arvutatakse.

Vaata andmebaasiskeemi kataloogis docs.

## 3) Töövoo plaan rakenduses
1. Rakendus käivitatakse
2. Andmebaasi tabelid lennujaam, lennuliin, lennufirma, lennuki tüüp, 
    iste, iste lennukil täidetakse näidisandmetega
3. Vastavalt lennuplaanile genereeritakse mõned konkreetsed tulevased lennud. 
    Igal lennul kindel kuupäev, kellaaeg, lähte- ja sihtkoht, istekohtade arv.
4. Kasutaja valib lennu ja soovitud kohtade arvu ning näeb istekohtade plaani.
5. Istekohtade plaanil on vaikimisi valikud tehtud, kuid plaanil klikates 
    saab kasutaja istekohti muuta. Lisaks kuvatakse valikud kasutajate 
    eelistuste salvestamiseks ning soovitatakse uued kohad.
6. Kasutaja kinnitab valiku ja saab kinnituse ning suunatakse avalehele. 
    Baasi salvestub märge istekoha hõivamise kohta. 
	   
## 4) Spring Boot projekti initsialiseerimine
1. Olemite kirjeldamine koodis model paketis
2. Repositooriumite loomine
3. Andmeedastusobjektide (DTO) loomine 
	   
	Mõttekoht dto ja service klasside loomisel. Eelistaksin kasutada andmete 
	edastuseks lihtsustatud dto klasse, et lihtsustada ja vähendada päringuid
	andmebaasist. Kuna kavandasin esialgse andmebaasi 9 olemiga, ei näinud 
	vajadust igale olemile oma crud-võimekust luua. Tegin testimiseks uue 
	projekti, kuhu võtsin 2 olemit: lend ja iste, et mõista paremini tegelikke vajadusi.   
	Lahendus: vaja on lennu andmeid lendude nimekirja kuvamiseks, otsingu 
	ja sorteerimise funktsionaalsust, lennuki istekohtade vaadet,
	istekohtade soovitamist ja broneerimist.

## 5) Controllerite ja teenuskihi äriloogika disain
- FlightController seob lennuinfoga seotud päringud
- SeatSelectionController tegeleb istekohtade valimisega seotud päringutega  
	   
## Vajalikud meetodid rakenduses:
- hinna dünaamiline arvutamine
- juhuslike istekohtade eelnev hõivamine
- vaikimisi istekoha soovitamine, kui eelistusi pole määratud
- istekoha soovitamine vastavalt eelistustele
	
	
## Mida oleksin soovinud täiendada / plaanin lähiajal juurde õppida:
- luua eraldi avalikud id-d eesrakenduse jaoks, et peita andmebaasi id-d.
- teha kasutajakontode süsteem, saata piletid e-maili peale
- võtta kasutusele logimine sujuvamaks arenduseks
- pika tabeli lehekülgedeks jaotamine
- korraliku api-ga suhtleva kliendi tegemine (Õpime seada käesoleval semestril Javascripti ja typescripti, Reactiga)
- Rakenduse paigutamine Dockeri konteinerisse - seekord ei jäänud aega seda uurida
- Projekt ei saanud lõplikult valmis (ei jõudnud istekohtade valimist esitamise ajaks realiseerida),  
	kuid kuna projekt on huvitav ja tahaksin harjutada, siis kavatsen sellega jooksvalt edasi tegeleda.  
  	Tahaksin realiseerida istekohtade soovitamiseks võimaluse valida eelistused koos prioriteetidega.

## Lõppsõna
Kasutasin OpenAI GPT-4 keelemudelit enamasti selleks, et uurida parimate praktikate kohta, samuti sain abi jpa ja thymeleaf'i süntaksi asjus.       
Olen tänulik, et selle projekti ette võtsin, sain kinnitust, et valisin ümberõppimiseks õige eriala - see on huvitav ja meeldib. 
