package com.example.swagger01.controller;

import com.example.swagger01.dto.UserRequest;
import com.example.swagger01.dto.UserResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@Api(tags={"API 정보를 제공하는 컨트롤러입니다"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final UserResponse userResponse;

    @ApiOperation(value="hello를 외치는 메서드")
    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @ApiResponses({
            @ApiResponse(code=200,message = "모든 값이 올바릅니다"),
            @ApiResponse(code=400,message = "입력하신 두 수의 형태 및 값을 확인해주세요"),
            @ApiResponse(code=500,message="관리자에게 문제에 대한 해결을 요청해주세요")
    })
//    @ApiOperation(value="두 수를 더하는 메서드",httpMethod = "GET")
//    @GetMapping("/plus/{x}")
//    public int plus(@ApiParam(value="x값", defaultValue ="20")
//                    @PathVariable int x,
//                    @ApiParam(value="y값",defaultValue = "30")
//                    @RequestParam int y){
//        return x+y;
//    }

    @ApiOperation(value="두 수를 더하는 메서드")
    @ApiImplicitParams({
            @ApiImplicitParam(name="x",value="x값",required = true,paramType = "path",dataType="int"),
            @ApiImplicitParam(name="y",value="y값",required = true,paramType = "query",dataType = "int")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y){
        return x+y;
    }

    @ApiResponse(code=400,message="사용자의 나이가 10살 이하일 때")
    @ApiOperation(value="사용자의 나이와 이름을 echo해주는 메서드")
    @GetMapping("/user")
    public UserResponse user(UserRequest userRequest){
        userResponse.setAge(userRequest.getAge());
        userResponse.setName(userRequest.getName());
        return userResponse;
    }

//post는 쿼리파라미터를 통한 방식보다 body를 타기 때문에
    //ApiImplicitParams나 QueryParams는 어울리지 않음
    @ApiResponses({
            @ApiResponse(code=200,message="요청에 대해서 정상 응답되었습니다"),
            @ApiResponse(code=400,message="요청에 문제가 보고되었습니다. 요청을 확인해주세요"),
            @ApiResponse(code=404,message="요청하신 페이지가 존재하지 않습니다")
    })
    @PostMapping("/postUser")
    public UserResponse myUser(@RequestBody UserRequest userRequest){
        userResponse.setAge(userRequest.getAge());
        userResponse.setName(userRequest.getName());
        return userResponse;
    }

}
