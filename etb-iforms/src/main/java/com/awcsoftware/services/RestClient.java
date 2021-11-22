package com.awcsoftware.services;

import com.awcsoftware.dto.po.POResponse;

public interface RestClient {
	public POResponse getPODetails(String filter);
}
