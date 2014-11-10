package db.com;

import globle_variable.globle_variable;
import interfaces.entry_interface;
import retrofit.RestAdapter;

public class getentry {
	public static String API_URL = globle_variable.host;
	public static String API_URL2 = "http://172.29.70.221:8081/";

	public static entry_interface getService() {
		return new RestAdapter.Builder().setEndpoint(API_URL).build()
				.create(entry_interface.class);
	}
}
