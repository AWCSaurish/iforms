package com.newgen.methods;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;

import org.apache.commons.codec.binary.Base64;




public class General
{
  String popullurl = null;
  String apiuser = null;
  String apipass = null;
  String polineurl = null;
  String pohisturl = null;
  String tokenurl = null;
  String mirourl = null;
  String currentdir = System.getProperty("user.dir");
  String finaldir = this.currentdir + File.separator + "Propertyfile" + File.separator + "RestApi.properties";
  
  public General()
  {
    try
    {
      InputStream is = new FileInputStream(this.finaldir);
      
      Properties prop = new Properties();
      prop.load(is);
      System.out.println("Current Directory :: " + this.finaldir);
      this.popullurl = prop.getProperty("POUrl");
      this.polineurl = prop.getProperty("POLineUrl");
      this.pohisturl = prop.getProperty("POHistoryUrl");
      this.apiuser = prop.getProperty("APIUser");
      this.apipass = prop.getProperty("APIPass");
      this.tokenurl = prop.getProperty("TokenUrl");
      this.mirourl = prop.getProperty("MIROUrl");
      
      System.out.println("PO URL ::: " + this.popullurl);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception Occured.. !!! " + e);
    }
  }
  
  public String getAuthString()
  {
    String authString = this.apiuser + ":" + this.apipass;
    byte[] authStringEnc = (byte[]) new Base64().encode(authString.getBytes());
    String s = new String(authStringEnc);     
    System.out.println("Base64 encoded auth string: " + s);
    return s;
  }
  
  public String poPullRequest(String filter, String url)
  {
    String authStringEnc = getAuthString();
    
    Client restClient = null;
    restClient = Client.create();
    WebResource webResource = restClient.resource("");
    
    ClientResponse resp = (ClientResponse)webResource.path(url).queryParam("$filter", filter).queryParam("$format", "json").header("Authorization", "Basic " + authStringEnc).get(ClientResponse.class);
    System.out.println("Status Code :: " + resp.getStatus());
    System.out.println("Response ::: " + resp.toString());
    
    String output = (String)resp.getEntity(String.class);
    resp.close();
    System.out.println("Response Output ::: " + output);
    return output;
  }
  
  public String tokenPullRequest()
  {
    String token = "";
    
    String authStringEnc = getAuthString();
    System.out.println("Base64 encoded auth string: " + authStringEnc);
    Client restClient = null;
    restClient = Client.create();
    WebResource webResource = restClient.resource("");
    
    ClientResponse resp = (ClientResponse)((WebResource.Builder)webResource.path(this.tokenurl).header("X-CSRF-Token", "fetch").header("Authorization", "Basic " + authStringEnc)).get(ClientResponse.class);
    System.out.println("Status Code :: " + resp.getStatus());
    System.out.println("Response ::: " + resp.toString());
    MultivaluedMap<String, String> head = resp.getHeaders();
    token = (String)head.getFirst("x-csrf-token");
    
    System.out.println("Response Output ::: " + (String)resp.getEntity(String.class));
    System.out.println("Token From Header ::: " + token);
    
    return token;
  }
  
  public String miroPosting(String input)
  {
    String token = null;
    String result = "";
    try
    {
      String authStringEnc = getAuthString();
      
      Client restClient = null;
      restClient = Client.create();
      WebResource webResource = restClient.resource("");
      
      ClientResponse resp = (ClientResponse)((WebResource.Builder)((WebResource.Builder)webResource.path(this.tokenurl).header("X-CSRF-Token", "fetch").header("Accept", "application/json")).header("Authorization", "Basic " + authStringEnc)).get(ClientResponse.class);
      System.out.println("Status Code :: " + resp.getStatus());
      System.out.println("Response ::: " + resp.toString());
      MultivaluedMap<String, String> head = resp.getHeaders();
      token = (String)head.getFirst("x-csrf-token");
      
      System.out.println("Response Output ::: " + (String)resp.getEntity(String.class));
      System.out.println("Token From Header ::: " + token);
      List<NewCookie> cookies = resp.getCookies();
      List<String> listcookie = new ArrayList();
      for (NewCookie cookie : cookies)
      {
        String value = cookie.toCookie().getValue();
        String name = cookie.toCookie().getName();
        System.out.println("Cookies :: " + name + "=" + value);
        listcookie.add(name + "=" + value);
      }
      result = tokenmiroposting(input, token, authStringEnc, listcookie);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception :: " + e);
    }
    return result;
  }
  
  String tokenmiroposting(String submitjson, String token, String authStringEnc, List<String> cookies)
  {
    String output = "";String output1 = "";
    int statusofmiro = 0;
    try
    {
      String input = submitjson;
      
      URL url = new URL(this.mirourl);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "*/*");
      for (String cookie : cookies) {
        conn.addRequestProperty("Cookie", cookie);
      }
      conn.setRequestProperty("X-CSRF-Token", token);
      
      OutputStream os = conn.getOutputStream();
      os.write(input.getBytes());
      os.flush();
      
      System.out.println("Status of MIRO::: " + conn.getResponseCode());
      statusofmiro = conn.getResponseCode();
      if (statusofmiro == 201)
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        System.out.println("Output from Server .... ");
        while ((output = br.readLine()) != null)
        {
          System.out.println(output);
          output1 = output1 + output;
        }
        System.out.println("output1 is::" + output1);
      }
      conn.disconnect();
    }
    catch (Exception e)
    {
      System.out.println("Exception Occured ::: " + e);
      e.printStackTrace();
    }
    return output1;
  }
  public String sapDateConverter(String formdate) {
		String newdate = "";
		try {

			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(formdate);
			newdate = format1.format(date1);
			newdate = newdate + "T00:00:00";
			System.out.println("New format date :: " + newdate);
		} catch (Exception e) {
			System.out.println("Exception ::: " + e);
		}
		return newdate;
	}

}
