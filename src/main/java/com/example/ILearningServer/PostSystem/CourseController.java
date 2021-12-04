package com.example.ILearningServer.PostSystem;

import Model.Course;
import RMIClient.Client;
import RMIClient.ClientImpl;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@RestController
public class CourseController
{

  private Gson gson;
  private Client client;

  public CourseController() throws RemoteException, NotBoundException
  {
    gson = new Gson();
    client = new ClientImpl();
  }


  @GetMapping("/getCourses")
  public String getCourses(@RequestParam String courseName)
      throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getCourses(courseName));
    System.out.println(courseName);

    return str;
  }


  @GetMapping("/getAnnouncement")
  public String getAnnouncement(@RequestParam String courseName)
      throws SQLException, RemoteException
  {
    String str = gson.toJson(client.getAnnouncement(courseName));

    return str;
  }


  @PostMapping("/addCourse")
  public void addCourse(@RequestParam String course)
      throws SQLException, RemoteException
  {
    Course course1 = gson.fromJson(course,Course.class);
    client.addCourse(course1);
  }





}
