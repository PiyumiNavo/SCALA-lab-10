@main def main(): Unit = {
  val a1 = new Account("1234567890")
  val a2 = new Account("0987654321")

  val b = new Bank()
  b.addAccount(a1)
  b.addAccount(a2)

  a1.Deposit(-1000)
  a2.Deposit(500)

  b.findNegativeBalances()
  b.getSumOfAccBalances()
  b.applyInterest()

//   a1.Deposit(1000)
//   a2.Deposit(500)

//   a1.Transfer(500, a2)
//   a1.Withdraw(200)
//   a2.Withdraw(1000)

}

class Account(val accountNumber: String) {
  var balance: Double = 0.0

  def Deposit(amount: Double): Unit = {
    this.balance += amount
    println(s"Amount deposited : $amount")
  }

  def Withdraw(amount: Double): Unit = {
    if (this.balance < amount) {
      println("Insufficient balance")
    } else {
      this.balance -= amount
      println(s"Amount withdrawn : $amount")
    }
  }

  def Transfer(amount: Double, that: Account): Unit = {
    if (this.balance < amount) {
      println("Insufficient balance")
    } else {
      this.balance -= amount
      that.balance += amount
      println(
        s"Amount transferred : $amount\nAccount : ${that.accountNumber} "
      )
    }
  }
}

class Bank {
  private var accounts: List[Account] = List()

  def addAccount(account: Account): Unit = {
    accounts = accounts :+ account
    println(s"Account added successfully")
  }

  def findNegativeBalances(): Unit = {
    println("- Accounts with negative balances -")
    (accounts
      .filter(_.balance < 0))
      .map((account) => {
        println(s"Account : ${account.accountNumber}")
      })
  }

  def getSumOfAccBalances(): Unit = {
    var sum: Double = 0.0
    println("- Sum of all account balances - ")
    accounts.map((account) => {
      sum += account.balance
    })
    println(s"Sum of all account balances : ${sum}")
  }

  def applyInterest(): Unit = {
    accounts.map((account) => {
      if (account.balance > 0) {
        // set deposit interest to 0.05
        val interest = account.balance * 0.05
        account.balance += interest
        println(
          s"Interest of $interest applied to account ${account.accountNumber}"
        )
      } else if (account.balance < 0) {
        // set overdraft interest to 0.1
        val interest = account.balance * 0.1
        account.balance += interest
        println(
          s"Overdraft interest of $interest applied to account ${account.accountNumber}"
        )
      }
    })
  }
}
