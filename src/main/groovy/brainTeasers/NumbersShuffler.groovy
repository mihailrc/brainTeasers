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
     * there is a second approach that can be considered. The number of distinct shuffles is given by the number of
     * permutations of numbers between 1 and howMany.
     *
     * Let's imagine these shuffles are ordered say in a lexicographical like ordering. For example for 3 numbers
     * we have (1,2,3) (1,2,3) (2,1,3) (2,3,1) (3,1,2) (3,2,1). Important: we DO NOT store these permutations in memory.
     * We just need to know how to generate a permutation given an index - this is a deterministic problem.
     *
     * Then the problem reduces to generating a "random" number between 1 and howMany! then figuring out the permutation
     * located at that index. The complexity of this algorithm is still O(howMany). Note also that I need to switch from
     * int to BigIntegers to handle something like a card deck. Painless in both Groovy and Clojure
     *
     * I will write the code for this later
     */


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
