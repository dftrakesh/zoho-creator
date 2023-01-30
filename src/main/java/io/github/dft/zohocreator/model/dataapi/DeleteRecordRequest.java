package io.github.dft.zohocreator.model.dataapi;

import lombok.Data;

@Data
public class DeleteRecordRequest {
    private Result result;
    private String criteria;
    private String formLinkName;
}
