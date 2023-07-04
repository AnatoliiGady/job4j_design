package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("collection contains no data");
    }

    @Test
    void checArrayEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = new String[0];
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void isNotValidateSymbol() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = new String[]{"key", "value="};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("dots not contain the symbol");
    }

    @Test
    void checkNameAndContains() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = new String[]{"key=", "value"};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(strings[0])
                .hasMessageContaining("does not contain a value");
    }
}