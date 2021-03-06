package cn.bravedawn.latte.ui.refresh;

/**
 * Created by 冯晓 on 2017/9/25.
 */

public class PagingBean {

    // 当前页数
    private int mPageIndex = 0;
    // 总数据条数
    private int mTotal = 0;
    // 一页显示几条数据
    private int mPageSize = 0;
    // 当前总页数
    private int mTotalPage = 0;
    // 加载延迟
    private int mDelayed = 0;

    public int getPageIndex() {
        return mPageIndex;
    }

    public PagingBean setPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int mTotal) {
        this.mTotal = mTotal;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
        return this;
    }

    public int getTotalPage() {
        return mTotalPage;
    }

    public PagingBean setTotalPage(int totalPage) {
        this.mTotalPage = totalPage;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int mDelayed) {
        this.mDelayed = mDelayed;
        return this;
    }

    public PagingBean addIndex() {
        mPageIndex++;
        return this;
    }

    @Override
    public String toString() {
        return "PagingBean{" +
                "mPageIndex=" + mPageIndex +
                ", mTotal=" + mTotal +
                ", mPageSize=" + mPageSize +
                ", mCurrentCount=" + mTotalPage +
                ", mDelayed=" + mDelayed +
                '}';
    }
}
