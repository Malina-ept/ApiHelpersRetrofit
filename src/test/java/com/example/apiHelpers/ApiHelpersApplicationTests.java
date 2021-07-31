package com.example.apiHelpers;

import com.example.apiHelpers.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
class ApiHelpersApplicationTests {

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
	void retrofitTestDeleteUser() {
		Response<User> response;
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);
		try {
			response = service.deleteUser().execute();
			Assertions.assertEquals(204,response.code());
		} catch (IOException e){
			e.printStackTrace();
		}
	}



}
