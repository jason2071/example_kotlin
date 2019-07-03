package com.example.demokotlin.data;

import com.example.demokotlin.model.Task;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class DataSource {

    public static List<Serializable> createData() {
        List<Serializable> list = new ArrayList<>();
        list.add("A");
        list.add(1);
        list.add(100);
        list.add("z");
        list.add((byte) 0xA);
        return list;
    }

    public static List<Task> createTaskList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Take out the trash", true, 3));
        tasks.add(new Task("Walk the dog", false, 2));
        tasks.add(new Task("Make my bed", true, 1));
        tasks.add(new Task("Unload the dishwasher", false, 0));
        tasks.add(new Task("Make dinner", true, 5));
        return tasks;
    }
}
