package com.example.yaml_setting.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FruitPropertyTest {

    @Autowired
    private FruitProperty fruitProperty;

    @Test
    public void test(){
        List<Fruit> fruitData=fruitProperty.getList();

        assertThat(fruitData.get(0).getFruitName(),is("banana"));
        assertThat(fruitData.get(0).getFruitColor(),is("yellow"));

        assertThat(fruitData.get(1).getFruitName(),is("apple"));
        assertThat(fruitData.get(1).getFruitColor(),is("red"));

        assertThat(fruitData.get(2).getFruitName(),is("water melon"));
        assertThat(fruitData.get(2).getFruitColor(),is("green"));
    }

}
