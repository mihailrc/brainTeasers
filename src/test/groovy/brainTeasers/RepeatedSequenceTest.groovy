package brainTeasers

import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by mihail on 12/4/14.
 */
class RepeatedSequenceTest {

    /*
     *
     *I have to admit this would be way cooler in Clojure since I can use a lazy sequence. This way I could
     * use sequences of indefinite length.
     * Groovy does not have lazy sequences built in but I can build my own if I wanted to.
     */

    @Test
    def void findsFirstRepeatedList() {
        RepeatedSequence repeatedSequence = new RepeatedSequence(list: [1, 2, 3, 3, 2, 1, 6, 7, 2, 3, 9, 8, 1, 2, 3])
        assertEquals([3], repeatedSequence.findFirstRepeatedList(1))
        assertEquals([2, 3], repeatedSequence.findFirstRepeatedList(2))
        assertEquals([1, 2, 3], repeatedSequence.findFirstRepeatedList(3))
        assertNull(repeatedSequence.findFirstRepeatedList(4))
    }
}
