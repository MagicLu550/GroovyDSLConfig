package net.noyark.www.dsl.utils


class Example extends DSLParser {

    Example() {
        super(new File("/Users/luchangcun/IdeaProjects/test.groovy"),"UTF-8")
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
