package edu.web.yjt_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.web.yjt_backend.model.domain.Paper;
import edu.web.yjt_backend.service.PaperService;
import edu.web.yjt_backend.mapper.PaperMapper;
import org.springframework.stereotype.Service;

/**
* @author SydZh
* @description 针对表【paper(试卷)】的数据库操作Service实现
* @createDate 2023-05-30 20:37:33
*/
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper>
    implements PaperService{

}




