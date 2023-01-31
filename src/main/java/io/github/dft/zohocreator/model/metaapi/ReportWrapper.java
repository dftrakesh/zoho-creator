package io.github.dft.zohocreator.model.metaapi;

import lombok.Data;

import java.util.List;

@Data
public class ReportWrapper {
    public Integer code;
    public List<Report> reports;
}