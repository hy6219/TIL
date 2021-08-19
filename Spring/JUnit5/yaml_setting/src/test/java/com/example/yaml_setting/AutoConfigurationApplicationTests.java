package com.example.yaml_setting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AutoConfigurationApplicationTests {


    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyTest}")
    private String propertyTest;

    @Value("${noKey:default value}")
    private String defaultValue;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;



    @Test
    public void testYamlKeyValue(){

        assertThat(propertyTestName,is("property depth test"));
        assertThat(propertyTest,is("test"));
        assertThat(defaultValue,is("default value"));

        assertThat(propertyTestArray[0],is("a"));
        assertThat(propertyTestArray[1],is("b"));
        assertThat(propertyTestArray[2],is("c"));

        assertThat(propertyTestList,is(new ArrayList<String>(Arrays.asList("a","b","c"))));
        assertEquals(propertyTestList,new ArrayList<String>(Arrays.asList("a","b","c")));
        assertThat(propertyTestList.get(0),is("a"));
        assertThat(propertyTestList.get(1),is("b"));
        assertThat(propertyTestList.get(2),is("c"));
    }
}
