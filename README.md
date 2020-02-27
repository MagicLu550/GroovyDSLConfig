# GroovyDSLConfig
可以简化自定义DSL文件的解析

具体使用方法参见[Example类](src/main/java/net/noyark/www/dsl/utils/Example.groovy)

如代码案例所示，hello和items为父标签，一般如hello，items所示
```groovy
package net.noyark.www.dsl.utils


class Example extends DSLParser {

    Example() {
        super(new File("test.groovy"),"UTF-8")
    }

    @Override
    void byProperty(String name, Object args,String stack) {
        println name+" : "+args
        println(stack)
    }

    @DSLMethod
    void hello(Closure closure){
        closure()
    }
    @DSLMethod
    void items(Closure closure){
        closure()
    }

    static void main(String[] args) {
        Example example = new Example()
    }
}

```
byProperty可以获取值标签,如url就是一个值标签，在Example中没有指定，会在byProperty中获取
```groovy
items{
    hello{
      url "helloworld" 
    }
}
```
如上面代码执行为
```log
url : [0]
items.hello
```
同样的，您可以在dsl上写groovy代码
```groovy
items{
    hello{
      url "helloworld" 
      print "abc"
    }
}
```





