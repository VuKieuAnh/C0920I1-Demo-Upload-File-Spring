package model;

public class Student {
    private Long id;
    private String name;
    private String address;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public Student(String name, String address, String avatar) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Student(Long id, String name, String address, String avatar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avatar = avatar;
    }

    public Student(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}