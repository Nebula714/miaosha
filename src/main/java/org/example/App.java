package org.example;

import org.example.dao.UserDoMapper;
import org.example.dataobject.UserDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"org.example"})
@RestController
@MapperScan("org.example.dao")
public class App
{
    @Autowired
    private UserDoMapper userDoMapper;


    @RequestMapping("/")
    public String home(){
        UserDo userDo=userDoMapper.selectByPrimaryKey(1);
        if(userDo==null){
            return "no exist";
        }
        else {
            return userDo.getName();
        }
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
