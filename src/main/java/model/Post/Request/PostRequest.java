package model.Post.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest{

	@JsonProperty("name")
	private String name;

	@JsonProperty("salary")
	private String salary;

	@JsonProperty("age")
	private String age;

	public String getName(){
		return name;
	}

	public String getSalary(){
		return salary;
	}

	public String getAge(){
		return age;
	}


	public static class Builder{

		private String nameBuild;

		private String salaryBuild;

		private String ageBuild;

		public Builder withName(String name) {
			this.nameBuild = name;
			return this;
		}

		public Builder withSalary(String salary) {
			this.salaryBuild = salary;
			return this;
		}

		public Builder withAge(String age) {
			this.ageBuild = age;
			return this;
		}

		public Builder postEmployee() {
			this.nameBuild="julio";
			this.salaryBuild="600000";
			this.ageBuild="69";
			return this;
		}

		public Builder postFitccion() {
			this.nameBuild="cesar";
			this.salaryBuild="20000\n" +
					"150000.\n" +
					"500000.\n" +
					"340000\n" +
					"2500000\n" +
					"3500000\n" +
					"3400000000";
			this.ageBuild="2";

			return this;
		}

		public PostRequest build() {
			PostRequest request = new PostRequest();
			request.name = nameBuild;
			request.salary=salaryBuild;
			request.age=ageBuild;

			return request;
		}

	}

}