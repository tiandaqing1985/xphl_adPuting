package com.ruoyi.today.service;

import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.domain.ThVideoOrder;

import java.util.List;

/**
 * 视频订单Service接口
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public interface IThVideoOrderService 
{
    /**
     * 查询视频订单
     * 
     * @param id 视频订单ID
     * @return 视频订单
     */
    public ThVideoOrder selectThVideoOrderById(Long id);

    /**
     * 查询视频订单列表
     * 
     * @param thVideoOrder 视频订单
     * @return 视频订单集合
     */
    public List<ThVideoOrder> selectThVideoOrderList(ThVideoOrder thVideoOrder);

    /**
     * 新增视频订单
     * 
     * @param thVideoOrder 视频订单
     * @return 结果
     */
    public int insertThVideoOrder(ThVideoOrder thVideoOrder) throws Exception;

    /**
     * 修改视频订单
     * 
     * @param thVideoOrder 视频订单
     * @return 结果
     */
    public int updateThVideoOrder(ThVideoOrder thVideoOrder) throws Exception;

    /**
     * 批量删除视频订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteThVideoOrderByIds(String ids);

    /**
     * 删除视频订单信息
     * 
     * @param id 视频订单ID
     * @return 结果
     */
    public int deleteThVideoOrderById(Long id);

    int updateOrderStatus(ThVideoOrder thVideoOrder, String statusName) throws Exception;

    void orderDelivery(ThVideoOrder thVideoOrder) throws Exception;

    void putInMatter(ThCreativity thCreativity) throws Exception;

    void orderDeliveryAgain(ThVideoOrder thVideoOrder) throws Exception;
}
