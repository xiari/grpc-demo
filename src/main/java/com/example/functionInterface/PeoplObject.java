package com.example.functionInterface;

public class PeoplObject {

    public enum CareerType{
        Dockor, Teacher, Student;
    }

    public static class People{

        private CareerType careerType;

        private int age;

        public People(CareerType careerType, int age){
            this.careerType = careerType;
            this.age = age;
        }

        public CareerType getCareerType() {
            return careerType;
        }

        public void setCareerType(CareerType careerType) {
            this.careerType = careerType;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "People{" +
                    "careerType=" + careerType +
                    ", age=" + age +
                    '}';
        }
    }

}
