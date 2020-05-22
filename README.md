# CheapFlightBackEnd

Egy egyszerű szerver, ami csak adatokat szolgáltat a React-ban írodott front end számára.

Első körben saját adatbázist generálok, melyből a front end képes lesz adatokat lehívni.

De a terv az, hogy amikor a front end működik, akkor Selenium segítségével, valós járatokat keressen és valós adatokkal lássa el a React-os front endet.
 
A terv sikerült, most már jelenleg 5 beégetett város (Budapest, Berlin, London, Párizs és Madrid) közötti légiforgalmat valós adatok szolgáltatásával tudjuk biztosítani a front-end számára, hiszen selenium segítségével a front-end-ről érkező paraméterek alapján a www.cheapoair.com oldalról valós adatokat tud letölteni a back-end és ezeket tudja visszaadni a front-end számára.

A továbbiakban szeretném megoldani, hogy párhuzamosan több szálon több légitársaság oldaláról tudjak valós adatokat letölteni.
