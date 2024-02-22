package org.example.dao;

import org.example.dataobject.PromoDo;

public interface PromoDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    int insert(PromoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    int insertSelective(PromoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    PromoDo selectByPrimaryKey(Integer id);

    PromoDo selectByItemId(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    int updateByPrimaryKeySelective(PromoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promo
     *
     * @mbg.generated Mon Feb 12 17:07:02 GMT+08:00 2024
     */
    int updateByPrimaryKey(PromoDo record);
}