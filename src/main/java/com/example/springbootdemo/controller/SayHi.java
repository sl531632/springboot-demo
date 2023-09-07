package com.example.springbootdemo.controller;


import org.nutz.lang.Times;
import org.nutz.lang.util.NutMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.util.Date;

@Controller
public class SayHi {

    @Autowired
    private GitProperties gitProperties;

    @ResponseBody
    @GetMapping("/")
    public NutMap getInfo() {

        NutMap rs = new NutMap();

        // 获取机器信息
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            rs.setv("Hostname", inetAddress.getHostName());
            rs.setv("IP", inetAddress.getHostAddress());
        } catch (Exception e) {
            rs.setv("err", "无法获取Hostname和IP");
        }

        // 获取Git信息
        rs.setv("Git Branch", gitProperties.getBranch());
        rs.setv("Git Commit ID", gitProperties.getCommitId());
        rs.setv("Now", Times.sDT(new Date()));
        rs.setv("version", "main  总推送最新版本 ");

        return rs;

    }


}
