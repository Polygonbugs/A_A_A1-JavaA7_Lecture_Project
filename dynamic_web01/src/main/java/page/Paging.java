package page;

import java.util.ArrayList;
import java.util.List;

public class Paging {

    private Object page;
    private List<Integer> pageList;
    private int currentPage;
    private int lastPage;
    private int pageLimit = 10;
    private int listLimit = 5;

    public Paging(Object page, int lastPage) {
        this.page = page;
        this.lastPage = lastPage;
        setPageList();
    }

    public Paging(Object page, int currentPage, int lastPage) {
        this(page, lastPage);
        this.currentPage = currentPage;
    }

    public Paging(Object page, int currentPage, int lastPage, int pageLimit, int listLimit) {
        this(page, lastPage);
        this.currentPage = currentPage;
        this.pageLimit = pageLimit;
        this.listLimit = listLimit;
    }

    public Object getPage() {
        return page;
    }

    public List<Integer> getPageList() {
        int start = 0;
        int end = listLimit;
        if(currentPage > (listLimit / 2) + 1) {
            start = currentPage - (listLimit / 2 + 1);
            end = currentPage + (listLimit / 2) - (listLimit % 2 == 0 ? 1 : 0);
        }
        if(end > lastPage) {
            end = lastPage;
        }
        return pageList.subList(start, end);
    }

    private void setPageList() {
        pageList = new ArrayList<Integer>();
        for(int i = 1; i <= lastPage; i++) {
            pageList.add(i);
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPrevPage() {
        return currentPage == 1 ? -1 : currentPage - 1;
    }

    public int getNextPage() {
        return currentPage == lastPage ? -1 : currentPage + 1;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getPageLimit() {
        return pageLimit;
    }

    public int getListLimit() {
        return listLimit;
    }

}
