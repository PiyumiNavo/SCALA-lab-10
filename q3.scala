@main def main(): Unit = println(
  "Total count of letter occurences: " +
    countLetterOccurrences(List("apple", "banana", "cherry", "date"))
)

def countLetterOccurrences(words: List[String]): Int = {
  val lengths = words.map(word => word.length)

  val count = lengths.reduce((a, b) => a + b)
  count
}
