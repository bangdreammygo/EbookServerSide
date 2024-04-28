# EbookServerSide
 上海交通大学互联网应用开发技术（课程号：SE2321）课程大作业ebook项目的后端代码
# 关于自学速通java后的一些小心得

**挂一个**    [相对较好的速通学习网址](https://www.bilibili.com/video/BV1ur4y1G7Dc?p=75&vd_source=ebf74c71bea99fa48cee422be6987633)  

### 写在前面的话：  
因为学校课程要求（课程号：SE2321），被迫在一周内顶着各科的ddl速通掉java，当然如果你事先学过C++，这个任务并不会太难，难的是，你找不到一个合适的教程帮助你这样学过C++的人来速通一门与C++高度相似的更简化的语言。当然可以三倍速看那些“零基础JAVA”，但是我其实更想几个小时就大致掌握这门语言，毕竟这对于会C++的人来说不是什么难事。         


这篇文档就是本人在尝试速通过后写下的一些小小的感悟，在本篇笔记完成后会上传至本人的github，同时后续完成后端开发后也会作为后端仓库的readme以供来~~抄袭~~ 借鉴 代码的学弟学妹参考学习。希望这篇小小的文档能对你的这门课有所帮助。




### JavaBean

javabean并不是一种语法，而是一种**规范**，简单来说，是提供一种更优势的封装的策略，比如看下面这个例子

```
class array{
   public int num;
   ...
}
```   
上述的面向对象编程虽然看起来非常方便，但是实际开发里就显得不够安全了。javabean的**核心思想**就是：

```
将数据部分的成员字段私有  
留下public的方法用以调用值(getXXX,返回值)，或者修改值(setXXX,修改值)
对外无法使用简单的代码将字段值进行修改，但你可以访问到值和调用set接口
```
*just like that:*
```
class array{
    int num;
    public int getNum(){return num;}
    public void setNum(int n){num=n;}
}
```

*   *look familiar? these things are happening all over the coding universe，you could be next. if you want to change this please come to join react! huhu, what can i say? vue out!*   
any way , 以上所描述的规范就是javabean这一项所要求的基础规范,其实从其要求我们就能看出，所谓的javabean，其核心理念是为更好的实现封装在服务。那在java中，封装又是如何实现的？


### 接口interface 与 实现implements

**推荐对比阅读:**      [C++中虚函数的应用](https://blog.csdn.net/weixin_43329614/article/details/89103574)   

接口需要用关键字 ***interface*** 来声明，就像C++中的虚函数(virtual function)和抽象类(abstract class)相似，其中只负责定义空的函数（abstract声明，是public，可以省略）或者公用的函数（default声明，不可以省略），具体的实现类用inmplements声明来完善接口。
```
//接口
interface A{
    void print();
    default void test(){system.out.println("test");}
}

//实现类
class a implements A{
    string Aa="hello";
    @Override
    //注意覆写后的作用范围>=覆写前的作用范围，所以只能是public
    void print(){
        system.out.println(Aa);
    }
}
...


a testa=new a();
//"test"，默认函数，继承下来
testa.test();
//"hellow" 抽象函数，覆写的结果
testa.print();
```  

### 最后的集大成封装  
继续用上面的例子来看：  
通过javabean保护数据，通过接口保证访问私密性，同时实现逻辑实现与字段存储的分离。   



补充说明：为什么使用接口可以使得继承更安全？
```
//接口
interface A{
    void print();
    void test(){system.out.println("test");}
}

//实现类
class a implements A{
    string Aa="hello";
    @Override
    //注意覆写后的作用范围>=覆写前的作用范围，所以只能是public
    void print(){
        system.out.println(Aa);
    }
}
...

A testa=new a();

//无效操作,因为接口里可不包含这个
testA.Aa=xxxxx;

```     

### 控制反转相关  
使用@service和@autowired注解，可以让spring框架来帮你生成对象，但是有几点需要注意：

```
interface cal{
    void print();
}

@Service
class cal1 implements cal{
    void print(){system.out.println("111");}
}
@Service
class cla2 implements cal{
    void print(){system.out.println("222");}
}
...
@Autowired
cal test[];
//////////注意，此处是，spring框架先帮你创建出来了cal1和cla2两个对象，然后填入数组
//////////但是具体的填入顺序是不定的！！



```
