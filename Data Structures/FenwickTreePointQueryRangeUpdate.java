import java.io.*;
import java.util.*;

class FenwickTrees {
    int n;
    long[] bit;

    FenwickTrees(int size) {
        n = size;
        bit = new long[n];
    }

    void add(int pos, long val) {
        for (; pos < this.n; pos += pos & -pos)
            this.bit[pos] += val;
    }

    void rangeAdd(int left, int right, long val) {
        add(left, val);
        add(right + 1, -val);
    }

    int getVal(int index){
        int ans = 0;
        for (++index; index > 0; index -= index & -index)
            ans += bit[index];
        return ans;
    }

}
