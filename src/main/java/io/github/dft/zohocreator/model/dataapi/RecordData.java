package io.github.dft.zohocreator.model.dataapi;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class RecordData {
    private Result result;
    private List<HashMap<String, Object>> data;
}