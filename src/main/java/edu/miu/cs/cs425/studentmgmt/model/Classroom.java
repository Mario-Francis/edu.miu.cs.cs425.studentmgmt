package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    @NotBlank(message = "Building name is required")
    private String buildingName;
    private String roomNumber;

    public Classroom() {
    }

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public Classroom(Integer id, String buildingName, String roomNumber) {
        this.classroomId = id;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + classroomId +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
