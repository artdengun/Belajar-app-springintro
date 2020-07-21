package com.deni.gunawan.appspringintro;


import com.deni.gunawan.appspringintro.Entity.Todo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class Hello {

    RestTemplate restTemplate = new RestTemplate();


    // cross objek membuat API
    @GetMapping("/todo/get")
    public  String getTodo(){
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
        return result;
    }

    @GetMapping("/todo/post")
    public ResponseEntity<String> postCode(){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long)1000);
        newTodo.setTitle("deni gunawan");
        newTodo.setUserId((long) 10);
        newTodo.setCompleted(false);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, header);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST, entity, String.class);
    }

    @GetMapping("/todo/delete")
    public  String deleteTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long)1);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + newTodo.getId(), HttpMethod.DELETE, entity, String.class).getBody();
    }


    @GetMapping("/todo/put/{id}")
    public  String updateTOdo(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo updateTodo = new Todo();
        updateTodo.setTitle("john wick");
        updateTodo.setCompleted(true);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(updateTodo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }








//
//        // tahap 2
//    @GetMapping("/hello") // ini untuk membuat url
//    public  String Hello(){
//        return  "Hello deni"; // mengembalikan nilai String dari class hello
//    }
//
//    // tahap 3
//    @GetMapping("/hello/{name}") // uri input data dari luar
//    public  String HelloWorldName(@PathVariable(value = "name") String name ) {
//        return "Hello " + name;
//        // @PathVariable -> digunakan untuk input dari luar
//    }
//
//    // tahap 3
//    @PostMapping("/hello/post") // request param menerima paramter dari body
//    public  String HelloWorldPostController(@RequestParam(name = "Username") String username) {
//        return  " Hallo " + username;
//    }
//
//    // tahap 4
//    @PostMapping("/hello/requestbody")
//    public Username TestPostBody(@Valid @RequestBody Username username){
//            return username;
//    }

}
