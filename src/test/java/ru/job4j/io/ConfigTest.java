package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Anatolii Gady");
    }

    @Test
    void whenPairWitComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Anatolii Gady");
    }

    @Test
    void whenWithEqualSymbolNotFirst() {
        String path = "./data/pair_with_Symbol_Not_First";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenTwoEquals() {
        String path = "./data/pair_with_Key_Equals_Value_Equals";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Anatolii Gady=");
    }
}