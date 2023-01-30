package io.github.dft.zohocreator.model.dataapi;

import lombok.Data;

@Data
public class AddRecordRequest {
    private RecordData data;
    private String formLinkName;
}
