package com.wxw.account.config.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/*
 * Jackson 序列化
 * */
public class JsonUtil {

    static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    /*
     * 对象序列化
     * */
    public static String objectToJson(Object object) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(object);

        return jsonString;
    }

    /*
     * 反序列化为对象
     * */
    public static <T> T jsonToObject(String jsonString, Class<T> valueType) throws JsonProcessingException {
        T value = mapper.readValue(jsonString, valueType);

        return value;
    }

    /*
     * 对象转化
     * */
    public static <T> T convertValue(Object object, Class<T> toValueType) {
        T value = mapper.convertValue(object, toValueType);

        return value;
    }

    /**
     * json转list
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> toValueType) throws JsonProcessingException {
        List<T> lists = mapper.readValue(jsonString, mapper.getTypeFactory().constructParametricType(List.class, toValueType));

        return lists;
    }
}
