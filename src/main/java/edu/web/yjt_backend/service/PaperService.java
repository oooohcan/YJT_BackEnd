package edu.web.yjt_backend.service;

import edu.web.yjt_backend.model.domain.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.web.yjt_backend.model.domain.Problem;

import java.util.List;

/**
 * @author SydZh
 * @description 针对表【paper(试卷)】的数据库操作Service
 * @createDate 2023-05-30 20:37:33
 */
public interface PaperService extends IService<Paper> {
    List<Paper> getPaper();

    List<Problem> paperProblem(long id);

    Long addPaper(String name, long author, String des, byte isPub, List<Long> ques);

    boolean delPaper(long pid, long uid);

    List<Paper> pagePaper(int current, int pageSize);

    List<Paper> searchPaper(Integer id, String name);
}
