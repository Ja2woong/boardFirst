package com.myboard.boardFirst.domain;

import org.springframework.web.util.*;

public class PageHandler {
    private int totalCnt; // 게시물의 총 갯수
    private Integer pageSize = 10; // 한 페이지당 게시물 갯수
    public  final int NAV_SIZE = 10; // 페이지 네비게이션의 크기
    private int totalPage; // 전체 페이지의 갯수
    private Integer page; // 현재 페이지

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    Integer beginPage; // 화면에 보여줄 첫 페이지
    int endPage; // 화면에 보여줄 마지막 페이지
    boolean showNext = false; // 이후를 보여줄지의 여부. endPage==totalPage이면, showNext는 false
    boolean showPrev = false; // 이전을 보여줄지의 여부. beginPage==1이 아니면 showPrev는 false

    public PageHandler(int totalCnt, Integer page) {
        this(totalCnt, page, 10);
    }
    public PageHandler(int totalCnt, Integer page, Integer pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);
        beginPage = (page-1) / NAV_SIZE * NAV_SIZE + 1;
        endPage = Math.min(beginPage + NAV_SIZE -1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;

    }
    void print() {
        System.out.println("page="+ page);
        System.out.print(showPrev? "PREV " : "");

        for(int i=beginPage;i<=endPage;i++) {
            System.out.print(i+" ");
        }
        System.out.println(showNext ? " NEXT" : "");
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getNAV_SIZE() {
        return NAV_SIZE;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", NAV_SIZE=" + NAV_SIZE +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showNext=" + showNext +
                ", showPrev=" + showPrev +
                '}';
    }
}
