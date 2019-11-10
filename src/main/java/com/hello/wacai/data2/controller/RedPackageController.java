package com.hello.wacai.data2.controller;

import com.hello.wacai.data2.dao.MengxiaotongAccountingRecordMapper;
import com.hello.wacai.data2.dataobject.MengxiaotongAccountingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedPackageController {

    @Autowired
    MengxiaotongAccountingRecordMapper mengxiaotongAccountingRecordMapper;

    @RequestMapping( "/add")
    public String add(){
        MengxiaotongAccountingRecord redPackage=new MengxiaotongAccountingRecord();
        redPackage.setFromUser("zhangsan");
        redPackage.setToUser("lisi");
        redPackage.setNumber(100);
        redPackage.setMessage("hello");
        mengxiaotongAccountingRecordMapper.insert(redPackage);
        return "success";

    }
    @RequestMapping("/list")
    public List<MengxiaotongAccountingRecord> list(){
        List<MengxiaotongAccountingRecord> redPackage=mengxiaotongAccountingRecordMapper.selectAll();
        return redPackage;
    }
    @RequestMapping("/select")
    public List<MengxiaotongAccountingRecord> select(){
        List<MengxiaotongAccountingRecord> redPackage=mengxiaotongAccountingRecordMapper.select("zhangsan");
        return redPackage;
    }
    @RequestMapping(path="/query")
    public String query(){
        MengxiaotongAccountingRecord redpackageRecord=new MengxiaotongAccountingRecord();
        redpackageRecord.setId(4);
        redpackageRecord.setFromUser("zhangsan");
        redpackageRecord.setToUser("lisi");
        redpackageRecord.setNumber(100);
        redpackageRecord.setMessage("hello");
        mengxiaotongAccountingRecordMapper.query(redpackageRecord);
        return "sucess";
    }
    @RequestMapping(path="/modify")
    public String modify(){
        MengxiaotongAccountingRecord modifyModel=new MengxiaotongAccountingRecord();
        modifyModel.setId(1);
        modifyModel.setFromUser("zhangsan");
        modifyModel.setToUser("libai");
        modifyModel.setNumber(100);
        modifyModel.setMessage("facuole");
        mengxiaotongAccountingRecordMapper.updateByPrimaryKey(modifyModel);
        return "sucess";
    }
    @RequestMapping(path="/delete")
    public String delete(){
       mengxiaotongAccountingRecordMapper.deleteByPrimaryKey(1);
       return "sucess";
    }

}
