package com.ssafy.project.test;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

public class MiscTest {

    @BeforeAll
    public static void setup() {
        System.out.println("before all tests in the current test class");
    }

    @BeforeEach
    public void inti() {
        System.out.println("before each @Test");
    }


    @Test
    public void testHashSetContainsNonDuplicatedValue() {

        // Given
        Integer value = 1;
        Set<Integer> set = new HashSet<>();

        // When
        set.add(value);
        set.add(value);
        set.add(value);

        // Then
        Assertions.assertEquals(1, set.size());
        Assertions.assertTrue(set.contains(value));
    }

    @Test
    public void testDummy() {
        Assertions.assertTrue(Boolean.TRUE);
    }

    @AfterEach
    public void cleanup() {
        System.out.println("after each @Test");
    }

    @AfterAll
    public static void destroy() {
        System.out.println("after all tests in the current test class");
    }

}