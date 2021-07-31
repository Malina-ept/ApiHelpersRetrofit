package com.example.apiHelpers;

import com.example.apiHelpers.pojo.ListUsersResponse;
import com.example.apiHelpers.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
class ApiHelpersApplicationTests {
	Response<User> response;
	//Endpoint service for send request
	APIInterface service = APIClientHelper.getClient().create(APIInterface.class);

	@Test
	void retrofitTestGetUser() {
		Response<User> response;

		//создали клиента для отправки запроса
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);


		//берем клиента и выполняем get запрос
		try {
			response = service.getUser().execute();

			if(response.isSuccessful()) {
				System.out.println("Response Success");
				assert response.body() != null;
				System.out.println(response.body().getData());
			} else 		{
				System.out.println("Response error");
			}

		} catch (IOException e){
			e.printStackTrace();
		}

	}

	@Test
	void retrofitTestGetUserNotFound() {
		Logger log = LogManager.getLogger(ApiHelpersApplicationTests.class);
		Response<User> response;
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);
		try {
			response = service.getUserNotFound().execute();
			Assertions.assertEquals(404,response.code());
		} catch (IOException e){
			e.printStackTrace();
		}

	}
	@Test
	void retrofitTestListUsers() {


	}
}






