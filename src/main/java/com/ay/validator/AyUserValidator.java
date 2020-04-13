package com.ay.validator;

import com.ay.model.AyUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author xiangwehao
 * create 2020/4/2
 */
@Component
public class AyUserValidator implements Validator {
    public boolean supports(Class clazz){
        return AyUser.class.equals(clazz);
    }
    public void validate(Object object, Errors e){
        ValidationUtils.rejectIfEmpty(e,"name","name.empty");
        AyUser ayUser=(AyUser)object;
        if(ayUser.getAge() < 0)
            e.rejectValue("age","年龄不能太小");
        else  if(ayUser.getAge() > 150)
            e.rejectValue("age","年龄不能太大");
    }
}
