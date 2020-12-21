package org.hanabank.service;

import java.util.ArrayList;
import java.util.List;

import org.hanabank.object.createAccount.Event;

import com.google.gson.Gson;

public class completeMessageService {

	public void requiredAction() {
		Event eventClass = new Event();
		List<String> stringArray = new ArrayList<String>();
		Gson gson = new Gson();
		stringArray.add("A");
		stringArray.add("B");
		String jsonStr = gson.toJson(stringArray);
//		eventClass.setRequiredAction(jsonStr);
		System.out.println("This is list of json str " + jsonStr);
	}
}
