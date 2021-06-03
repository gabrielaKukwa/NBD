object NBD_2 {
  def main(args: Array[String]) {
    //1
    println()
    println("******************* 1 ********************")
    println(matchDay("Poniedziałek"))
    println(matchDay("kkkk"))
    println(matchDay("sobota"))

    //2
    println()
    println("******************* 2 ********************")
    val account1 = new BankAccount(100.00)
    val account2 = new BankAccount(300.00)
    println("Początek account1: " +account1.sprawdz)
    account1.wplata(30.00)
    println("Operacja wplata 30.00 account1: " +account1.sprawdz)
    account1.wyplata(50.00)
    println("Operacja wyplata 50.00 account1: " +account1.sprawdz)
    println("Koniec account1: " +account1.sprawdz)
    println()
    println("Początek account2: " +account2.sprawdz)
    account2.wplata(500.0)
    println("Operacja wplata 500.00 account2: " +account2.sprawdz)
    account2.wplata(250.0)
    println("Operacja wplata 250.00 account2: " +account2.sprawdz)
    account2.wyplata(400.0)
    println("Operacja wyplata 400.00 account2: " +account2.sprawdz)
    println("Koniec account2: " +account2.sprawdz)

    //3
    println()
    println("******************* 3 ********************")
    val os1 = Osoba("Gabi", "Abc")
    val os2 = Osoba("Ola", "Ghi")
    val os3 = Osoba("Oliwia", "Jkl")
    hello(os1)
    hello(os2)
    hello(os3)

    //4
    println()
    println("******************* 4 ********************")
    println(doThreeTimes(intFunction,5))

    //5
    println()
    println("******************* 5 ********************")
    val student = new Osobaa("aaa","bbb") with Student
    val pracownik = new Osobaa("ccc","ddd") with Pracownik
    pracownik.pensja = 5000.0
    val nauczyciel = new Osobaa("eee","fff") with Nauczyciel
    nauczyciel.pensja = 3000.0
    val student_pracownik = new Osobaa("ggg","hhh") with Student with Pracownik
    student_pracownik.pensja = 1000.0
    val pracownik_student = new Osobaa("iii","jjj") with Pracownik with Student
    pracownik_student.pensja = 1000.0

    println("Podatek studenta: "+ student.tax)
    println("Podatek pracownika, który zarabia "+ pracownik.pensja+ ", wynosi: "+pracownik.tax)
    println("Podatek nauczyciela, który zarabia "+ nauczyciel.pensja+ ", wynosi: "+nauczyciel.tax)
    println("Podatek student-pracownik, który zarabia "+student_pracownik.pensja+ ", wynosi: "+student_pracownik.tax)
    println("Podatek pracownik-student, który zarabia "+pracownik_student.pensja+ ", wynosi: "+pracownik_student.tax)


  }


  //1
  def matchDay(x: String): String = x match {
    case "Poniedziałek"|"poniedziałek"|"Wtorek"|"wtorek"|"Sroda"|"środa"|"Czwartek"|"czwartek"|"Piątek"|"piątek" => "PRACA"
    case "Sobota"|"sobota"|"Niedziela"|"niedziela" => "WEEKEND"
    case _ => "Nie ma takiego dnia"
  }

  //2
  class BankAccount{

    private var stanKonta: Double = 0.0

    def this(kontoInit: Double){
      this()
      this.stanKonta = kontoInit
    }

    def sprawdz: Double = stanKonta

    def wplata(dodaj: Double): Unit ={
      stanKonta = stanKonta + dodaj
    }

    def wyplata(odejmij: Double): Unit ={
      stanKonta = stanKonta - odejmij
    }

  }


  //3
  case class Osoba(imie: String, nazwisko: String)

  def hello (osoba: Osoba): Unit ={
    osoba match {
      case Osoba("Gabi", x) => println("Good morning Gabi !")
      case Osoba(x,"Ghi") => println("Nice to see you Ola !")
      case _ => println("Hello unknown !")
    }
  }

  //4
  def intFunction(x: Int): Int ={
    x+100
  }

  def doThreeTimes(fun: Int => Int, x: Int): Int= {
    fun(fun(fun(x)))
  }

  //5
  abstract class Osobaa(imie: String, nazwisko: String){
    def tax: Double
  }

  trait Student extends Osobaa{
    override def tax: Double = 0
  }

  trait Pracownik extends Osobaa{
    override def tax: Double = pensja *0.2
    var pensja = 0.0
  }

  trait Nauczyciel extends Pracownik{
    override def tax:Double = pensja *0.1
  }
}
