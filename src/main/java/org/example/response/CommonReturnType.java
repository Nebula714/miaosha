package org.example.response;

public class CommonReturnType {
    private String status;
    private  Object data;

    public static  CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status){
        CommonReturnType type = new CommonReturnType();
        type.status=status;
        type.data=result;
        return type;
    }
}
