package edu.web.yjt_backend.service;

import edu.web.yjt_backend.model.domain.Problem;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author SydZh
* @description 针对表【problem(题目)】的数据库操作Service
* @createDate 2023-05-04 18:17:39
*/
public interface ProblemService extends IService<Problem> {
    List<Problem> getProblem();
    List<Problem> searchProblem(Integer id, String title);
    List<Problem> pageProblem(int current,int pageSize);
    long addProblem(String title,String author,String content,String answer,int label);
    boolean deleteProblem(long id,HttpServletRequest request);
}
