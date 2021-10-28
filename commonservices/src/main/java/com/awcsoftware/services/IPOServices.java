package com.awcsoftware.services;

import java.util.List;

import com.awcsoftware.dto.POResponse;
import com.awcsoftware.dto.poheader.Result;

public interface IPOServices {
	public List<Result> getPoHeader(String filter);
	public List<com.awcsoftware.dto.poline.Result> getPOLines(String filter) ;
	public POResponse getPODetails(String filter) ;
	public void getPOHistory(String filter) ;
}
