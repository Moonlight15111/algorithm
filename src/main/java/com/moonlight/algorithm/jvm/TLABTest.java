package com.moonlight.algorithm.jvm;

/**
 * @ClassName TLABTest
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/21 22:29
 * @Version V1.0
 **/
public class TLABTest {

    static class Test{
        int i;
        String str;
        public Test (int i, String str) {
            this.i = i;
            this.str = str;
        }
    }

    public void m(int i){
        new Test(i, "" + i);
    }

    public static void main(String[] args) {
        // -XX:-DoEscapeAnalysis      关闭逃逸分析
        // -XX:-EliminateAllocations  关闭标量替换
        // -XX:-UseTLAB               关闭TLAB分配
        TLABTest test = new TLABTest();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++) {
            test.m(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
