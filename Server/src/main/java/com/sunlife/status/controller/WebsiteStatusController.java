package com.sunlife.status.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunlife.status.model.StatusBean;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class WebsiteStatusController {
	
	private final Logger log = LoggerFactory.getLogger(WebsiteStatusController.class);
	
	// Check Amazon status
	@GetMapping(path="/amazon-status", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusBean> getAmazonStatus() throws IOException, MalformedURLException{
		
		URL url = new URL("https://www.amazon.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		StatusBean statusBean = new StatusBean();
		HttpHeaders headers = new HttpHeaders();
		
		  try {		    
			  	Instant start = Instant.now();
		        connection.connect();        
				statusBean.setUrl(url.toString());
				statusBean.setStatusCode(connection.getResponseCode());
				statusBean.setDate(connection.getDate());
				
				Instant finish = Instant.now();
				long duration = Duration.between(start, finish).toMillis();
				statusBean.setDuration(duration);
		       
		        } catch (SocketTimeoutException sto) {		        	 
		        	  log.info(sto.toString());	
		        	  throw sto;
		   
		        } catch (IOException ioex) {		        	 
		        	  log.info(ioex.toString());	
		        	  throw ioex;
		        }
			    catch (Exception e) {
			    	log.info(e.toString());		 
			    	throw e;
			    } 
		  
		  ResponseEntity<StatusBean> statusEntity = new ResponseEntity<>(statusBean,headers,HttpStatus.CREATED);		         
	      return statusEntity;
	}
	
	// Check Google status
	@GetMapping(path="/google-status", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusBean> getGoogleStatus() throws IOException, MalformedURLException{
		
		URL url = new URL("https://www.google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		StatusBean statusBean = new StatusBean();
		HttpHeaders headers = new HttpHeaders();
		
		  try {	
			  	Instant start = Instant.now();
		        connection.connect();        
				statusBean.setUrl(url.toString());
				statusBean.setStatusCode(connection.getResponseCode());
				statusBean.setDate(connection.getDate());
				
				Instant finish = Instant.now();
				long duration = Duration.between(start, finish).toMillis();
				statusBean.setDuration(duration);

		        } catch (SocketTimeoutException sto) {		        	 
		        	  log.info(sto.toString());	
		        	  throw sto;
		   
		        } catch (IOException ioex) {		        	  
		        	  log.info(ioex.toString());	
		        	  throw ioex;
		        }
			    catch (Exception e) {
			    	log.info(e.toString());		 
			    	throw e;
			    } 
		  
		  ResponseEntity<StatusBean> statusEntity = new ResponseEntity<>(statusBean,headers,HttpStatus.CREATED);		         
	      return statusEntity;
	}
	
	// Check All status
	@GetMapping(path="/all-status", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StatusBean>> getAllStatus() throws Exception {
		
		URL url = new URL("https://www.amazon.com");		
		StatusBean statusBean = new StatusBean();
		HttpHeaders headers = new HttpHeaders();
		List<StatusBean> statusList = new ArrayList<StatusBean>();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		  try {	
			  		Instant start = Instant.now();
		        	connection.connect();        
		        	statusBean.setUrl(url.toString());
		        	statusBean.setStatusCode(connection.getResponseCode());
		        	statusBean.setDate(connection.getDate());
		        	
		        	Instant finish = Instant.now();
					long duration = Duration.between(start, finish).toMillis();
					statusBean.setDuration(duration);
		       
		        } 
			    catch (Exception e) {
			    	log.info(e.toString());		 
			    	throw e;
			    } 		  	
	         
		   //Add Amazon status to the list
	        statusList.add(statusBean);
	        
	        url = new URL("https://www.google.com");
	        statusBean = new StatusBean();
	        
	        try {	
	        		Instant start = Instant.now();
	        		connection = (HttpURLConnection) url.openConnection();
	        		connection.connect();
					statusBean.setUrl(url.toString());
					statusBean.setStatusCode(connection.getResponseCode());
					statusBean.setDate(connection.getDate());
					
					Instant finish = Instant.now();
					long duration = Duration.between(start, finish).toMillis();
					statusBean.setDuration(duration);
		       
		        } 
			    catch (Exception e) {
			    	log.info(e.toString());		 
			    	throw e;
			    }
	        
	        //Add Google status to the list
	        statusList.add(statusBean);
	        
	        ResponseEntity<List<StatusBean>> statusEntity = new ResponseEntity<>(statusList,headers,HttpStatus.CREATED);		         
	        return statusEntity;		  
		}

}
