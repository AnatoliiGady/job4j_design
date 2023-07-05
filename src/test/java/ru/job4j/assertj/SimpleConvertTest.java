package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("first", "five", "second")
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("second", "five", "first", "three", "four")
                .containsAnyOf("zero", "second", "six")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("three", "four");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first1", "second2", "three3", "four4", "five5", "first1");
        assertThat(set).hasSize(5)
                .isNotNull()
                .doesNotContainNull()
                .doesNotContain("six")
                .contains("three3");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first1", "second2", "three3", "four4", "five5");
        assertThat(map).hasSize(5)
                .containsKey("first1")
                .containsValue(2)
                .doesNotContainKey("zero")
                .containsEntry("five5", 4);
    }
}