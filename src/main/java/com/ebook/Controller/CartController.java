package com.ebook.Controller;


import com.ebook.dto.BookJavaBean;
import com.ebook.dto.CartJavaBean;
import com.ebook.dto.OrderJavaBean;
import com.ebook.pojo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//购物车的后端controller
@RestController
@CrossOrigin
public class CartController {
    @RequestMapping("/cart/get")
    //这里理应会接收到用户的id来帮助筛查，但考虑是写死的，也就无所谓了
    public ArrayList<CartJavaBean> getCart() {
        ArrayList<CartJavaBean> cartItems = new ArrayList<CartJavaBean>();
        cartItems.add(new CartJavaBean(1,new BookJavaBean(1,"假面骑士decade外传",5,1,"【日】石章森太郎","突然开始崩溃的世界。在袭击人们的无数的怪物的面前，丧失记忆的青年·门矢士变身为假面骑士Decade。他所被赋予的使命，就是将世界从消灭中拯救出来 ……。与别世界的假面骑士们的相遇。然后战斗。巡游9个平行世界的Decade之旅，现在开始。"),7));
        cartItems.add(new CartJavaBean(1,new BookJavaBean(3,"浮生物语5：西溟幽海",114514,40,"【中】裟椤双树","　甲乙叛变，带走不停里的挚爱亲朋，老板娘与敖炽踏上了寻找万妖之源西溟幽海的旅途。二人为了找到消息灵通的虫帝，深入危机四伏的阿图拉，又见识了恶念丛生的暗网，随后被卷进一段旧怨，往事浮现，一个“预言”背后是敖炽的“失踪”与龙族的危机。然而不止于此，天帝性情大变，三界混乱，世界开始走向崩坏……一个个谜团被解开，一个个过往重现眼前，一个个故人再次归来，裟椤历经一切，终于找回了世界最初的样子。"),2));
        cartItems.add(new CartJavaBean(1,new BookJavaBean(5,"哑舍零：秦失其鹿",1999,42.3,"【中】玄色","《哑舍·零·秦失其鹿》是畅销百万册的古风动漫幻想大作《哑舍》系列的前传，讲述了因服食长生不老药而从秦朝活到现代的主角“老板”，将自己所开的古董店“哑舍”迁移到杭州，与《哑舍》另一男主“医生”相遇之前的故事。"),1));
        cartItems.add(new CartJavaBean(1,new BookJavaBean(2,"约会大作战全册",6,114514,"【日】橘公司","五河士道是一名平凡的男高中生。新学期开始的第一天，士道一早被妹妹五河琴里飞踢叫起床后，约定中午到家庭餐厅去吃饭。快到中午时却发生了罕见的空间震，在同学们纷纷赶往避难设施时，五河士道却发现自己妹妹GPS位置定在家庭餐厅前，并未去避难，而匆忙赶去。见到的却是一位全身衣服散发光芒的少女，和身穿机械装备的同班同学鸢一折纸。用约会使精灵能够和平相处的幻想物语就此开始。"),1));
       return cartItems;
    }
    @PutMapping("/cart/put")
    public Result putCart(@RequestBody OrderJavaBean order) {
        Result result = new Result();
        if(order.getProducts().length==0){
            result.setCode(100);
            result.setData("订单不能为空！");
            return result;
        }
        for (int i = 0; i < order.getProducts().length; i++) {
            System.out.println(order.getProducts()[i].getBook().getName());
            System.out.println(order.getProducts()[i].getId());
            System.out.println(order.getProducts()[i].getNum());
            System.out.println(order.getDate());
        }
        //为这个新的订单生成一份新的订单号
        order.setId(114514);
        result.setData("后台已接收到订单");
        result.setCode(200);
        return result;
    }
}