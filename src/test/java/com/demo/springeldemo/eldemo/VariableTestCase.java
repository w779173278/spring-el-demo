package com.demo.springeldemo.eldemo;


import com.demo.springeldemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariableTestCase {

    @Test
    public void setTest() {
        ExpressionParser parser = new SpelExpressionParser();
        User user = new User("小明", 12);
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        context.setVariable("newName", "小李");
        parser.parseExpression("name = #newName").getValue(context);
        assertEquals(user.getName(), "小李");
    }

    @Test
    public void getTest() {
        ExpressionParser parser = new SpelExpressionParser();
        User user = new User("小明", 12);
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        context.setVariable("varible", "value");
        Object value = parser.parseExpression("#varible").getValue(context);
        Object name = parser.parseExpression("#root.name").getValue(context);
        Object age = parser.parseExpression("#root.age").getValue(context);
        assertEquals(value, "value");
        assertEquals(name, "小明");
        assertEquals(age, 12);
    }


}
