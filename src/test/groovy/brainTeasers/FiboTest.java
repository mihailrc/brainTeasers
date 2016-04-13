package brainTeasers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//import java.io.File;
import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * Created by mihail on 10/16/15.
 */
@RunWith(Parameterized.class)
public class FiboTest {

    @Parameterized.Parameters(name = "bazookas{0}={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    private int input;
    private int expected;

    public FiboTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void xmlResponse() {
        assertEquals(expected, input);
    }

    @Test
    public void greaterThanZero() {
        assertTrue(expected>0);
    }

//    @Test
//    public void files(){
//        File dir = new File("../spec");
//        File [] files = dir.listFiles();
//        for(File file:files){
//            System.out.println(file.getName());
//        }
//    }


}
