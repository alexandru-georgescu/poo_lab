# Laborator 3: Agregare și moștenire

# Compunere_si_Agregare

## Compunere
- Prin compunere intelegem ca o clasa are un atribut pe care il
instantiaza ea cu operatorul *new*

``` java
public class Book {
	//Aici il instantiam
    private BookSet books = new BookSet();
}

```

## Agregare
- Prin agregare intelegem ca o clasa are un atribut pe care il
declara iar mai apoi o sa primeasca prin intermediul unui constructor sau a unei metode un obiect de tipul atributului.

``` java
public class Book {
	//Aici doar il declaram.
    private BookSet books;

    //Il instantiam prin intermediul unei metode / constructor.
    public void setBooks(BookSet books) {
    	this.books = books;
    }
}

```

## Diferenta
- In compunere noi suntem responsabil de initializarea obiectului in interiorul clasei pe cand in agregare o sa trimitem obiectl deja instantiat catre clasa respectiva.

## Exemplu compunere si agregare

``` java 
public class Book {
	//Exemplu de Agregare
	private String name;

	//Exemplu de Compunere
	private String author = "Mirel Bravo"

	//Alt exemplu de agregare.
	private Year year;

	//Instantierea atributului agregat.
	public Book(String name) {
		this.name = name;
	}

	public void setYear(Year year) {
		this.year = year;
	}
}

class Year {
	private int year;

	public int getYear() {
		return this.year;
	}
}


```

## Deci..


- Agregarea (aggregation) - obiectul-container poate exista și în absența obiectelor agregate de aceea este considerată o asociere slabă (weak association). În exemplul de mai sus, un raft de bibliotecă poate exista și fără cărți.
- Compunerea (composition) - este o agregare puternică (strong), indicând că existența unui obiect este dependentă de un alt obiect. La dispariția obiectelor conținute prin compunere, existența obiectului container încetează. În exemplul de mai sus, o carte nu poate exista fără pagini.

# Mostenire

- Sa spunem ca avem deja o clasa Caine care are mai multe metode
prin care putem sa aflam mai multe informatii despre acest caine iar apoi vrem sa construim o alta clasa de Caine care se focuseaza pe o anumita rasa de Caine, dar in mare parte aceleas metode ca in clasa Caine, ca sa nu dublicam codul putem sa extindem din clasa noului caine clasa Caine iar acesta poate sa foloseasca metodele deja existente in clasa parinte (Caine) si ulterior sa creeze metodele de care mai are nevoie

``` java
class Dog {
	private String name;
	private String age;

	public Dog(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " " + age;
	}
}


class Labrador extends Dog {
	private String type;

	//Dupa cum vedeti putem apela constructorul clasei parinte 
	//folosind super fara sa mai fie nevoie sa construim campurile name si age;
	public Labrador(String name, String age) {
		super(name, age);
	}

	//Putem apela si alte motode cu acelas nume din parinte folosind cuvantul super.
	@Override
	public String toString() {
		return super.toString();
	}
}
```

# Suprascrierea, supraîncărcarea si ascunderea metodelor statice

## Suprascrierea
- Suprascrierea (overriding) presupune înlocuirea funcționalității din clasa/clasele părinte pentru instanța curentă. Supraîncărcarea (overloading) presupune furnizarea de funcționalitate în plus, fie pentru metodele din clasa curentă, fie pentru clasa/clasele părinte. 

- Sa presupunem ca in clasa parinte avem o metoda cu numele *eat* dar in clasa copil vrem ca metoda *eat* sa faca total altceva, putem sa suprascriem metoda astfel in cat metoda sa faca fix ce vrem noi si nu ce face in metoda parinte.
 
``` java
class Kid {
	public void eat() {
		System.out.println("EAAAAT!");
	}
}


class Andrei extends Kid {

	//Suprascrierea metodei eat din parinte
	@Override
	public void eat() {
		System.out.prinln("BANANA");
	}
}
```

- In urmatorul caz, chiar daca metoda eat exista in parinte, se apeleaza metoda din copil deoarce noi am suprascris aveasta metoda, daca vrem sa apelam metoda din parinte putem sa apelam super.eat()

## Supraîncărcarea

- Supraîncărcarea este atunci cand avem o metoda cu acelas nume dar difera numarul de parametrii, de exemplu putem sa avem o metoda eat(String banana) si o alta metoda eat(String banana, String apple) sau putem avea o metoda cu acelas nume si acelas numar de parametrii dar difera tipul acestora;

``` java
public class Car {
    public void print() {
        System.out.println("Car");
    }
 
    public void init() {
        System.out.println("Car");
    }
 
    public void addGasoline() {
        // do something
    }
}

class Dacia extends Car {
    public void print() {
        System.out.println("Dacia");
    }
 
    public void init() {
        System.out.println("Dacia");
    }
 	
 	//Supraincarcarea metodei prin adaugarea unui nou parametru
    public void addGasoline(Integer gallons) {
        // do something
    }
 
 	//Supraincarcarea metodei prin schimbarea tipul metodei
    public void addGasoline(Double gallons) {
        // do something
    }
}
```
## Lucruri imporntante / utile



Relații între obiecte:

    Agregare - has a
    Moștenire - is a

Upcasting

    convertire copil ⇒ parinte
    realizată automat

Downcasting

    convertire parinte ⇒copil
    trebuie facută explicit de către programator
    încercați să evitați folosirea operatorului instanceof

Suprascrierea

    înlocuirea functionalitații metodei din clasa de bază în clasa derivată
    pastreaza numele și semnatura metodei

Supraincarcarea

    în interiorul clasei pot exista mai multe metode cu acelasi nume, cu condiția ca semnătura (tipul, argumentele) să fie diferită

super

    instanța clasei parinte
    amintiți-vă din laboratorul anterior că this se referă la instanța clasei curente






