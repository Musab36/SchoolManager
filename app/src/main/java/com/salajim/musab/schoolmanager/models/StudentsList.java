package com.salajim.musab.schoolmanager.models;

public class StudentsList {
    private String id;
    private String name;
    private String type;
    private String parent;
    private String admission_number;
    private String clas;
    private String attendence;


    public StudentsList(String id, String name, String type, String parent, String admission_number, String clas, String attendence) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.admission_number = admission_number;
        this.clas = clas;
        this.attendence = attendence;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getParent() {
        return parent;
    }

    public String getAdmission_number() {
        return admission_number;
    }

    public String getClas() {
        return clas;
    }

    public String getAttendence() {
        return attendence;
    }

}
