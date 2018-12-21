package com.biz.std.controller;

import com.biz.std.service.GradeService;
import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.grade.GradeListVo;
import com.biz.std.vo.grade.GradeOperateVo;
import com.biz.std.vo.grade.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 班级信息的控制器
 * GradeController class
 * @author junzhang
 * @date 2018-12-20
 */
@Controller
@RequestMapping(value = "grade")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * 班级信息列表
     */
    @RequestMapping(value = "list")
    public ModelAndView list(PageReqVo reqVo) {
        ModelAndView modelAndView = new ModelAndView("grade/list");
        GradeListVo gradeListVo = gradeService.findGradeList(reqVo);
        modelAndView.addObject("gradeListVo", gradeListVo);
        return modelAndView;
    }

    /**
     * 添加班级信息页面
     */
    @RequestMapping(value = "new")
    public String newStudent() {
        return "grade/new";
    }

    /**
     * 执行添加班级操作
     */
    @RequestMapping(value = "save")
    public ModelAndView save(GradeVo gradeVo) {
        GradeVo existGradeVo = gradeService.getGrade(gradeVo.getName());
        if (existGradeVo == null){
            gradeService.saveGrade(gradeVo);
            return new ModelAndView("redirect:list.do");
        }else{
            ModelAndView modelAndView = new ModelAndView("grade/new");
            GradeOperateVo gradeOperateVo = addObject(gradeVo);
            modelAndView.addObject("gradeOperateVo",gradeOperateVo);
            return modelAndView;
        }
    }

    /**
     * 修改班级信息页面
     */
    @RequestMapping(value = "toUpdate")
    public ModelAndView toUpdate(GradeVo gradeVo) {
        ModelAndView modelAndView = new ModelAndView("grade/update");
        gradeVo = gradeService.getGrade(gradeVo.getId());
        GradeOperateVo gradeOperateVo = new GradeOperateVo();
        gradeOperateVo.setGradeVo(gradeVo);
        modelAndView.addObject("gradeOperateVo",gradeOperateVo);
        return modelAndView;
    }

    /**
     * 执行修改班级信息操作
     */
    @RequestMapping(value = "update")
    public ModelAndView update(GradeVo gradeVo) {
        GradeVo existGradeVo = gradeService.getGrade(gradeVo.getName());
        if (existGradeVo == null){
            gradeService.saveGrade(gradeVo);
            return new ModelAndView("redirect:list.do");
        }else{
            ModelAndView modelAndView = new ModelAndView("grade/update");
            GradeOperateVo gradeOperateVo = addObject(gradeVo);
            modelAndView.addObject("gradeOperateVo", gradeOperateVo);
            return modelAndView;
        }
    }

    /**
     * 删除班级信息
     */
    @RequestMapping(value = "delete")
    public String delete(GradeVo gradeVo){
        gradeService.deleteGrade(gradeVo.getId());
        return "redirect:list.do";
    }

    private GradeOperateVo addObject(GradeVo gradeVo){
        GradeOperateVo gradeOperateVo = new GradeOperateVo();
        gradeOperateVo.setGradeVo(gradeVo);
        gradeOperateVo.setError("班级名已经存在!");
        return gradeOperateVo;
    }
}
