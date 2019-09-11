package com.bk.exercise;

/**
 * @author BK
 * @description: 伪共享测试
 * @date 2019-09-02 01:01
 */
public class FalseSharing {
    // cache line padding
    private Long p1, p2, p3, p4, p5, p6=1L;
}
