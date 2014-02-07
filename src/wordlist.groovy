def wordList = ["every", "problem", "in", "computer", "science", "can", "be", "solved", "by", "adding", "another",
        "level", "of", "indirection"]

// Exercise 1: Print out all the words in wordList, which is
// a static List<String> defined at the bottom of this file.
wordList.each{ println(it) }


// Exercise 2: Convert all words in wordList to upper case,
// and gather the result into an output list.
assert wordList.collect{ it.toUpperCase() } ==
        ["EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE", "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER", "LEVEL",
                "OF", "INDIRECTION"]
//or
def upper = wordList.collect{ it.toUpperCase() }

assert upper == ["EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE", "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER", "LEVEL",
        "OF", "INDIRECTION"]


// Exercise 3: Find all the words in wordList that have even length
// and put them into an output list.
def evenWords = wordList.findAll{ it.length() % 2 == 0 }

assert evenWords == ["in", "computer", "be", "solved", "by", "adding", "of"]


// Exercise 4: Count the number of lines in a file. The field *reader*
// is a BufferedReader which will be opened for you on the text file.
// See the JUnit @Before and @After methods at the bottom of this file.
// The text file is "SonnetI.txt" (Shakespeare's first sonnet) which is
// located at the root of this NetBeans project.
def lines = 0
new File("../SonnetI.txt").eachLine{ lines++ }

assert lines == 14;


// Exercise 5: Join lines 3-4 from the text file into a single string.
def line23 = new File("../SonnetI.txt").readLines()[2..3].join()

assert line23 == "But as the riper should by time decease," + "His tender heir might bear his memory:"


// Exercise 6: Find the length of the longest line in the file.
assert new File("../SonnetI.txt").readLines().max{ it.length() }.length() == 53


// Exercise 7: Collect all the words from the text file into a list.
// Hint: use String.split(REGEXP) to split a string into words.
// Splitting this way results in "words" that are the empty string,
// which should be discarded. REGEXP is defined at the bottom of this file.
def words = new File("../SonnetI.txt").text.split("\\W+")

assert words == ["From", "fairest", "creatures", "we", "desire", "increase",
        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
        "But", "as", "the", "riper", "should", "by", "time", "decease",
        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
        "substantial", "fuel", "Making", "a", "famine", "where",
        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
        "buriest", "thy", "content", "And", "tender", "churl", "mak",
        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
        "due", "by", "the", "grave", "and", "thee"]


// Exercise 8: Create a list containing the words, lowercased, in alphabetical order.
def wordsLowerSorted = new File("../SonnetI.txt").text.split("\\W+").collect{ it.toLowerCase() }.sort()

assert wordsLowerSorted == ["a", "abundance", "and", "and", "and", "art", "as", "be",
        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
        "by", "by", "churl", "content", "contracted", "creatures",
        "cruel", "decease", "desire", "die", "due", "eat", "else",
        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
        "his", "his", "in", "increase", "lies", "light", "mak",
        "making", "memory", "might", "might", "never", "niggarding",
        "now", "only", "or", "ornament", "own", "own", "pity",
        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
        "should", "spring", "st", "st", "substantial", "sweet",
        "tender", "tender", "that", "that", "the", "the", "the",
        "the", "the", "the", "thee", "thereby", "thine", "thine",
        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
        "with", "within", "world", "world", "world"]


// Exercise 9: Sort unique, lower-cased words by length, then alphabetically
// within length, and place the result into an output list.
def wordsCrazySort = new File("../SonnetI.txt").text.split("\\W+").collect{ it.toLowerCase() }.unique()
        .sort{ a, b -> a.length() <=> b.length() ?: a <=> b}

assert wordsCrazySort == ["a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
        "mak", "now", "own", "the", "thy", "too", "bear", "else",
        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
        "pity", "rose", "self", "that", "thee", "this", "thou",
        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
        "grave", "light", "might", "never", "riper", "sweet", "thine",
        "waste", "where", "world", "beauty", "bright", "desire",
        "famine", "herald", "making", "memory", "should", "spring",
        "tender", "within", "buriest", "content", "decease",
        "fairest", "glutton", "thereby", "increase", "ornament",
        "abundance", "creatures", "contracted", "niggarding",
        "substantial"]


// Exercise 10: Categorize the words into a map, where the map's key is
// the length of each word, and the value corresponding to a key is a
// list of words of that length. Don't bother with uniqueness or lower-
// casing the words.
def wordMap = new File("../SonnetI.txt").text.split("\\W+").groupBy{ it.length() }

assert wordMap[7].size() == 6
assert wordMap[8] == ["increase", "ornament"]
assert wordMap[9] == ["creatures", "abundance"]
assert wordMap[10] == ["contracted", "niggarding"]
assert wordMap[11] == ["substantial"]
assert !wordMap[12]


// Exercise 11: Gather the words into a map, accumulating a count of the
// number of occurrences of each word. Don't worry about upper case and
// lower case.
def sonnetWords = new File("../SonnetI.txt").text.split("\\W+")
def wordCount = sonnetWords.collectEntries{ [it, sonnetWords.count(it)] }

assert wordCount["tender"] == 2
assert wordCount["the"] == 6
assert wordCount["churl"] == 1
assert wordCount["thine"] == 2
assert wordCount["world"] == 3
assert !wordCount["lambda"]


// Exercise 12: Create a nested grouping, where the outer map is a map
// from the first letter of the word to a submap. (Use a string of length
// one as the key.) The submap, in turn, is a mapping from the length of the
// word to a list of words with that length. Don't bother with any downcasing
// or uniquifying of the words.
//
// For example, given the words "foo bar baz bazz" the top level map would have
// a keys of "f" and "b". The value corresponding to "b" would be a map with
// a key of 3 with a value of [bar baz] (a list of Strings) and a key of 4
// with a value of [bazz] (a one-element list of String).
