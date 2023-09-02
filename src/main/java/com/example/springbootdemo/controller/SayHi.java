package com.example.springbootdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.util.Map;

@Controller
public class SayHi {


    @Autowired
    private GitProperties gitProperties;
    
    @GetMapping("/info")
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        // 获取机器信息
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            sb.append("Hostname: ").append(inetAddress.getHostName()).append("\n");
            sb.append("IP: ").append(inetAddress.getHostAddress()).append("\n");
        } catch (Exception e) {
            sb.append("无法获取Hostname和IP\n");
        }

        // 获取Git信息
        sb.append("Git Branch: ").append(gitProperties.getBranch()).append("\n");
        sb.append("Git Commit ID: ").append(gitProperties.getCommitId()).append("\n");

        return sb.toString();
    }


}
