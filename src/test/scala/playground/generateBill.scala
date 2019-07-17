package playground

class generateBill(units : Int) {

  val rate = units match {
    case x if 0 to 100 contains x => 0.1
    case x if 101 to 500 contains x => 0.2
    case _ => 0.3
  }

  def calculateBill(rate : Double = 0.1) = units * rate

  def displayBill(billAmount : Double ): Unit = {
//    println("Your electricity bill is " + billAmount)

    // s String Interpolation
    println(s"Your electricity bill is ${billAmount}")

    // f String Interpolation
    println(f"Your electricity bill is $billAmount%.2f")

    // raw STring interpolate
    println(raw"Your Electricity bill is: \t" + billAmount)
  }



  object Main {

    def main(args: Array[String]): Unit = {
      var bill = new generateBill(200)
      bill.displayBill(bill.calculateBill())
    }


  }


}
