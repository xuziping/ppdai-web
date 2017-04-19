package work.touch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.touch.domain.Account;
import work.touch.domain.Result;
import work.touch.service.PpdaiService;
import work.touch.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Xu ZiPing on 2017/4/13.
 */
@RestController
public class PpdaiController {

    private final static Logger logger = LoggerFactory.getLogger(PpdaiController.class);

    @Autowired
    private PpdaiService ppdaiService;

    @RequestMapping(value = "/login")
    public String login (@Valid Account account, HttpServletRequest request, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
//        }

//        return ResultUtil.succ("");
        
        return "http://www.baidu.com";
    }
}
