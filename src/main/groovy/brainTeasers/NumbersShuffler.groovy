package brainTeasers

/**
 * Created by mihail on 12/4/14.
 *
 * Generates a list with randomly shuffled numbers. Does not contain duplicates and only has numbers between
 * 1 and howMany
 */
class NumbersShuffler {


    static Random randomNumberGenerator = new Random()

    int howMany

    def unShuffled() {
        (1..howMany).inject([]) { list, value -> list + value }
    }

    def shuffle() {
        def availableSlots = unShuffled()
        def shuffledArray = []
        (1..howMany).each { it ->
            def randomIndex = random(availableSlots.size())
            shuffledArray = shuffledArray + availableSlots[randomIndex]
            availableSlots.remove(randomIndex)
        }
        shuffledArray
    }

/**
 * @param max
 * @return a random integer between 0(inclusive) and max(exclusive)
 */
    private static int random(int max) {
        def randomNumber = Integer.MAX_VALUE
        while (randomNumber >= max) {
            def randomBits = (1..numberOfRepresentativeBits(max)).inject([])
                    { list, value -> list + randomNumberGenerator.nextInt(2) }
            randomNumber = bitListToDecimal(randomBits)
        }
        randomNumber
    }

    private static def bitListToDecimal(def randomBits) {
        def decimal = 0
        randomBits.reverse().eachWithIndex { it, index -> decimal = decimal + it * Math.pow(2, index) }
        decimal
    }

    private static int numberOfRepresentativeBits(int n) {
        Math.ceil(Math.log(n) / Math.log(2))
    }
}
