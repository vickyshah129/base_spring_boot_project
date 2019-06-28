package com.project.pagination;

import lombok.Data;

/**
 * @author Syed Waqas Faheem on 6/27/2019
 * @project employee-ms
 */

@Data
public class PaginationResponseModel {
    private PaginationModel paginationModel;
    private Object resultsetList;

    public PaginationResponseModel(PaginationModel paginationModel, Object resultsetList) {
        this.paginationModel = paginationModel;
        // do this in every constructor to match pageNo value with frontend
        this.paginationModel.incrementPageNo();

        this.resultsetList = resultsetList;
    }
}
