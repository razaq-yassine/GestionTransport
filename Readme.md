# README
## _Gestion de transport_ by __RAZAQ YASSINE & TOUHAMA AHMED__

[![S|EMSI](https://cldup.com/dTxpPi9lDf.thumb.png)](https://github.com/razaq-yassine/GestionTransport/)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/razaq-yassine/GestionTransport/)
On souhaite créer une application java qui permet gérer une société de transport de cargaisons 
transportant des marchandises. La société gère un ensemble de cargaisons. Chaque cargaison 
contient plusieurs marchandises. Chaque marchandise est définie par son numéro, son poids et 
son volume. Il existe deux types de cargaisons : 
Routière et Aérienne. Chaque cargaison est définie par sa référence et sa distance de parcours. 
Le cout de transport d’une cargaison est calculé en fonction du type de la cargaison. 
Pour  une  cargaison  aérienne  est  une  cargaison  dont  le  cout  est  calculé  selon  la  formule 
suivante : 
- cout=10 x distance x poids total des marchandises si le volume total  est inférieur à 
80000 
-  cout=12 x distance x poids total des marchandises si le volume total est supérieur ou 
égal à 80000 


Une cargaison routière est une cargaison dont le cout est calculé selon la formule suivante : 
-  cout=4 x distance x poids total si le volume total est inférieur à 380000 
-  cout=6 x distance x poids total si le volume total est supérieur ou égale à 380000 


Pour  chaque  cargaison,  on  souhaite  ajouter  une  marchandise,  supprimer  une  marchandise, 
consulter  une  marchandise  sachant  son  numéro,  consulter  toutes  les  marchandises  de  la 
cargaison, consulter le poids total de la cargaison, consulter le volume total de la cargaison et 
consulter le cout de la cargaison. 
Cette application peut être utilisée par les clients et les administrateurs. 



## Features

- Se connecter
- Se deconecter
- Choisir le type de Base de donnees:
    - Base de données temporaire (RAM)
    - Base de données local
    - Base de données externe (Vous entrez votre chemin de Base de donnée)
- Interface client (consultation)
- Interface admin (consultation + gestion)
- Consulter tout les cargaisons et marchandises
- Consulter une seule cargaison ou une seule marchandise par id
- Ajout d'une cargaison ou d'un marchandise
- Modifier Cargaison ou marchandise
- Supression
- Ajout d'une marchandise dans une cargaison
- Donner le cout de cargaison selon le type et le poids total et le volume totale des marchandises dans la 




> If the world full of errors and warnings,
> Be with someone who can handle your exceptions

