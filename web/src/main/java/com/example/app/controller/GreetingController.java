package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 基本：Spring フレームワーク の 新規プロジェクト作成
 */
@Controller
public class GreetingController {
    /** practice 1 */
    @RequestMapping(value = "/practice/greeting", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "みなさん、こんにちは！");
        return "/practice/greeting";
    }
}
