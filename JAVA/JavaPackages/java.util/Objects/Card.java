package com.util.objects;

import java.util.Objects;

public class Card {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Objects.requireNonNull(name, "null error");
		/*
		 * Exception in thread "main" java.lang.NullPointerException: null error
	at java.util.Objects.requireNonNull(Objects.java:228)
	at com.util.objects.Card.setName(Card.java:13)
	at com.util.objects.Overview.main(Overview.java:161)

		 */
	}
	
	
}
