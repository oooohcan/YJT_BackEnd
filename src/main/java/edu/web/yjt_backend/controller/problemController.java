package edu.web.yjt_backend.controller;

import edu.web.yjt_backend.common.BaseRespone;
import edu.web.yjt_backend.common.ResultUtils;
import edu.web.yjt_backend.model.domain.Problem;
import edu.web.yjt_backend.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/problem")
//下面这个允许跨域的前端ip需要具体改
@CrossOrigin(origins = {"http://localhost:8000"}, allowCredentials = "true")
public class problemController {
    @Resource
    private ProblemService problemService;

    @GetMapping("/getProblem")
    public BaseRespone<List<Problem>> getProbelm(){
        List<Problem> problemList = problemService.getProblem();
        return ResultUtils.success(problemList);
    }

}
