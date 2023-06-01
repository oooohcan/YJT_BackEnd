package edu.web.yjt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.web.yjt_backend.common.ErrorCode;
import edu.web.yjt_backend.exception.BusinessException;
import edu.web.yjt_backend.model.domain.User;
import edu.web.yjt_backend.service.ProblemService;
import edu.web.yjt_backend.model.domain.Problem;
import edu.web.yjt_backend.mapper.ProblemMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SydZh
 * @description 针对表【problem(题目)】的数据库操作Service实现
 * @createDate 2023-05-04 18:17:39
 */
@Service
@Slf4j
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem>
        implements ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    @Override
    public List<Problem> getProblem(){
        return this.list();
    }
    @Override
    public List<Problem> searchProblem(Integer id, String title) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if (id != null && title != null) {
            queryWrapper.eq("id", id).like("title", title);
        }
        else if (id == null && title != null) {
            queryWrapper.like("title", title);
        }
        else if (id != null && title == null) {
            queryWrapper.eq("id", id);
        }
        else {
            return this.list(queryWrapper);
        }
        return this.list(queryWrapper);
    }

    @Override
    public List<Problem> pageProblem(int current, int pageSize) {
        Page<Problem> page = new Page<>(current, pageSize);
        Page<Problem> result = this.page(page);
        return result.getRecords();
    }

    @Override
    public long addProblem(String title, String author, String content, String answer, int label) {
        //1.校验
        if (StringUtils.isAnyBlank(title, author, content, answer)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (title.length() > 100) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题长度大于100");
        }
        if (content.length() > 600) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容长度大于600");
        }
        if (answer.length() > 600) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "答案长度大于600");
        }
        //2、插入题目到数据库
        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setAuthor(author);
        problem.setContent(content);
        problem.setAnswer(answer);
        problem.setLabel(label);
        boolean saveResult = this.save(problem);
        if (!saveResult) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "数据插入失败");
        }
        return 1;
    }

    @Override
    public boolean deleteProblem(long id, HttpServletRequest request) {
        if (id < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "Id小于0");
        }
        return this.removeById(id);
    }
}




