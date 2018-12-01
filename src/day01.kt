import java.io.File

// https://adventofcode.com/2018/day/1
fun main(args: Array<String>) {
	day1a()
	day1b()
}

// Goal: Sum all numbers
// Approach: parse list and sum
fun day1a() {
	val sum:Int = parseFileAsIntList("resources/input01.txt")
			.sum()

	println("The sum is $sum")
}

// Goal: Add to sum incrementally, stopping on first sum seen twice
// Approach: Cycle through input, summing incrementally, storing seen sums in a set until duplicate found
fun day1b() {
	val input:List<Int> = parseFileAsIntList("resources/input01.txt")
	val seen:MutableSet<Int> = mutableSetOf()
	var index = 0
	var sum = 0
	while (true) {
		sum += input[index++]
		if (seen.contains(sum)) {
			println("The first sum seen twice is $sum")
			break
		} else {
			seen.add(sum)
		}
		if (index >= input.size) {
			index = 0
		}
	}
}
