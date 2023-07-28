package com.cj.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class teacher {
    private int id;
    private String name;
    private List<student> students;
}
