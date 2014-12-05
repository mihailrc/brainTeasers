package brainTeasers

/**
 * Created by mihail on 12/4/14.
 *
 * Generates a list with randomly shuffled numbers. Does not contain duplicates and only has numbers between
 * 0 and howMany -1
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
 *
 * Note that the current implementation biases the distribution towards smaller numbers. For example if max is
 * 52, numbers between 0 and 12 are twice more likely to be selected that numbers between 13 and 51. It is easy to
 * generate a different distribution that will bias other numbers. However I do not know how to generate a uniform
 * random distribution and how to mathematically prove that it is uniform.
 */
    private static int random(int max) {
        def randomBits = (1..numberOfRepresentativeBits(max)).inject([])
                { list, value -> list + randomNumberGenerator.nextInt(2) }
        bitListToDecimal(randomBits) % max
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
