import scala.annotation.tailrec

object NBD_1 {
  def main(args: Array[String]) {

    //printL(week)

    //1
    println("******************* 1 ********************")
    val week = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    printWeekFor(week) //a
    printPWeekday(week) //b
    printWeekWhile(week) //c

    //2
    println()
    println("******************* 2 ********************")
    println(printListRecursive(week)) //a
    println(printListRecursiveBack(week)) //b

    //3
    println()
    println("******************* 3 ********************")
    println(printTailRecursive(week))

    //4
    println()
    println("******************* 4 ********************")
    foldLeeft(week) //a
    foldRightt(week) //b
    foldLeeftP(week) //c

    //5
    println()
    println("******************* 5 ********************")
    val products: Map[String, Double] = Map("water" -> 1.50, "tea" -> 15)
    val cheaperProducts = products.mapValues(_ * 0.9)

    cheaperProducts.keys.foreach { i =>
      print("Key = " + i)
      println(" Value = " + cheaperProducts(i))
    }

    //6
    println()
    println("******************* 6 ********************")
    val bar = ("Snickers", 6, true)
    val chocolate = ("Milka orzechowa", 1, false)
    printTuple(bar)
    println()
    printTuple(chocolate)

    //7
    println()
    println("******************* 7 ********************")
    val p1 = "tea"
    println("Price of " + p1 + ": " + checkPrice(products.get(p1)))

    //8
    println()
    println("******************* 8 ********************")
    val withZero = List(1, 2, 3, 4, 5, 6, 0, 7, 8, 9, 10, 0, 11, 12, 13, 0, 0, 90, 8, 0, 7)
    println(removeZero(withZero))

    //9
    println()
    println("******************* 9 ********************")
    println(addOne(withZero))

    //10
    println()
    println("******************* 10 *******************")
    val floatList = List[Float](1.1234F, 2.54F, 5.66F, 13.54F, 12F, 7.80F, -4.982F, -5.87F, -8.987F, -12.098F)
    println(filterNums(floatList))

  }

  //1a
  def printWeekFor (weekList : List[String]) {
    var outString = ""

    for(i <- 0 to weekList.size-1) {
      if(i==0){
        outString = weekList(i)
      }else {
        outString = outString + ", " + weekList(i)
      }
    }
    println(outString)
  }

  //1b
  def printPWeekday(weekList : List[String]): Unit = {
    var outString = ""
    for(i <- 0 to weekList.size-1) {
      if(weekList(i).charAt(0)=='P'){
        if(outString == ""){
          outString = weekList(i)
        }else{
          outString = outString + ", " + weekList(i)
        }
      }
    }
    println(outString)
  }

  //1c
  def printWeekWhile (weekList : List[String]){
    var outString = ""
    var i = 0
    while(i < weekList.length) {
      if(i == 0){
        outString = weekList(i)
        i+= 1
      }else {
        outString = outString + ", " + weekList(i)
        i+= 1
      }
    }
    println(outString)
  }

  //2a
  def printListRecursive(weekList : List[String]) : String = {
    if (weekList.nonEmpty && weekList.size == 1){
      weekList.head
    }else  {
      weekList.head + ", " + printListRecursive(weekList.tail)
    }
  }

  //2b
  def printListRecursiveBack(weekList : List[String]): String = {
    if (weekList.head == weekList.head && weekList.size == 1 ) {
      weekList.head
    }else{
      weekList.last+", "+printListRecursiveBack(weekList.take(weekList.length-1))
    }
  }


  //3
  def printTailRecursive(weekList : List[String]): String = {
    @tailrec
    def iter(x: List[String], y: String): String = {
      if(x.size <= 1) {
        y + x.head
      }
      else {
        iter(x.tail, y + x.head + ", ")
      }
    }
    iter(weekList,"")
  }

  //4a
  def foldLeeft(weekList : List[String]) {
    var outFold = weekList.foldLeft("")((a, b) => a + b + ", ")
    outFold = outFold.substring(0, outFold.length-2)
    println(outFold)
  }

  //4b
  def foldRightt(weekList : List[String]) {
    var outFold = weekList.foldRight("")((a, b) => a +  ", " + b)
    outFold = outFold.substring(0, outFold.length-2)
    println(outFold)
  }

  //4c
  def foldLeeftP(weekList : List[String]) {
    var outFold = weekList.filter(_.charAt(0) == 'P').foldLeft("")((a, b) => a + b + ", ")
    outFold = outFold.substring(0, outFold.length-2)
    println(outFold)
  }

  //6
  def printTuple(tup:Tuple3[String, Int, Boolean]): Unit = {
    tup.productIterator.foreach(println)
  }

  //7
  def checkPrice(x: Option[Double]) = x match {
    case Some(s) => s
    case None => "No product on the list"
  }

  //8
  def removeZero (list :List[Int]): List[Int] ={
    if(!list.isEmpty && list.size >0){
      if(list.head != 0){
        return list.head :: removeZero(list.tail)
      }
      removeZero(list.tail)
    }else{
      list
    }
  }

  //9
  def addOne(list :List[Int]): List[Int] = {
    val addedOne = list.map(_+1)
    addedOne
  }

  //10
  def filterNums(list :List[Float]): List[Float] = {
    var filteredNums = list.filter(_ >= -5)
    filteredNums = filteredNums.filter(_ <= 12)
    filteredNums = filteredNums map math.abs
    filteredNums
  }
}
