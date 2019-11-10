package com.hello.wacai.data2.dao;

import com.hello.wacai.data2.dataobject.MengxiaotongAccountingRecord;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface MengxiaotongAccountingRecordMapper {
    @Delete({
        "delete from mengxiaotong_accounting_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mengxiaotong_accounting_record (id, gmt_created, ",
        "gmt_modified, from_user, ",
        "to_user, number, ",
        "message)",
        "values (#{id,jdbcType=INTEGER}, now(), ",
        "now(), #{fromUser,jdbcType=VARCHAR}, ",
        "#{toUser,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER}, ",
        "#{message,jdbcType=VARCHAR})"
    })
    int insert(MengxiaotongAccountingRecord record);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from mengxiaotong_accounting_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user", property="toUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    MengxiaotongAccountingRecord selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, gmt_created, gmt_modified, from_user, to_user, number, message",
        "from mengxiaotong_accounting_record"
    })
    @Results(id="redPackageMap",value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="from_user", property="fromUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user", property="toUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR)
    })
    List<MengxiaotongAccountingRecord> selectAll();

    @Select({
            "select",
            "id, gmt_created, gmt_modified, from_user, to_user, number, message",
            "from mengxiaotong_accounting_record",
            "where from_user=#{from_user}"
    })
    @ResultMap("redPackageMap")
    List<MengxiaotongAccountingRecord> select(@Param("from_user") String from_user);

    @Update({
        "update mengxiaotong_accounting_record",
          "set gmt_modified = now(),",
          "from_user = #{fromUser,jdbcType=VARCHAR},",
          "to_user = #{toUser,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=INTEGER},",
          "message = #{message,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MengxiaotongAccountingRecord record);
    @SelectProvider(type = QueryBuilder.class, method = "QueryBuilder")
    @ResultMap("redPackageMap")
    int query(@Param("redpackage") MengxiaotongAccountingRecord redpackage);
}