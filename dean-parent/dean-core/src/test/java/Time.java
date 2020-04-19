import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/28 9:43
 */
public class Time {
    @Test
    public void time(){
        long l = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(l);
        System.out.println(format);
    }
}
