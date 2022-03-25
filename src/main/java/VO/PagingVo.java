package main.java.VO;

public class PagingVo {

    //한페이지에서 보여줄 리스트 수
    private int countlist = 10;
    //페이징 할 갯수
    private int countPage = 5;
    //총 로우 갯수
    private int totalCount;

    public int getCountlist() {
        return countlist;
    }

    public void setCountlist(int countlist) {
        this.countlist = countlist;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
