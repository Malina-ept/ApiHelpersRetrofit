package com.example.apiHelpers;

import com.example.apiHelpers.pojo.CreateUserRequest;
import com.example.apiHelpers.pojo.CreateUserResponse;
import com.example.apiHelpers.pojo.User;
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
	void retrofitTestCreateUsers() throws IOException {
		Response<CreateUserResponse> response;
		APIInterface service = APIClientHelper.getClient().create(APIInterface.class);

		String expectedName = "morpheus";
		String expectedJob = "leader";

		CreateUserRequest createUserRequest = CreateUserRequest.builder()
				.name(expectedName)
				.job(expectedJob)
				.build();

		response = service.createUser(createUserRequest).execute();

		Assertions.assertTrue(response.isSuccessful());
		Assertions.assertEquals(200,response.code());
		Assertions.assertEquals(expectedName, response.body().getName());
		Assertions.assertEquals(expectedJob, response.body().getJob());

		System.out.println(response.body());
	}

	@Test
	void retrofitTestDeleteUser() throws IOException {
		response = service.deleteUser().execute();
		Assertions.assertEquals(204,response.code());
		System.out.println(response.body());

		}

	}









