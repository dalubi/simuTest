package com.example.simutest.controller;

import com.example.simutest.util.AjaxResponse;
import com.example.simutest.util.GlobalConfig;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class federateObjectCreateTable {

    @RequestMapping(value = "/activiti/createTable" , method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse createInstance(){
        //构造伪造数据
        String parameterName = "name1,name2,name3,name4";
        String parameterType = "int,string,double,boolean";
        String tableName = "objectName";
        String[] Names = parameterName.split(",");
        String[] Types = parameterType.split(",");

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(tableName).append("(");
        sb.append("Id_Show int,");
        for(int i=0;i<Names.length;i++){
            sb.append(Names[i]+" ");
            if(Types[i].equals("string")){
                sb.append("varchar(255)");
            }else{
                sb.append(Types[i]);
            }
        }
        sb.append(")");
        System.out.println(sb);

        return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(),
                GlobalConfig.ResponseCode.SUCCESS.getDesc(),
                "success");
    }

    public static void main(String[] args) {
        String parameterName = "name1,name2,name3,name4";
        String parameterType = "int,string,double,boolean";
        String tableName = "objectName";
        String[] Names = parameterName.split(",");
        String[] Types = parameterType.split(",");

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(tableName).append("(");
        sb.append("id_show int,");
        for(int i=0;i<Names.length;i++){
            sb.append(Names[i]+" ");
            if(Types[i].equals("string")){
                sb.append("varchar(255)");
            }else if(Types[i].equals("boolean")){
                sb.append("varchar(255)");
            }else if(Types[i].equals("double")){
                sb.append("double(16,2)");
            }else{
                sb.append(Types[i]);
            }
            sb.append(",");
        }
        sb.append("PRIMARY KEY (id_show)");
        sb.append(")");
        System.out.println(sb);
    }
}
