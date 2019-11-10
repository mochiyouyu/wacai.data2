package com.hello.wacai.data2.dao;

import com.hello.wacai.data2.dataobject.MengxiaotongAccountingRecord;
import org.apache.ibatis.jdbc.SQL;

public class QueryBuilder {
    public String QueryBuilder(MengxiaotongAccountingRecord redpackage){
        return new SQL(){
            {
                UPDATE("mengxiaotong_accounting_record");
                  SET("gmt_modified = now()","from_user = #{fromUser},","to_user = #{toUser},","number = #{number},","message = #{message") ;
                if(redpackage.getToUser()!=null&&redpackage.getFromUser()!=null&&redpackage.getMessage()!=null&&redpackage.getNumber()!=null)
                   WHERE("id = #{id}");
            }
        }.toString();
    }
}
