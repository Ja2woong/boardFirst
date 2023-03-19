package com.myboard.boardFirst.dao;

import com.myboard.boardFirst.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void insertTestData() throws Exception {
        boardDao.deleteAll();
        for (int i = 1; i <= 200; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "no content", "asdf");
            boardDao.insert(boardDto);
        }
    }

    @Test
    public void select() throws Exception {
       assertTrue(boardDao!=null);
        System.out.println("boardDao = " + boardDao);
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDTO = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }
}