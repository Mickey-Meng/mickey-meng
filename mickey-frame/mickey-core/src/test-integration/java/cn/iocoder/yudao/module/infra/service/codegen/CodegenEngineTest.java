package mickeymeng.framework.infrastructure.service.codegen;

import mickeymeng.framework.infrastructure.dal.dataobject.codegen.CodegenColumnDO;
import mickeymeng.framework.infrastructure.dal.dataobject.codegen.CodegenTableDO;
import mickeymeng.framework.infrastructure.dal.mysql.codegen.CodegenColumnMapper;
import mickeymeng.framework.infrastructure.dal.mysql.codegen.CodegenTableMapper;
import mickeymeng.framework.infrastructure.service.codegen.inner.CodegenEngine;
import mickeymeng.framework.infrastructure.test.BaseDbUnitTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class CodegenEngineTest extends BaseDbUnitTest {

    @Resource
    private CodegenTableMapper codegenTableMapper;
    @Resource
    private CodegenColumnMapper codegenColumnMapper;

    @Resource
    private CodegenEngine codegenEngine;

    @Test
    public void testExecute() {
        CodegenTableDO table = codegenTableMapper.selectById(20);
        List<CodegenColumnDO> columns = codegenColumnMapper.selectListByTableId(table.getId());
        Map<String, String> result = codegenEngine.execute(table, columns);
        result.forEach((s, s2) -> System.out.println(s2));
//        System.out.println(result.get("vue/views/system/test/index.vue"));
    }

}
