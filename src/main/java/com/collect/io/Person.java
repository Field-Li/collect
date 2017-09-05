package com.collect.io;

public class Person {
    private String name;
    private Integer age;
    private String  gender;
    private String occupation;

    public Person() {

    }

    public Person(String name, Integer age, String gender, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object obj){
        Person p = (Person)obj;
        if(p.getName().equals(this.getName()) && p.getAge() == this.getAge() && p.getGender().equals(this.getGender())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.getAge();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
