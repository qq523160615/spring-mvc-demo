package com.flinkinfo.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BetweenValidator implements ConstraintValidator<Between,Integer>
{
    int min;

    int max;

    public void initialize(Between between)
    {
        min = between.min();
        max = between.max();
    }

    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext)
    {
        if(integer != null && integer > min && integer < max)
        {
            return true;
        }
        return false;
    }
}
