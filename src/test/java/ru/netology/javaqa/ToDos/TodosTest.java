package ru.netology.javaqa.ToDos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TodosTest {
    @Test

    public void shouldAddThreeTasksOfDifferentType() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    Task simple1 = new SimpleTask(1, "IT");
    Task simple2 = new SimpleTask(2, "English");

    Task simple3 = new SimpleTask(3, "Fitness");

    String[] subtasks1 = {"Cuddle", "Coffee", "Calendar"};
    String[] subtasks2 = {"Flat", "YandexPlus", "iTunes"};
    String[] subtasks3 = {"Arctic Monkeys", "Hotel", "Tickets"};

    Task epic1 = new Epic(4, subtasks1);
    Task epic2 = new Epic(5, subtasks2);
    Task epic3 = new Epic(6, subtasks3);

    Task meet1 = new Meeting(7, "Work on holidays",
            "Obstetrics", "twenty nine of December, ten a.m.");
    Task meet2 = new Meeting(8, "Concert",
            "Bruno Mars", "first of October, seven p.m.");

    
    @Test
    public void shouldSearchIfQueryMatches() {
        Todos todos = new Todos();
        todos.add(simple1);
        todos.add(simple2);
        todos.add(simple3);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(meet1);
        todos.add(meet2);

        String query = "F";

        Task[] expected = {simple3, epic2};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDontSearchIfQueryDontMatches(){
        Todos todos = new Todos();
        todos.add(simple1);
        todos.add(simple2);
        todos.add(simple3);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(meet1);
        todos.add(meet2);

        String query = "Museum";

        Task[] expected = new Task[0];
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);

    }
}

