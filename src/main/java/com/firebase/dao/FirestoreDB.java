package com.firebase.dao;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


public class FirestoreDB {
public static void getDB() {
	// Use the application default credentials
	GoogleCredentials credentials;
	try {
		credentials = GoogleCredentials.getApplicationDefault();
		FirebaseOptions options = new FirebaseOptions.Builder()
			    .setCredentials(credentials)
			    .setProjectId("solupark-49c06")
			    .build();
			FirebaseApp.initializeApp(options);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	//Firestore db = FirestoreClient.getFirestore();
	//return(db);
	}

public static void main(String arg[]) {
	getDB();
	}
}
