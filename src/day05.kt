import java.util.*

// https://adventofcode.com/2018/day/5
fun main(args: Array<String>) {
	day5a()
	day5b()
}

// Goal: Remove all pairs of an uppercase and lowercase of the same letter, until no more occurrences.
// Approach: Go through input, adding to stack. If would ever add 2nd half of a pair, remove both.
fun day5a() {
	val input = parseFileAsString("resources/input05.txt")

	println("The result has ${getLengthAfterRemovingLetters(input)} units")
}

fun getLengthAfterRemovingLetters(input:String) : Int {
	val stack = Stack<Char>()
	input.forEach { letter ->
		val topOfStack = if (stack.isEmpty()) '_' else stack.peek()
		// Check if next char is same letter, bit different case
		if (topOfStack != letter && topOfStack.equals(letter, ignoreCase = true)) {
			stack.pop()
		} else {
			stack.push(letter)
		}
	}
	return stack.size
}

// Goal: Find which letter to remove to produce shortest possible result.
// Approach: Try all 26 letters, keep smallest result.
fun day5b() {
	val input = parseFileAsString("resources/input05.txt")
	var smallestResult = Int.MAX_VALUE

	for (letter in 'a'..'z') {
		val input2 = input.replace(letter.toString().toRegex(RegexOption.IGNORE_CASE), "")
		val result = getLengthAfterRemovingLetters(input2)
		if (result < smallestResult) {
			smallestResult = result
		}
	}

	println("The smallest result has ${smallestResult} units")
}
