package com.thetestingacademy.ex_07_Payload_management.Map;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class APITesting029_ComplexJSONTPMAP {
    //{
    //  "fruits": [
    //    {
    //      "name": "Apple",
    //      "color": "#FF0000",
    //      "details": {
    //        "type": "Pome",
    //        "season": "Fall"
    //      },
    //      "nutrients": {
    //        "calories": 52,
    //        "fiber": "2.4g",
    //        "vitaminC": "4.6mg"
    //      }
    //    },
    //  ]
    //}

    //
    public static void main(String[] args) {

        Map<String, Object> payload = new LinkedHashMap();
        List<LinkedHashMap<String, Object>> fruits = new ArrayList<>();

        LinkedHashMap<String, Object> apple = new LinkedHashMap<>();
        apple.put("name", "Apple");
        apple.put("color", "#FF0000");

        LinkedHashMap<String, Object> appleDetails = new LinkedHashMap<>();
        appleDetails.put("type", "Pome");
        appleDetails.put("season", "Fall");
        apple.put("details", appleDetails);


        LinkedHashMap<String, Object> appleNutrients = new LinkedHashMap<>();
        appleNutrients.put("calories", 52);
        appleNutrients.put("fiber", "2.4g");
        appleNutrients.put("vitaminC", "4.6mg");
        apple.put("nutrients", appleNutrients);

        fruits.add(apple);


        payload.put("fruits",fruits);
        System.out.println(payload);



    }

}
