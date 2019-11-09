package com.hello.wacai.data2.dao;

import com.hello.wacai.data2.dataobject.MengxiaotongAccountingRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface MengxiaotongAccountingRecordMapper {
    @Delete({
        "delete from mengxiaotong_accounting_record",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into mengxiaotong_accounting_record (id, gmt_created, ",
        "gmt_modified, from_user, ",
        "to_user, number, ",
        "message)",
        "values (#{id,jdbcType=VARCHAR}, now(), ",
        "now(), #{fromUser,jdbcType=VARCHAR}, ",
        "#{toUser,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER}, ",
        "#{message,jdbcType=VARCHAR})"
    })
    int insert(MengxiaotongAccountingRecord record);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from mengxiaotong_accounting_record",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user", property="toUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    MengxiaotongAccountingRecord selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from mengxiaotong_accounting_record"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user", property="toUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    List<MengxiaotongAccountingRecord> selectAll();

    @Update({
        "update mengxiaotong_accounting_record",
        "set,",
          "gmt_modified = now(),",
          "from_user = #{fromUser,jdbcType=VARCHAR},",
          "to_user = #{toUser,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=INTEGER},",
          "message = #{message,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MengxiaotongAccountingRecord record);
}