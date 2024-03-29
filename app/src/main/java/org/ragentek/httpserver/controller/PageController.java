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

import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;

/**
 * Created by YanZhenjie on 2018/9/12.
 */
@Controller
public class PageController {

    @GetMapping(path = "/")
    public String index() {
        // Equivalent to [return "/index"].
        return "forward:/index2.html";
    }

//    @GetMapping(path = "/device.html")
//    public String device() {
//        // Equivalent to [return "/index"].
//        Log.i("jingyi", "1231231231");
//        return "";
//    }
}