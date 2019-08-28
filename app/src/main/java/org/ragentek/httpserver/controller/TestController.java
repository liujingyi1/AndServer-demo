/*
 * Copyright 2018 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ragentek.httpserver.controller;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.andserver.annotation.FormPart;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PathVariable;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestBody;
import com.yanzhenjie.andserver.annotation.RequestMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.util.MediaType;

import org.ragentek.httpserver.model.UserInfo;

import java.util.List;

/**
 * Created by YanZhenjie on 2018/6/9.
 */
@RestController
@RequestMapping(path = "/user")
class TestController {

    @GetMapping("/login")
    String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        Log.i("jingyi", "account="+account+" password="+password);
        return "success....";
    }

    @GetMapping(path = "/get/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String info(@PathVariable(name = "userId") String userId) {
        return userId;
    }

//    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    String login(HttpRequest request, HttpResponse response, @RequestParam(name = "account") String account,
//                 @RequestParam(name = "password") String password) {
//        Session session = request.getValidSession();
//        session.setAttribute(LoginInterceptor.LOGIN_ATTRIBUTE, true);
//
//        Cookie cookie = new Cookie("account", account + "=" + password);
//        response.addCookie(cookie);
//        return "Login successful.";
//    }

//    @Addition(stringType = "login", booleanType = true)
//    @GetMapping(path = "/userInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    UserInfo userInfo(@CookieValue("account") String account) {
//        Log.i("Account: " + account);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId("123");
//        userInfo.setUserName("AndServer");
//        return userInfo;
//    }
//
//    @PostMapping(path = "/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    String upload(@RequestParam(name = "header") MultipartFile file) throws IOException {
//        File localFile = FileUtils.createRandomFile(file);
//        file.transferTo(localFile);
//        return localFile.getAbsolutePath();
//    }

    @GetMapping(path = "/consume", consumes = {"application/json", "!application/xml"})
    String consume() {
        return "Consume is successful";
    }

    @GetMapping(path = "/jingyi")
    String testInterface(@RequestParam("account") String account, @RequestParam("password") String password) {

        Log.i("jingyi", "testInterface .........");
        Log.i("jingyi", "testInterface account="+account+" password="+password);

        return "testInterface is successful hahaha";
    }

    @GetMapping(path = "/produce", produces = {"application/json; charset=utf-8"})
    String produce() {
        return "Produce is successful";
    }

    @GetMapping(path = "/include", params = {"name=123"})
    String include(@RequestParam(name = "name") String name) {
        return name;
    }

    @GetMapping(path = "/exclude", params = "name!=123")
    String exclude() {
        return "Exclude is successful.";
    }

    @GetMapping(path = {"/mustKey", "/getName"}, params = "name")
    String getMustKey(@RequestParam(name = "name") String name) {
        return name;
    }

    @PostMapping(path = {"/mustKey", "/postName"}, params = "name")
    String postMustKey(@RequestParam(name = "name") String name) {
        return name;
    }

    @GetMapping(path = "/noName", params = "!name")
    String noName() {
        return "NoName is successful.";
    }

    @PostMapping(path = "/formPart")
    String forPart(@FormPart(name = "user") UserInfo userInfo) {
        return JSON.toJSONString(userInfo);
    }

    @PostMapping(path = "/jsonBody")
    String jsonBody(@RequestBody UserInfo userInfo) {
        return JSON.toJSONString(userInfo);
    }

    @PostMapping(path = "/listBody")
    String jsonBody(@RequestBody List<UserInfo> infoList) {
        return JSON.toJSONString(infoList);
    }
}