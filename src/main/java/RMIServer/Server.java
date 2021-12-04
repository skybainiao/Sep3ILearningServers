package RMIServer;

import Model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Server extends Remote
{
  void addUser(User user) throws RemoteException, SQLException;

  ArrayList<User> getAllUser() throws RemoteException, SQLException;

  void sendMessage(String senderName,String receiveName,String text) throws SQLException,RemoteException;

  ArrayList<Message> getAllMessage(String senderName, String receiveName) throws SQLException,RemoteException;

  ArrayList<User> getAllFriends(String username) throws SQLException,RemoteException;

  void increase(String username) throws SQLException,RemoteException;

  int getNum(String username) throws SQLException,RemoteException;

  void addFriend(String username,String friendName) throws SQLException,RemoteException;

  void clearMessageNum(String username) throws SQLException,RemoteException;

  void sendFriendRequest(String sender,String receiver,String comment) throws SQLException,RemoteException;

  ArrayList<Request> getRequest(String username) throws SQLException,RemoteException;

  void addProfile(Profile profile) throws SQLException,RemoteException;

  ArrayList<Profile> getProfiles() throws SQLException,RemoteException;

  void deleteProfile(String username) throws SQLException,RemoteException;

  void addLecturerAccount(LecturerAccount lecturerAccount) throws SQLException,RemoteException;

  ArrayList<LecturerAccount> getAllLecturerAccounts() throws SQLException,RemoteException;

  ArrayList<Message> getAllMessageByReceiver(String receiver) throws SQLException,RemoteException;

  void deleteRequest(String sender,String receiver) throws SQLException,RemoteException;

  ArrayList<Course> getCourses(String courseName) throws SQLException,RemoteException;

  ArrayList<Announcement> getAnnouncement(String courseName) throws SQLException,RemoteException;

  ArrayList<Moment> getAllMoments() throws SQLException,RemoteException;

  void addMoment(Moment moment) throws SQLException,RemoteException;

  void like(String username) throws SQLException,RemoteException;

  void dislike(String username) throws SQLException,RemoteException;

  ArrayList<Message> getAllMessagesWithoutEverything() throws SQLException,RemoteException;

  void addComment(Comment comment) throws SQLException,RemoteException;

  ArrayList<Comment> getAllComments(String username,String publisher,String time) throws SQLException,RemoteException;

  ArrayList<Group> groups() throws SQLException,RemoteException;

  ArrayList<String> getGroupName() throws SQLException,RemoteException;

  ArrayList<String> getGroupMember(String username) throws SQLException,RemoteException;

}
