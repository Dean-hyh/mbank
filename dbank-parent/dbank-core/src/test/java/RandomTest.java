import org.junit.Test;

import java.util.Random;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/28 17:29
 */
public class RandomTest {
    @Test
    public void randomTest(){
        System.out.println(String.valueOf(new Random().nextInt(2)));
    }
}
