package com.hello.wacai.data2.dao;

import com.hello.wacai.data2.dataobject.AccountingRecord;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface AccountingRecordMapper {
    @Delete({
        "delete from accounting_record",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into accounting_record (id, gmt_created, ",
        "gmt_modified, from_user, ",
        "to_user, number, ",
        "message)",
        "values (#{id,jdbcType=VARCHAR}, now(), ",
        "now(), #{fromUser,jdbcType=VARCHAR}, ",
        "#{toUser,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER}, ",
        "#{message,jdbcType=VARCHAR})"
    })
    int insert(AccountingRecord record);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from accounting_record",
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
    AccountingRecord selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from accounting_record"
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
    List<AccountingRecord> selectAll();

    @Update({
        "update accounting_record",
        "set,",
          "now(),",
          "from_user = #{fromUser,jdbcType=VARCHAR},",
          "to_user = #{toUser,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=INTEGER},",
          "message = #{message,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccountingRecord record);
}