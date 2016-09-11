package service.mainClass;

import service.jsonParser.JsonParserServiceImp;

public class MainClass {

	public static void main(String[] args) {
		JsonParserServiceImp parser=new JsonParserServiceImp();
		if(!parser.getJsonData(args[0]))
			System.out.println("There's No Information about your entered City Name , please try again");

	}

}
