package cn.crabapples.spring.crabapples.service;

import cn.crabapples.spring.crabapples.entity.OrderInfo;
import cn.crabapples.spring.crabapples.entity.ShopInfo;
import cn.crabapples.spring.crabapples.entity.ShopList;

import java.util.List;


/**
 * TODO
 *
 * @author Mr.He
 * 2020/3/18 23:44
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name 29404
 */
public interface ShopService {

    List<ShopList> findAllShopList();

    List<ShopInfo> findShopInfoByListId(String id);

    OrderInfo saveShopInfoOrders(List<ShopInfo> submits);

    List<ShopInfo> findAllShopInfo();

    ShopInfo changeStatus(String id);

    void deleteGoods(List<String> ids);
}
