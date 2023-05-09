package edu.web.yjt_backend.service;

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

    @Test
    public void getProblem(){
            List<Problem> problemList = problemService.getProblem();
            System.out.println(problemList);
    }

    @Test
    void addProblem(){
        long result =  problemService.addProblem("加题目测试","admin","内容要你猜","答案自在人心",0);
        Assertions.assertEquals(1,result);
    }
}