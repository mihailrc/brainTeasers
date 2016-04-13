package brainTeasers

/**
 * given a really big list of digits find the first sequence of a given size that repeats
 *
 * Example:
 * given list [1,2,3,4,2,4,3,2,3,4,7,9]
 * the first list of size two that repeats is [2,3]
 *
 *
 * Note: Attempting to find exact repetitions is not a really good idea if the sequence size is a bit bigger. For
 * example if the one wants to store all distinct digit sequences that have 12 elements, then we need about 4*10^12 bytes
 * or about 4TB of memory. Not really good. The alternative is to use an approximate algorithm like HyperLogLog that
 * uses much less memory.
 *
 *
 * Attempting to process this in parallel is also a bad idea.
 * This will just add significant complexity with no clear benefit. The limitation is the number of distinct elements
 * that need to be kept in memory(assuming one is not using HyperLogLog). Also the parallel implementation would not
 * work for an infinite stream.
 */

class RepeatedSequence {

    List list

    //observation: the maximum list size without a repeated sequence is 10^subListSize so the
    //algorithm is O(0) not O(n)
    def findFirstRepeatedList(int subListSize) {
        def encounteredSubList = [] as Set
        for (index in (0..list.size() - subListSize)) {
            def candidateSubList = list.subList(index, index + subListSize)
            if (encounteredSubList.contains(candidateSubList)) {
                return candidateSubList
            }
            encounteredSubList.add(candidateSubList)
        }

    }

}
