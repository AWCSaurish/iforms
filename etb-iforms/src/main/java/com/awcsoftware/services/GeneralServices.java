package com.awcsoftware.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
@FunctionalInterface
public interface GeneralServices {
	public String createJson(Object obj);
	public static WebResource getWebResource() {
		return Client.create().resource("");
	}
}
