var unitConsumed : Int = 100

unitConsumed = 200

//val rate : Double = 0.1

//var bill = unitConsumed * rate
/*
val rateBelow100 = 0.1
val rateBelow500 = 0.2
val rateAbove500 = 0.3

val bill = if (rateBelow100 <= 100) {
  unitConsumed * rateBelow100
} else if (rateBelow500 > 100 && rateBelow500 <= 500) {
  unitConsumed * rateBelow500
} else {
  unitConsumed * rateAbove500
}

 */
// *************** FUNCTIONS STARTS HERE ***************
//def calculateBill(unit: Int, perUnitRate : Double ) : Double = {
//  return unit * perUnitRate
//}

//def calculateBill(unit: Int, ratePerUnit : Double ) : Double = unit * ratePerUnit
//def calculateBill(unit: Int, ratePerUnit : Double ) = unit * ratePerUnit

def calculateBill(unit: Int, ratePerUnit : Double = 0.1) : Double = unit * ratePerUnit

def displayBill(bill : Double): Unit = {
  println("Your electricity bill is " + bill)
}

// *************** FUNCTIONS END HERE ***************


// another better options is to use switch case
val rate = unitConsumed match {
  case x if 0 to 100 contains x => 0.1
  case x if 101 to 500 contains x => 0.2
  case _ => 0.3
}

//val bill = unitConsumed * rate

var myBill = calculateBill(unitConsumed)

myBill = calculateBill(unitConsumed, rate)

displayBill(myBill)

displayBill(calculateBill(unitConsumed, rate))
