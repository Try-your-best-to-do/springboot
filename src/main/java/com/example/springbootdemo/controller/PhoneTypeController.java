package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.PhoneType;
import com.example.springbootdemo.service.PhoneTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;


@Controller
public class PhoneTypeController {
    @Resource
    private PhoneTypeService phoneTypeService;
    @RequestMapping("/find")
    public String operatingPhone(Model model){
        List<PhoneType> phoneTypes = phoneTypeService.findAll();
        model.addAttribute("phones",phoneTypes);
        return "search";
    }

    @RequestMapping("/findById")
    public String findById(String id,Model model){
        PhoneType phoneTypes = phoneTypeService.findById(id);
        model.addAttribute("phones",phoneTypes);
        return "search";
    }
    @RequestMapping("/update")
    public String update(PhoneType phoneType,Model model){
        PhoneType phoneTypes = phoneTypeService.save(phoneType);
        model.addAttribute("phones",phoneTypes);
        return "search";
    }

    @RequestMapping("/add")
    public String add(PhoneType phoneType,Model model){
        PhoneType phoneTypes = phoneTypeService.save(phoneType);
        model.addAttribute("phones",phoneTypes);
        return "search";
    }

    @RequestMapping("/delete")
    public String delete(String id,Model model){
         phoneTypeService.delete(id);
        PhoneType phoneTypes = new PhoneType();
         model.addAttribute("phones",phoneTypes);
        return "search";
    }
}
