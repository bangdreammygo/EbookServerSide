package com.ebook.Controller;


import com.ebook.dto.BookJavaBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//控制书籍信息的类
@RestController
@CrossOrigin
public class BookController {


    //实际之后修改应该在这之前就把书籍信息拿出来放进arraylist
    //控制器对象也应该有构造函数和私有字段etc
    
    @RequestMapping("/bookinfo")
      public ArrayList<BookJavaBean> getBookInfo(){
//        //这里选择硬编码，实际应该在进入这个函数之前就以及获得了所有的值
          ArrayList<BookJavaBean> books = new ArrayList<BookJavaBean>();
          books.add(new BookJavaBean(1,"假面骑士decade外传",5,1,"【日】石章森太郎","突然开始崩溃的世界。在袭击人们的无数的怪物的面前，丧失记忆的青年·门矢士变身为假面骑士Decade。他所被赋予的使命，就是将世界从消灭中拯救出来 ……。与别世界的假面骑士们的相遇。然后战斗。巡游9个平行世界的Decade之旅，现在开始。"));
          books.add(new BookJavaBean(2,"约会大作战全册",6,114514,"【日】橘公司","五河士道是一名平凡的男高中生。新学期开始的第一天，士道一早被妹妹五河琴里飞踢叫起床后，约定中午到家庭餐厅去吃饭。快到中午时却发生了罕见的空间震，在同学们纷纷赶往避难设施时，五河士道却发现自己妹妹GPS位置定在家庭餐厅前，并未去避难，而匆忙赶去。见到的却是一位全身衣服散发光芒的少女，和身穿机械装备的同班同学鸢一折纸。用约会使精灵能够和平相处的幻想物语就此开始。"));
          books.add(new BookJavaBean(3,"浮生物语5：西溟幽海",114514,40,"【中】裟椤双树","　甲乙叛变，带走不停里的挚爱亲朋，老板娘与敖炽踏上了寻找万妖之源西溟幽海的旅途。二人为了找到消息灵通的虫帝，深入危机四伏的阿图拉，又见识了恶念丛生的暗网，随后被卷进一段旧怨，往事浮现，一个“预言”背后是敖炽的“失踪”与龙族的危机。然而不止于此，天帝性情大变，三界混乱，世界开始走向崩坏……一个个谜团被解开，一个个过往重现眼前，一个个故人再次归来，裟椤历经一切，终于找回了世界最初的样子。"));
          books.add(new BookJavaBean(4,"苏轼词集",1126,36.9,"【宋】苏轼","苏轼是宋代伟大的现实主义文学家，他以卓越的天才、广博的学识、开朗的胸襟，写出了大量辉煌的诗、文、词，表达了自己一生的真实经历和和丰富的思想情感。苏轼词内容广阔，气魄雄伟，语言朴素，一反过去绮罗香泽及离情别绪的局限，是宋词空前的划时代的革新，也是宋词进一步的发展。本书备搜苏轼词全部作品及后人的评论，另外还加以简单的注释和系年，为读者欣赏苏轼词提供了较多的方便。"));
          books.add(new BookJavaBean(5,"哑舍零：秦失其鹿",1999,42.3,"【中】玄色","《哑舍·零·秦失其鹿》是畅销百万册的古风动漫幻想大作《哑舍》系列的前传，讲述了因服食长生不老药而从秦朝活到现代的主角“老板”，将自己所开的古董店“哑舍”迁移到杭州，与《哑舍》另一男主“医生”相遇之前的故事。"));
          books.add(new BookJavaBean(6,"忘川风华录设定集",2003,48.2,"【中】忘川风华录官方企划","“忘川风华录音乐企划”是由忘川企划组策划的同人创作性质的大型国风音乐企划，企划组主要成员包括主策划木宁木蒙，企划运营塔库、炸三宝，监制顾雪柔。该企划以中国历史人物和故事为核心灵感源泉，构建出历朝历代名士们共聚忘川的独特世界观。"));
          books.add(new BookJavaBean(7,"高情商聊天术",1,28,"【中】张超","这是一本帮你提高情商，教你真正会聊天的书。"));
          books.add(new BookJavaBean(8,"咒术回战漫画全册",1,19,"【日】芥见下下","“绝对的强者，由此而生的孤独，教会你爱的将会是......”,五条老师，你能赢吗？没关系，我可是最强啊！当代最强决战历史最强，谁才是咒术的顶点？"));
          return books;
      }

}
