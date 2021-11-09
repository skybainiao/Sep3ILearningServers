package com.example.ILearningServer;

import com.example.ILearningServer.PostSystem.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@SpringBootApplication
public class ILearningServerApplication {

	public static void main(String[] args)
			throws RemoteException, NotBoundException, SQLException
	{
		SpringApplication.run(ILearningServerApplication.class, args);

		UserController userController = new UserController();


	}

}
