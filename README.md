#test-transactional

关于spring中@Transactional注解传播属性原理的实验
==
具体方法：

1. 主体形式：a方法调用b方法
2. a、b方法都可以有不同的传播级别或者不加事务注解（none）:
    > required, required_new, never, supports, not_supoort, mandatory, nested
3. a和b方法都可能抛异常，对于b方法抛出的异常，a方法可以选择捕获或向上抛出
4. 对于以上所有的情况进行枚举，得出以下实验现象：
    > - a是否可访问
    > - b是否可访问
    > - b运行时是否可观察到a的行为
    > - a尝试调用b后，是否可观察到b的行为
    > - 最终的数据变化如何