package com.project.pagination;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * @author Syed Waqas Faheem
 */

@Data
public class PaginationModel implements Serializable {
    private static final long serialVersionUID = 7059945306873740626L;
    private boolean rowCountRequired;
    private Integer pageNo;
    private Integer pageSize;
    public Long totalRecordsCount;

    public PaginationModel() {
        this.rowCountRequired = false;
    }

    public PaginationModel(Integer pageNo, Integer pageSize, boolean rowCountRequired, Long totalRecordsCount) {
        this.rowCountRequired = false;
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setRowCountRequired(rowCountRequired);
        this.setTotalRecordsCount(totalRecordsCount);
    }

    public PaginationModel(Integer pageNo, Integer pageSize, boolean rowCountRequired) {
        this(pageNo, pageSize, rowCountRequired, (Long)null);
    }

    public boolean isFirstPage() {
        boolean result = false;
        if (this.pageNo != null && this.pageNo == 1) {
            result = true;
        }

        return result;
    }

    public boolean isLastPage() {
        boolean result = false;
        if (this.pageNo != null && this.pageSize != null && this.totalRecordsCount != null) {
            result = this.pageNo * this.pageSize >= this.totalRecordsCount;
        }

        return result;
    }

    public Pageable translateToPageable(){
        this.decrementPageNo();
        return PageRequest.of(this.pageNo, this.pageSize);
    }

    public void incrementPageNo(){
        this.setPageNo(this.pageNo+1);
    }

    public void decrementPageNo(){
        this.setPageNo(this.pageNo-1);
    }
}
