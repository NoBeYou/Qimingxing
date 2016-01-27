package com.xingyoucai.qimingxing.network;

import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.OkHttpClient;

public class OkHttp {

	private static OkHttpClient client;
	private static final long CONNECT_TIMEOUT_MILLIS = 10*1000;
	private static final long READ_TIMEOUT_MILLIS = 10*1000;

	public static OkHttpClient getOkHttpClient() {
			synchronized (OkHttp.class) {
				if (client == null) {

					client = new OkHttpClient();
					client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
					client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
				}
			}
		return client;
	}
	// public static OkHttpClient getOkHttpClient() {
	// if (client == null) {
	// client=new OkHttpClient();
	// client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.SECONDS);
	// client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS);
	// client.interceptors().add(new Interceptor() {
	// @Override
	// public Response intercept(Chain chain) throws IOException {
	// Request request = chain.request();
	//
	// // try the request
	// Response response = chain.proceed(request);
	//
	// int tryCount = 0;
	// while (!response.isSuccessful() && tryCount < 3) {
	//
	// Log.d("intercept", "Request is not successful - " + tryCount);
	//
	// tryCount++;
	//
	// // retry the request
	// response = chain.proceed(request);
	// }
	//
	// // otherwise just pass the original response on
	// return response;
	// }
	// });
	// }
	// return client;
	// }

}
