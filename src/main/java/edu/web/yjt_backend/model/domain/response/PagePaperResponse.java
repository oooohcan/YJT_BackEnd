package edu.web.yjt_backend.model.domain.response;

import edu.web.yjt_backend.model.domain.Paper;

import java.util.List;

public class PagePaperResponse {
    public List<Paper> papers;
    public long total;

    public PagePaperResponse(List<Paper> papers, long size) {
        this.papers = papers;
        this.total = size;
    }
}
