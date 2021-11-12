package com.awcsoftware.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public interface GeneralServices {
	public static WebResource getWebResource() {
		return Client.create().resource("");
	}
}
