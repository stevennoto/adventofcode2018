import java.io.File

fun parseFileAsString(filename:String) : String {
	return File(filename)
			.readText()
}

fun parseFileAsList(filename:String) : List<String> {
	return File(filename)
			.readText()
			.split('\n')
}

fun parseFileAsIntList(filename:String) : List<Int> {
	return parseFileAsList(filename)
			.map { it.replace("+","").toInt() }
}