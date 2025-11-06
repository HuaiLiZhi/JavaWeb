package com.huailizhi.exception;

public class ClazzHasStudentsException extends RuntimeException{

    public ClazzHasStudentsException() {
        super("对不起, 该班级下有学生, 不能直接删除");
    }
}
