import com.ms.framework.AbstractContext;
import com.ms.framework.Context;
import com.ms.framework.ContextSon;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/10 9:43
 */
public class ContextTest {
    @Test
    public void demo(){
        Context context1 = new ContextSon();
        Map<String, Object> value1 = getValue(context1);
        System.out.println(value1);
        ContextSon contextSon = new ContextSon();
        System.out.println(contextSon);
    }

    public Map<String,Object> getValue(Context context){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("header","Dean");
        hashMap.put("body","111");
        context.put("request",hashMap);
        return (Map<String,Object>)context.get("request");
    }
}
