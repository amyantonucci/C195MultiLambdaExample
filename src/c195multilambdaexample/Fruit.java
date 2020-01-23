/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c195multilambdaexample;

import java.time.LocalDateTime;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author amy.antonucci
 */
public class Fruit {
    ObservableValue<String> name;
    ObservableValue<String> color;
    ObservableValue<Integer> age;
    ObservableValue<LocalDateTime> date;

    public Fruit(ObservableValue<String> name, ObservableValue<String> color,ObservableValue<Integer> age, ObservableValue<LocalDateTime> date) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.date = date;
    }

    public ObservableValue<String> getName() {
        return name;
    }

    public void setName(ObservableValue<String> name) {
        this.name = name;
    }

    public ObservableValue<String> getColor() {
        return color;
    }

    public void setColor(ObservableValue<String> color) {
        this.color = color;
    }

    public ObservableValue<LocalDateTime> getDate() {
        return date;
    }

    public void setDate(ObservableValue<LocalDateTime> date) {
        this.date = date;
    }

    public ObservableValue<Integer> getAge() {
        return age;
    }

    public void setAge(ObservableValue<Integer> age) {
        this.age = age;
    }

    
    
}
