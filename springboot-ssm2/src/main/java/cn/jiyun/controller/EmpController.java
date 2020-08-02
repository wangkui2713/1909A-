package cn.jiyun.controller;

import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Emp;
import cn.jiyun.service.DeptService;
import cn.jiyun.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Value("C:\\Users\\admin\\Pictures\\Saved Pictures")
    private String filePath;




    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;
    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "hello world";
    }
    @GetMapping("toAddEmp")
    public String toAddEmp(Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return "addEmp";
    }

    @PostMapping("addEmp")
    public String addEmp(@ModelAttribute(value="emp") Emp emp,
                         @RequestParam(value="file")MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File photoFile = new File(filePath, fileName);
        System.out.println("22222222"+photoFile);
        if(!photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(fileName));

        emp.setPhoto(fileName);
        empService.addEmp(emp);
        System.out.println("ddd:"+emp);
        return "redirect:/emp/findAll";

    }

    @GetMapping("findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        //System.out.println("ccc:"+emps);

        model.addAttribute("emps",emps);
        return "empList";
    }
    @GetMapping("delEmpById")
    public String deleteEmp(@RequestParam(value="eid")Integer eid){
        empService.delEmpById(eid);
        return "redirect:/emp/findAll";
    }






    @GetMapping("updateEmpId")
    public String toUpeateEmp(Model model,@RequestParam(value="eid")Integer eid){

        Emp emp=empService.findEmpById(eid);
        List<Dept> depts = deptService.findAll();
        model.addAttribute("emp",emp);
        model.addAttribute("depts",depts);
        return "updateEmp";
    }


    @PostMapping("updateEmp")
    public String updateEmp(@ModelAttribute(value="emp") Emp emp,
                         @RequestParam(value="file")MultipartFile file) throws IOException {
        System.out.println(emp);
        String fileName = file.getOriginalFilename();
        File photoFile = new File(filePath, fileName);
        System.out.println("22222222"+photoFile);
        if(!photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(fileName));

        emp.setPhoto(fileName);
      //  empService.addEmp(emp);
        empService.updateEmp(emp);
        System.out.println("ddd:"+emp);
        return "redirect:/emp/findAll";

    }



}
