package models;

import lombok.Data;

@Data
public class Cases {
    private int id;
    private String title;
    private  int sectionId;
    private int suiteId;
    private Case[] cases;
}
