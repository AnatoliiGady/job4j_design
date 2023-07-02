package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.lang.ref.SoftReference;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isNotSphere() {
        Box box = new Box(2, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isNumberOfVerticesThen6() {
        Box box = new Box(4, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4);
    }

    @Test
    void isNumberOfVerticesThen0() {
        Box box = new Box(0, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0);
    }

    @Test
    void isExist() {
        Box box = new Box(4, 6);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(4, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenVertex0AndEdge1() {
        Box box = new Box(0, 1);
        double result = box.getArea();
        assertThat(result).isLessThan(12.57d);
    }

    @Test
    void whenVertex9AndEdge1() {
        Box box = new Box(9, 1);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }
}