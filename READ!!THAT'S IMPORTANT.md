# Java

Laboratorul 1:
Bonus:
-> pt partea bonus am facut functia connectedGraph care calculeaza numarul de componente conexe din graf. 
Se foloseste de un vector visited pentru a marca nodurile vizitate si de o stiva pe care punem nodurile. 
Cat timp avem noduri pe varful stivei, le luam si cautam noduri adiacente nevizitate si eventual le punem pe stiva 
si le marcam cu numarul componentei conexe din care fac parte. Daca la final graful are o singura componenta conexa, 
inseamna ca este conex.

Laboratorul 7:
-Am pasii explicati pe cod

Laboratorul 6:
MainFrame:pozitionam cele 3 cntrpenel, canvas,configpanel in pozitiile respective
folosim o noua clasa pentru ConfigPanel
pentru inceput am selectat numarul de noduri si am setat nr ca default iar apoi cele doua posibilitati de shape-uri le am pus in stringul colors
Pt ControlPanel avem o alta clasa creand cele 4 butoane necesare le am adaugat si le am atribuit actiune iar mai jos am codat cele 4 actiuni
cea de save salveaza desenul sub dforma de poza, load ul o incarca cea de reset reseteaza tabla iar exitul iese din aplicatie
Pt drawingPanel avem o alta clasa
Mi am setat in W si H lungimea si latimea aplicatiei, de asemenea mi am setat si culoarea.
apoi am generat un nr random in drawshape, am luat numarul de lanturi, iar daca culoarea era cea potricitageneram o culoare random
clear este cea pe care am folosit o pt reset.


Lab 5:
Clasa Document are proprietatile id, name location unde location reprezinta path ul in sistem. Am afacut override la equals pentru a putea compara doua "documente", ovverride la toString pt a putea afisa informatiile despre obiect.
Pt catalog care are proprietatile name, path(ce reprezinta path ul in sistem) si documents care este o lista cu documente obiecte ale clasei document.Metoda findByld imi returneaza un doc din cataloc care are un anumit id.
CatalogUtil cu metodele Save care primeste ca parametru un obiect Catalog pe care il serializeaza si il salveaza in path in sistem.Metoda load primeste un path si incarca obiectul de path-ul respectiv si il deserializeaza si afiseaza mesaj daca a fost gasit si deserializat cu succes. Metoda view care primeste ca parametru documentul si il deschide pe desktop. 




