package edu.web.yjt_backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.web.yjt_backend.mapper.ProblemMapper;
import edu.web.yjt_backend.model.domain.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
public class ProblemServiceTest {
    @Resource
    ProblemService problemService;

    @Resource
    ProblemMapper problemMapper;

    @Test
    public void getProblem(){
        List<Problem> problemList = problemService.getProblem();
        System.out.println(problemList);
    }

    @Test
    public void searchProblem(){
            List<Problem> problemList = problemService.searchProblem(1,"s");
            System.out.println(problemList);
    }

    @Test
    void addProblem(){
        long result =  problemService.addProblem("加题目测试2","admin","内容要你猜","答案自在人心",0);
        Assertions.assertEquals(1,result);
    }

    @Test
    void pageProblem(){
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        Page<Problem> page = new Page<>(2,9);
        Page<Problem> result = problemMapper.selectPage(page,queryWrapper);
        long total = result.getTotal();
        //System.out.println("total是总数"+total);
        System.out.println("result出来怎么是地址"+result);
        System.out.println("结果展示"+result.getRecords());
    }
}