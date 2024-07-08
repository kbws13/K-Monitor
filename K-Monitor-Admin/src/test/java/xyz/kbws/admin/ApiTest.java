package xyz.kbws.admin;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

/**
 * @author kbws
 * @date 2024/7/6
 * @description:
 */
@Slf4j
public class ApiTest {

    @Test
    public void test_ognl() throws OgnlException {
        String json = "{\"orderId\":\"123123123\", \"userAge\":25, \"userId\":\"10001\", \"userName\":\"kbws\"}";

        JSONObject obj = JSONObject.parseObject(json);

        OgnlContext context = new OgnlContext();
        context.setRoot(obj);

        Object root = context.getRoot();

        log.info((String) Ognl.getValue("userId", context, root));
        log.info((String) Ognl.getValue("orderId", context, root));
    }
}
