package edu.web.yjt_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.web.yjt_backend.mapper.ProblemMapper;
import edu.web.yjt_backend.model.domain.Paper;
import edu.web.yjt_backend.model.domain.Problem;
import edu.web.yjt_backend.service.PaperService;
import edu.web.yjt_backend.service.ProblemService;
import edu.web.yjt_backend.mapper.PaperMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SydZh
 * @description 针对表【paper(试卷)】的数据库操作Service实现
 * @createDate 2023-05-30 20:37:33
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper>
        implements PaperService {
    @Resource
    private PaperMapper paperMapper;
    private ProblemService problemService;

    @Override
    public List<Paper> getPaper() {
        return this.list();
    }

    @Override
    public List<Problem> paperProblem(long id) {
        Paper paper = this.getById(id);
        String que = paper.getQuestions();
        String[] ques = que.split(",");
        List<Long> queIds = new ArrayList<>();
        for (String s : ques) {
            queIds.add(Long.parseLong(s));
        }
        List<Problem> questions = new ArrayList<>();
        for (long qid : queIds) {
            questions.add(problemService.getById(qid));
        }
        return questions;
    }
}




