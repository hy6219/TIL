import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        //ObjectMapper에 사용될 객체
        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("세단");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("11가 1112");
        car2.setType("SUV");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        user.setCars(cars);

        String json = objectMapper.writeValueAsString(user);
        System.out.println("java Object to text json: "+json);

        User object = objectMapper.readValue(json,User.class);
        System.out.println("text json to java object: "+object);

        //json 노드 접근하기
        JsonNode jsonNode= objectMapper.readTree(json);
        //name 값
        String name = jsonNode.get("name").asText();

        //age값
        int age = jsonNode.get("age").asInt();
        //cars
     //   List<JsonNode> myCar = objectMapper.convertValue(jsonNode.get("cars"),ArrayList.class);
        JsonNode carsJ = jsonNode.get("cars");
        ArrayNode arrayNode=((ArrayNode) carsJ);
        List<Car> myCar = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });

        System.out.println("json node- name: "+name+", age: "+age+", cars: "+myCar);

        //JsonNode cast to ObjectNode
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name","steve");
        objectNode.put("age",20);
        System.out.println("값 변경 using ObjectNode: "+objectNode);
        System.out.println("값 변경 using JsonNode: "+jsonNode);

        System.out.println("값 변경 using ObjectNode-prettier: "+objectNode.toPrettyString());

    }
}
