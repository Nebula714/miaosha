package org.example.dao;

import org.example.dataobject.UserPasswordDo;

public interface UserPasswordDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    int insert(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    int insertSelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    UserPasswordDo selectByPrimaryKey(Integer id);

    UserPasswordDo selectByUserId(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    int updateByPrimaryKeySelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sun May 07 21:03:56 GMT+08:00 2023
     */
    int updateByPrimaryKey(UserPasswordDo record);
}