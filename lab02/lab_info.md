

## Laborator 2: Constructori și referințe


# Table of Contents
1. [Constructori](#Constructori)
2. [Referinte](#Referinte)
3. [Exemple de intrebari pentru test](#Exemple_de_intrebari_pentru_testul_de_data_viitoare)


# Constructori

- Intr-o clasa se pot defini metode, dar exista un tip special de metode care sunt folosite pentru a rezolva o anumita problema, aceea de a construi obiecte. Constructori sunt metode speciale datorita rolului lor si pentru ca au o multime reguli privind declararea si utilizare.

- De fiecare data cand este creat un obiect, este apelat un constructor. Pornind de la aceasta certitudine, în Java, fiecare clasa are cel putin un constructor , chiar daca programatorul nu a declarat în mod explicit unul. 

* Rolurile metodei constructor sunt:
	- **Rolul principal** – pentru a construi obiecte, in sensul de a aloca spatiu în Heap;
	- **Rol secundar** [optional] – pentru a initializa variabilele de instanta (atribute) cu valori default (amintiti-va, ca variabilele de instanta primesc valoarea implicita a tipului lor atunci cand obiectul este creat) sau cu valori date;

* Hai sa vedem un exemplu
``` java
public class Carte {
    float pret;
    String titlu;
    String autor;
 
    public static void main(String[] args) {
        //construieste un obiect de tip Carte
        Carte c1 = new Carte();
    }
}
```

- In metoda **main()** este construit un obiect de tip **Carte**, ce este gestionat de referinta **_c1_**.

- In aceasta situatie, unde este constructorul ? O regula în ceea ce priveste constructorii afirma ca, compilatorul va oferi un constructor implicit (unul cu zero argumente) **daca nu exista declarati in mod explicit alti constructori.** Forma constructorului implicit, generat de compilator, este:

``` java
 public Carte() { 
 }
```
- Deci daca in spate daca noi nu avem nici un constructor facut de noi compilatorul o sa puna unul facut de el si ar arata asa, chiar daca noi nu vedem asta: 
``` java
public class Carte {
    float pret;
    String titlu;
    String autor;
    
    /* 
    Accesta este drept exemplu, in realitate daca nu punem 
    nici un constructor nu o sa apara unul random, doar 
    complilatorul in spate il vede
    */
    public Carte() { 
    
    }
    
    public static void main(String[] args) {
    //construieste un obiect de tip Carte
        Carte c1 = new Carte();
    }
}
```
## Reguli pentru a declara si apela constructori in Java

-   constructorii au acelasi nume (case-sensitive), ca si clasa parinte;
    
-   constructori nu au un tip de return (este logic, deoarece vor intoarce intotdeauna o referinta catre obiectul construit); 
- **ATENTIE** pot fi definite metode cu acelasi nume ca si clasa, dar cu un tip de return care sunt metode comune si NU constructori: vezi mai jos

``` java
public class Carte {
    //NU este un constructor - are tip returnat
    public void Carte() {
        System.out.println("O metoda simpla fara logica !");
    }
    public static void main(String[] args) {
        //construieste un obiect de tip Carte cu constructorul default
        Carte b1 = new Carte();
        b1.Carte();	//apel metoda simpla - NU constructor
    }
}
```
-   constructori pot fi declarati public sau privat (specific pentru un Singleton – design pattern (aflam in alt laborator despre constructori privati).
    
-   constructori pot avea zero argumente (constructor implicit), unele argumente si liste variabile de argumente (var-args);

``` java
public class Carte() {

   //constructor fara argumente
    public Carte(){
        pret = 100;
        titlu = "Nimic";
    }
    
    //constructor cu 3 argumente
    public Carte(float Pret, String Titlu, String Autor){
        pret = Pret;
        titlu = Titlu;
        autor= Autor;
    }
    //constructor cu 2 argumente
    public Carte(String Titlu, String Autor){
        pret = 0;      //valoare default
        titlu = Titlu;
        autor= Autor;
    }
    
    //constructor cu numar variabil de argumente - var-args
    public Carte(float Pret, String ... nisteStrings){
        //procesare date
    }
}
```
-   constructorul implicit este unul cu zero-argumente;
-   daca nu se scrie **ORICE** tip de constructor, compilatorul va genera forma implicita;
    
-   daca se defineste cel putin un constructor (nu conteaza argumentele sale), compilatorul NU va genera forma implicita;
    
-   daca se defineste cel putin un constructor (cu parametri) si este nevoie de cel implicit, acesta trebuie definit in mod explicit; in caz contrar se obtine o eroare de compilare atunci cand aecsta este apelat deoarce atunci cand exista un constructor, compilatorul nu mai adauga constructorul fara nici un argument deci trebuie sa-l adaugam noi daca vrem sa-l folosim.

``` java
public class Carte {
    float pret;
    String titlu;
    String autor;
 
    //constructor cu 2 argumente 
    public Carte(String Titlu, String Autor){
        pret = 0;      //valoare default
        titlu = Titlu;
        autor = Autor;
    }
    public static void main(String[] args){
        //construieste o Carte
 
	//cannot find symbol : constructor Carte()
        Carte b1 = new Carte();  //eroare compilare
 
    }
}
```
- constructori NU poate fi **static** , **final** sau **abstract** ;
- **prima declaratie** intr-un constructor este un apel la un alt constructor folosind **this(),** sau pentru un constructor din superclasa (clasa de baza daca aceasta este o subclasa) folosind **super()** (mai mult pe acest subiect, in articolul despre mostenire); daca nu utilizati nici **this()** sau **super()** , compilatorul va face implicit apelul catre **super(),** pentur a intelege cine este **super()**, trebuie sa cunoasteti conceptul de mostenire (in articolele urmatoare din acest tutorial):

``` java
public class Carte {

    //constructor cu 2 argumente
    public Carte(String Titlu, String Autor){
	/generat de compilator daca nu este apelat explicit
	//super(); 
	//in acest exemplu apeleaza constructorul clasei Object
	//in Java, toate clasele sunt derivate implicit din Object
 
	pret = 0;      //valoare default
        titlu = Titlu;
        autor = Autor;
    }
 
    //constructor cu 3 argumente
    public Carte(float Pret, String Titlu, String Autor){
        //apel explicit al constructorului cu 2 argumente
        //TREBUIE sa fie prima instructiune
	//fara el, compilatorul apeleaza super();
	//se apeleaza Carte(titlu, autor);
	this(Titlu,Autor);
        pret = Pret;
    }
}
```
* un constructor este apelat cu operatorul **new** sau folosind **this()** intr-un alt constructor; nu este permis apelul constructorilor folosind sintaxa aferenta pentru orice alta metoda.

* Acum hai sa discutam pe urmatorul cod:
``` java
public class Carte {
    float pret;
    String titlu;
    String autor;
 
    public void Carte(){
        pret = 100;
        titlu = "Nimic";
        autor = "Anonim";
    }
 
    public Carte(String titlu, String autor){
        this();
        pret = 0;
        titlu = Titlu;
        autor = Autor;
    }
 
    public static void main(String[] args){
        Carte primaCarte = new Carte("Dune","Frank Herbert");
        Carte altaCarte = new Carte();
    }
 
}
```
* Ce probleme se gasesc in acest cod?
* Cum le putem rezolva?

# Referinte
- Obiectele se alocă pe `heap`. Pentru ca un obiect să poată fi folosit, este necesară cunoașterea adresei lui. Această adresă, așa cum știm din limbajul C, se reține într-un **pointer**.

- Limbajul Java nu permite lucrul direct cu pointeri, deoarece s-a considerat că această facilitate introduce o complexitate prea mare, de care programatorul poate fi scutit. Totuși, în Java există noțiunea de **referinţe** care înlocuiesc pointerii, oferind un mecanism de gestiune transparent.
- Managementul transparent al pointerilor implică un proces automat de alocare și eliberare a memoriei. Eliberarea automată poartă și numele de **Garbage Collection**, iar pentru Java există o componentă separată a JRE-ului care se ocupă cu eliberarea memoriei ce nu mai este utilizată.

## Cuvântul-cheie "this"
- Cuvântul cheie `this` se referă la instanța curentă a clasei și poate fi folosit de metodele, care nu sunt statice, ale unei clase pentru a referi obiectul curent. Apelurile de funcții membru din interiorul unei funcții aparținând aceleiași clase se fac direct prin nume. Apelul de funcții aparținând unui alt obiect se face prefixând apelul de funcție cu numele obiectului. Situația este aceeași pentru datele membru.

- Totuși, unele funcții pot trimite un parametru cu același nume ca și un câmp membru. În aceste situații, se folosește cuvântul cheie `this` pentru _dezambiguizare_, el prefixând denumirea câmpului când se dorește utilizarea acestuia. Acest lucru este necesar pentru că în Java este comportament default ca un nume de parametru să ascundă numele unui câmp.

- În general, cuvântul cheie `this` este utilizat pentru:

	-   a se face `diferenta` între câmpuri ale obiectului curent și argumente care au același nume
    
	-   a pasa ca `argument` unei metode o referință către obiectul curent
    
	-   a facilita apelarea `constructorilor` din alți constructori, evitându-se astfel replicarea unor bucăți de cod (vezi exemplul de la constructori)
- Exemplu: 
``` java
class Student {
 
    private String name;
    private int averageGrade;
    private Group group;
 
    public Student(Group group, String name, int averageGrade) {
        this.group        = group;
        this.name         = name;
        this.averageGrade = averageGrade;
    }
}
```

## Metoda toString()

- Cu ajutorul metodei toString(), care este deja implementată by default pentru fiecare clasă în Java, aceasta întorcând un string, putem obține o reprezentare a unui obiect ca string. În cazurile claselor implementate de utilizator, este de recomandat să implementăm (mai precis, să suprascriem - detalii despre suprascrierea metodelor în următoarele laboratoare) metoda toString() în clasele definite de către utilizator.

``` java
public class Student {
    private String name;
    private int averageGrade;
 
    public Student(String name, int averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }
 
    @Override
    public String toString() {
        return "Nume student: " + name + "\nMedia studentului: " + averageGrade;
    }
}
```

- Folosirea metodei:
``` java
Student st1 = new Student("Decebal Popescu", 5);
/*
nu este neaparat sa scriem st1.toString() la apelul metodei println,
println apeleaza in mod automat metoda toString in acest caz
*/
System.out.println(st1);
/*
se va afisa urmatorul string
 
Nume student: Decebal Popescu
Media studentului: 5
*/
```

# Exemple_de_intrebari_pentru_testul_de_data_viitoare

- Ce se intampla atunci cand nu avem nici un constructor generat de noi?
- Cine se ocupa de eliberarea memoriei in java?
- Ce tip de return are un constructor?
- Ce specificatori de acces poate avea un constructor?
- Ce reprezinta 'this'? 
- Ce reprezinta 'super'?

- BTW, POT SA VA PUN SI INTREBARI CAPCANA. xD 

# Bafta la rezolvarea laboratorului! xD


<img src="https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif" height="300" height="300" align="middle">






