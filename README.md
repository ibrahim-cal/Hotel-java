# Hotel-java
Système de gestion de réservation chambres d'hotel avec design patterns DAO, Singleton et 
Fabrique).

Fonctionnalités  :
• CRUD (Create, Update, Read, Delete) des 2 tables CLIENT et RESERVATION. 
Les autres tables sont pré-remplies.

• Vérifier la validité des données entrées par l'utilisateur (uniquement des 
lettres pour les champs alphabétiques, uniquement des chiffres pour les 
champs numériques, dates valides..).

• Vérifier également la cohérence des données, à savoir que 2 clients ne 
peuvent pas réserver la même chambre à la même date, qu'il faut vérifier si le 
nombre de couchages de la chambre n'est pas inférieur au nombre de 
personnes de la réservation, qu'on ne doit pouvoir faire des réservations que 
pour les dates entrées dans Planning.

• Pouvoir filtrer les réservations sur le nom du client (en entrant juste le début 
du nom, ça doit fonctionner), le n° de chambre (liste déroulante), la date de 
réservation (avec une fourchette min-max).
