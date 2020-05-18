package com.lamda;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public enum SingletonEnum {
    INSTANCE;
    public static Supplier<SingletonEnum> getInstance() {
        return () -> SingletonEnum.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.getInstance().get();

        Person son = Person.builder().age(1).name("son").build();
        System.out.println(son);


        //Supplier<Person> getPerson = Person::new;
        //Person a = getPerson.get();
        BiConsumer<Person, String> changePersonName = (x, y) -> x.setName(y);
        changePersonName.accept(son, "nihao");
        System.out.println(son);
    }
}

@Data
@Builder
//@NoArgsConstructor
class Person {
    String name;
    int age;
}
