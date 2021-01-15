package com.example.simutest.controller;

import com.example.simutest.util.AjaxResponse;
import com.example.simutest.util.GlobalConfig;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class createActivitiInstance {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(value = "/activiti/createInstance" , method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse createInstance(){
        String filename = "processes/Part1_deployment.bpmn";
        //注意是repository的deployment
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(filename)
                .name("Test")
                .deploy();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_Part1");
        System.out.println(processInstance.getName());
        return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(),
                GlobalConfig.ResponseCode.SUCCESS.getDesc(),
                "success");
    }

}
