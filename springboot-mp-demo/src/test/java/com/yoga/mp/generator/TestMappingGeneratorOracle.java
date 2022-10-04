package com.yoga.mp.generator;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jason Lyu
 * @since 2022/1/12
 */
@SpringBootTest
public class TestMappingGeneratorOracle {
    @Test
    public void testMappingGeneratorOracle() {
        MyBatisPlusGeneratorOracle.autoGenerator().execute();
    }
}
