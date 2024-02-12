package org.example.dao;

import org.example.dataobject.SequenceDo;

public interface SequenceDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    int insert(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    int insertSelective(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    SequenceDo selectByPrimaryKey(String name);

    SequenceDo getSequenceByName(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    int updateByPrimaryKeySelective(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Feb 12 14:28:54 GMT+08:00 2024
     */
    int updateByPrimaryKey(SequenceDo record);
}