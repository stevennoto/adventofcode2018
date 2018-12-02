import java.io.File

// https://adventofcode.com/2018/day/2
fun main(args: Array<String>) {
	day2a()
	day2b()
}

// Goal: Multiply num words with a letter which appears twice by num words with a letter which appears thrice
// Approach: Go through input, using Kotlin grouping functions to quickly check char counts, then multiply at end
fun day2a() {
	val input = parseFileAsList("resources/input02.txt")
	var wordsWith2xLetter = 0
	var wordsWith3xLetter = 0
	input.forEach { word ->
		val charCounts = word.groupingBy { it }.eachCount()
		if (charCounts.containsValue(2)) wordsWith2xLetter++
		if (charCounts.containsValue(3)) wordsWith3xLetter++
	}

	val result = wordsWith2xLetter * wordsWith3xLetter
	println("The result is $result")
}

// Goal: Find two words that differ by a single character
// Approach: For each input, check it against all prior input, looking for 1-letter difference.
fun day2b() {
	val input = parseFileAsList("resources/input02.txt")
	val seen:MutableList<String> = mutableListOf()
	input.forEach {word ->
		seen.forEach { seenWord ->
			val index = indexOfSingleCharacterDifference(word, seenWord)
			if (index != -1) {
				println("The matching words are $word and $seenWord and the comment letters are "
						+ word.removeRange(index, index + 1))
				return
			}
		}
		seen.add(word)
	}
}

// Find the single character different between two Strings, else -1
// Note: assumes same length, based on puzzle input
fun indexOfSingleCharacterDifference(word1:String, word2:String) : Int {
	var indexOfDifference = -1
	word1.forEachIndexed { index, c ->
		if (c != word2[index]) {
			if (indexOfDifference != -1) {
				return -1
			} else {
				indexOfDifference = index
			}
		}
	}
	return indexOfDifference
}