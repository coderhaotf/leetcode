import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }

    @Override
    public Integer next() {
        return this.list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        if (this.list.isEmpty())
            return false;

        NestedInteger first = this.list.get(0);
        while (first != null && !first.isInteger()) {
            first = this.list.remove(0);
            List<NestedInteger> childs = first.getList();
            if (!childs.isEmpty()) {
                this.list.addAll(0, childs);
            }
            if (this.list.isEmpty()) {
                return false;
            }
            first = this.list.get(0);
        }
        return !this.list.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end
