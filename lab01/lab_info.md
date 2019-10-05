
## Laborator 1

# Table of Contents
1. [Clase](#Clase)
2. [Cum se defineste o clasa in Java](#Cum_se_defineste_o_clasa_in_Java)
3. [Cum se construiesc obiecte](#Cum_se_construiesc_obiecte)
4. [Cum se acceseaza atributele si metodele](#Cum_se_acceseaza_atributele_si_metodele)
4. [Lab 01 rezolvat](#Lab_01_rezolvat)
5. [Exemple de intrebari pentru primul test(#Exemple_de intrebari_pentru_primul_test)



## Inainte de toate cam asa a fost primul lab :))

<img src="
https://media.giphy.com/media/l0ErAnVeA8XTIj1VC/giphy.gif" height="300" height="300" align="middle">


## Dar acum hai sa incepem
<img src="https://media.giphy.com/media/NylYRvfyaIwtW/giphy.gif" height="300" height="300" align="middle">

# Clase

- Clasele reprezinta principiile de baza ale programarii orientate obiect. Clasele reprezinta notiuni abstracte, povesti, modele (blueprints), ce descriu: 
	* caracteristicile, atributele unui obiect; reprezinta ceea ce stie sau ce este obiectul;
	* ce stie sa faca obiectul, comportamentul acestuia descris de metodele sale;

- Pe baza claselor,programatorul poate defini ceva concret, obiecte. Astfel, prin instantierea clasei (atributele definite in clasa, sunt initializate cu valori) se obtin variabile de tip obiect. Pentru cei care au cunostinte de C, o clasa este asemenea unei structuri, definita prin _struct_, in care poti defini si metode.

# Cum_se_defineste_o_clasa_in_Java

``` java
[modificator_acces] class nume_clasa [extends base_class]
[implements interface1, interface2, …] {
/* 
Poate sa contina: 
	atribute
	metode
	alte clase
*/
}
```

**modificator acces** – descrie drepturile de utilizare a acestei clase dintr-un program Java; acest atribut este optional, avand ca valoare default, private; desi este dedicat un alt post doar pentru a intelege modificatorii de acces, acum retinem valorile posibile:

-   public – in termeni de securitate, clasa poate fi folosita oriunde in programul Java;
-   protected
-   private

**class** – cuvant cheie in Java ce defineste aceasta structura

**nume clasa** – numele clasei definit de programator; numele clasei trebuie sa respecte aceleasi conventii de nume ca si orice variabila (post variabile)

**extends** – permite derivarea dintr-o clasa de baza (mai multe in tutorialul despre derivare/mostenire)

**implements** – permite derivarea din una sau mai multe interfete (mai multe in tutorialul despre interfete)

La modul cel mai simplu, sintaxa necesara definirii unei clase este:
``` java
class nume_clasa {
	public nume_clasa() {
		System.out.prinln("Aici intra cand apelezi
			nume_clasa obj1 = new nume_clasa();");
	}
	
	public nume_clasa(String nume) {
		System.out.prinln("Aici intra cand apelezi
			String nume = "Alex";
			nume_clasa obj1 = new nume_clasa(nume);");
	}

	public metoda(**Putem sa avem si parametrii**) {
		System.out.println("Aici intra atunci cand avem
			nume_clasa obj1 = new nume_clasa();
			obj1.metoda();");
		
	}
}
```

In ceea ce priveste atributele definite in clasa acestea pot reprezenta:

-   variabile de instanta sau atribute ale obiectelor
    
-   variabile statice – un fel de variabile globale
    

In ceea ce priveste metodele (functiile) definite in clasa acestea sunt:

-   functii constructor;
    
-   functii accesor (get-eri si set-eri)
    
-   metode de prelucrare
    

Legat de modul de declarare a atributelor si a metodelor nu exista reguli cu privire la modul in care acestea trebuie definite, insa o gestiune mai usoara a codului se face daca atributele sunt definite grupat.

#### La definirea de clase se tine cont de:

1.  intr-un fisier Java, _.java_, pot fi definite mai multe clase;
2.  intr-un fisier Java, doar o clasa poate fi definita publica;
3.  fisierul sursa Java care contine clasa publica se are acelasi nume ca si clasa (la nivel case sensitive); clasa publica _Carte_ se gaseste in Carte.java ;
4.  blocul unei clase este definit de { si } ;
5.  daca intr-un fisier sursa .java sunt definite mai multe clase, atunci prin compilarea fisierului se obtine bytecode, fisiere _.class_, pentru fiecare clasa.

Pe baza sintaxei simple, se defineste o clasa simpla Java ce descrie o carte. Cartea este descrisa de atributele _pret, titlu_ si _autor_, iar comportamentul este definit de metodele _getPret()_ si _afiseaza()._

``` java
class Carte{
    //definire atribute - variabile pentru instante
    float pret;
    String titlu;
    String autor;
 
    //definire metode
    public float getPret(){
        return pret;
    }
    public String afiseaza(){
        return "Cartea " + titlu + " are ca autor " + autor;
    }
}
```

# Cum_se_construiesc_obiecte

Daca clasa reprezinta ceva abstract, obiectele reprezinta ceva concret. Obiectele reprezinta instante ale clasei deoarece prin construirea unui obiect povestea din spatele clasei devine ceva concret: un spatiu de memorie in Heap in care atributele au valori.

Obiectele sunt construite prin operatorul _new_ care va apela functia constructor din clasa (cu sau fara parametrii):

Pentru a testa clasa _Carte_ definita mai devreme vom construi o noua clasa publica, _TestCarte_ (fisierul Java se numeste tot TestCarte.java):

``` java
public class TestCarte {
    public static void main(String[] args) {
	//definire referinta
	Carte carte1;	//are valoarea null
	Carte carte2 = null;
	//creare obiect
        carte1 = new Carte();
	carte2 = new Carte();
    }
}
```
Obiectul ca si variabila reprezinta o referinta (pointer) ce gestioneaza o adresa din Heap. Prin intermediul acestei adrese avem acces la zona de memorie rezervata pentru obiect in care se gasesc valorile atributelor sale.

Prin definirea unui obiect se obtine o simpla referinta care are valoarea implicita _null_. Pentru a da valoare acestei referinte se construieste (instantiaza) obiectul prin _new_.

# Cum_se_acceseaza_atributele_si_metodele

Obiectul are acces la atributele si metodele sale (care nu sunt statice) prin intermediul operatorului . (punct).

``` java
public class TestCarte {
    public static void main(String[] args) {
        Carte carte1 = new Carte();
	carte1.pret = 23;
        carte1.titlu = "Dune";
        carte1.autor = "Frank Herbert";
        System.out.println(carte.afiseaza());
        Carte carte2 = new Carte();
	carte2.pret = 35;
        carte2.titlu = "Harry Potter";
        carte2.autor = "J.K. Rowling";
        System.out.println(carte.afiseaza());
    }
}
```
Accesul la metodele si atributele obiectului din afara clasei, cum se vede in exemplul anterior in care obiectul carte este folosit in clasa TestCarte, poate fi controlat prin modificatorii de acces (public, private, protected vor fi analizati in detaliu in alt post).

# Lab_01_rezolvat

* Task 1: 
	1.  Creați folosind IDE-ul un nou proiect și adăugați codul din secțiunea [Exemplu de implementare](http://elf.cs.pub.ro/poo/laboratoare/java-basics#exemplu-de-implementare "laboratoare:java-basics"). Rulați codul din IDE.
    
	2.  Folosind linia de comandă, compilați și rulați codul din exemplu
    
	3.  Mutați codul într-un pachet _task1_ (sau alt nume pe care il doriți să îl folosiți). Folosiți-vă de IDE, de exemplu Refactor → Move pentru IntelliJ. Observați ce s-a schimbat în fiecare fișier mutat.

	* Copy paste din lab, asta era mai mult pentru a intelege IDE-ul

* Task 2: 
	Creați un pachet _task2_ (sau alt nume pe care îl doriți să îl folosiți). În el creați clasele:

	-   `Student` cu proprietățile: _name_ (String), _year_ (Integer)
    
	-   `Course`
    
	    -   cu proprietățile: _title_ (String), _description_ (String), _students_ (array de clase Student - [exemplu arrays](http://elf.cs.pub.ro/poo/laboratoare/java-basics#arrays "laboratoare:java-basics")).
        
	    -   cu metoda: _filterYear_ care întoarce o listă de studenți care sunt intr-un an dat ca parametru.
        
	-   Nu folosiți vreun modificator de acces pentru variabile (aka “nu puneți nimic în fața lor în afară de tip”)
    
	-   `Test` cu metoda main. La rulare, ca [argument](https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html "https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html") în linia de comandă se va da un integer reprezentând anul în care este un student
    
	    1.  creați un obiect _Course_ și 3-4 obiecte _Student_. Populați obiectul Course.
        
	    2.  afișați toți studenții din anul dat ca parametru. **Hint:** folositi `Arrays.toString(listStudenti)`. In clasa Student folositi IDE-ul pentru a genera metoda toString (pt Intellij Code→Generate…)
        
	    3.  rulați atât din IDE (modificati run configuration) cât și din linie de comandă
        
	-   Opțional, în loc de [arrays](http://elf.cs.pub.ro/poo/laboratoare/java-basics#arrays "laboratoare:java-basics") pentru _filterYear_ puteți să folosiți și obiecte de tip List, e.g. [ArrayList](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/ArrayList.html "https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/ArrayList.html") ([exemplu](https://www.w3schools.com/java/java_arraylist.asp "https://www.w3schools.com/java/java_arraylist.asp"))

``` java
	class Student {
		String name;
		int year;

		//Creeaza un String cu numele si anul studentului.
		public String toString() {
			return name + " " + year;
		}
	}

	class Course {
		String title;
		String description;
		ArrayList<Student> students;

		public List<Student> filterYear(int year) {
			//Java 8, putem sa discutam in tipul laboratorului ce face aceasta metoda.
			return students.stream().filter(student -> student.year == year).collect(Collectors.toList()); 
		}

		public addStudents(List<Student> students) {
			this.students = students;
		}
	}

	class Test {
		public static void main (String[] args) {
			//args[0] = numele executabilului
			//args[1] = primul parametru
			//args[i] = parametrul i, i != 0.

			List<Student> students = new ArrayList<Student>();
			Course course = new Course();
			Student stud0 = new Student();
			stud0.name = "Mirel";
			stud0.year = 1998;

			Student stud1 = new Student();
			stud1.name = "Ana";
			stud1.year = 1999;
			
			Student stud2 = new Student();
			stud2.name = "Andreea";
			stud2.year = 2000;
			
			Student stud3 = new Student();
			stud3.name = "Alex";
			stud3.year = 2001;
			
			Student stud4 = new Student();
			stud4.name = "Marcel";
			stud4.year = 2002;

			students.add(stud0);
			students.add(stud1);
			students.add(stud2);
			students.add(stud3);
			students.add(stud4);

			course.addStudents(students);
			System.out.println("Studenti din anul 1998: "
					+ course.filterYear(1998));
		}
	}
```
* Task 3:
	1.  Creați două obiecte _Student_ cu aceleași date în ele. Afișați rezultatul folosirii _equals()_ între ele. Discutați cu asistentul despre ce observați și pentru a vă explica mai multe despre această metodă.
    
    -   [documentație](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object) "https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)")

``` java
	class Test {
		public static void main (String[] args) {
			//args[0] = numele executabilului
			//args[1] = primul parametru
			//args[i] = parametrul i, i != 0.
			Student stud1 = new Student();
			stud1.name = "Andrei";

			Student stud2 = new Student();
			stud2.name = "Andrei";

			//O sa intoarca true deoarce compara stringul si nu referinta
			System.out.println(stud1.name.equals(stud2.name));
			
			//O sa intoarca false deoarce compara referinta iar fiecare string de acolo au adrese de memorie diferite.
			System.out.println(stud1.name == stud2.name);
		
		}
	}
```
* Task 4:
	1.  Adăugați modificatorul de acces 'private' tuturor variabilelor claselor Student și Course (e.g. `private String name;`)
    
	2.  Rezolvați erorile de compilare adăugând metode getter și setter acestor variabile.
    
	3.  Ce ați făcut acum se numește _încapsulare (encapsulation)_ și este unul din principiile de bază din programarea orientată pe obiecte. Prin această restricționare protejați accesarea și modificarea variabilelor.
        
        -   _Hint_: pentru a vă eficientiza timpul, folosiți IDE-ul pentru a generarea aceste metode
            
            -   Eclipse: Source → Generate Getters and Setters
                
            -   IntelliJ: Code → Generate… → Getters and Setters


``` java
	//Se metodele setName, getName etc.. se pot genera direct din ide, va arat la lab daca aveti curiozitati.
	//Exemplu pentru clasa Student:
	class Student {
		private String name;
		private int year;

		//Seteaza un nume
		public void setName(String name) {
			this.name = name;
		}

		//Returneaza numele
		public String getName() {
			return this.name;
		}

		//Seteaza un an
		public void setYear(int year) {
			this.year = year;
		}

		//Returneaza anul
		public int getYear() {
			return this.year;
		}
		
		//Creeaza un String cu numele si anul studentului.
		public String toString() {
			return name + " " + year;
		}
	}
	

```

# Exemple de intrebari pentru primul test

- Ce reprezinta o clasa in java?
- Ce poate sa contina o clasa in java?
- Cand iesim la bere?
- Ce intelegeti prin limbaj oop?


## Va urez un weekend placut si plin de **bautura** xD!

<img src="https://media.giphy.com/media/10hO3rDNqqg2Xe/giphy.gif" height="300" height="300" align="middle">








