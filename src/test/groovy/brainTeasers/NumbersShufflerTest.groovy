package brainTeasers

import static org.junit.Assert.*
import org.junit.Test

/**
 * Created by mihail on 12/4/14.
 */
class NumbersShufflerTest {

    @Test
    def void shuffleNumbers() {
        int howMany = 52;
        NumbersShuffler shuffler = new NumbersShuffler(howMany: howMany)
        def shuffledArray = shuffler.shuffle()
        def original = shuffler.unShuffled()
        assertEquals("Did not return shuffled array of expected size", howMany, shuffledArray.size())
        assertEquals("Shuffled array contains duplicates", howMany, new HashSet(shuffledArray).size())
        assertEquals("Shuffled array contains unexpected elements", new HashSet(original), new HashSet(shuffledArray))
    }

    @Test
    def void justPrintShuffledArray() {
        int howMany = 52;
        NumbersShuffler shuffler = new NumbersShuffler(howMany: howMany)
        println shuffler.shuffle()

    }
}

