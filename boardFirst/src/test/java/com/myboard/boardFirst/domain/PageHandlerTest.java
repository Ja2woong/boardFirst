package com.myboard.boardFirst.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PageHandlerTest {
    @Test
    public void test() {
        PageHandler ph = new PageHandler(250, 11);
        ph.print();
        System.out.println("ph" + ph);
        assertTrue(ph.beginPage == 11);
        assertTrue(ph.endPage == 20);
    }

}