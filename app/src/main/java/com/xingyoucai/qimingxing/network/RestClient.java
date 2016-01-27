package com.xingyoucai.qimingxing.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class RestClient {

 
	public static final String BASE_URL = "https://api.xingyoucai.com/";

	private static APIService apiService;
	
	public static APIService getApiService() {
		if(apiService==null){
			final OkClient okClient=new OkClient(OkHttp.getOkHttpClient());
			final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			final RestAdapter.Builder builder = new RestAdapter.Builder();
			final GsonConverter gsonCoverter=new GsonConverter(gson);
			
			RequestInterceptor requestInterceptor = new RequestInterceptor() {
				@Override
				public void intercept(RequestFacade request) {
					
					getSuccessToken(gson,request);
					
				}
			};

			
			RestAdapter restAdapter = builder.setClient(okClient).setEndpoint(BASE_URL).setRequestInterceptor(requestInterceptor).setLogLevel(RestAdapter.LogLevel.HEADERS)
					.setConverter(gsonCoverter).build();
			
			apiService = restAdapter.create(APIService.class);
		}
		return apiService;
		
	}
	
	private static void getSuccessToken(Gson gson ,RequestFacade request){

	}
}
