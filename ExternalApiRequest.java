private void DCEmployeeChangeAPI(String payload) throws IOException {
        	HttpResponse<String> response=null;
            String apiURL = "https://dc01.rmdatacentral.com/portal1246/api/HRManagement/Employees";
            
            HttpRequest request=HttpRequest.newBuilder()
            		.uri(URI.create(apiURL))
            		.header("Content-Type", "application/json")
            		.header("DCKey", "v3vmQzC5BJKXZq8WQ_Kk6vj7jQ7iCA9NlS5uuxFXwWEwfBLwP1z-k3_87bGZuGKrDw0")
            		.method("PATCH", HttpRequest.BodyPublishers.ofString(payload))
            		.build();

          try {
			response=HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println(response.body());
        }


		private String GeneratePayload(EmployeeChangesData employee, String change) {
			
			 return "[{\n" +
		            "   \"StoreEmployeeID\": \"" + employee.getStoreEmployeeID() + "\",\n" +
		            "   \"" + change + "\": \"" + employee.getNew_value() + "\"\n" +
		            "}]";
			
		}
