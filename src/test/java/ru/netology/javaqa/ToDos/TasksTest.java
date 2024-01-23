package ru.netology.javaqa.ToDos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TasksTest {

    Task simple1 = new SimpleTask(1,"IT");
    Task simple2 = new SimpleTask(2, "English");

    Task simple3 = new SimpleTask(3,"Fitness");

    String[] subtasks1 = {"Cuddle", "Coffee", "Calendar"};
    String[] subtasks2 = {"Flat", "YandexPlus", "iTunes"};
    String[] subtasks3 = {"Arctic Monkeys", "Hotel", "Tickets"};

    Task epic1 = new Epic(4, subtasks1);
    Task epic2 = new Epic(5, subtasks2);
    Task epic3 = new Epic(6, subtasks3);

    Task meet1 = new Meeting(7, "Work on holidays",
            "Obstetrics", "twenty nine of December, ten a.m.");
    Task meet2 = new Meeting(8, "Concert",
            "Bruno Mars", "first of October, seven p.m." );

    Todos todos = new Todos();

   @BeforeEach
    public void setUp(){
        todos.add(simple1);
        todos.add(simple2);
        todos.add(simple3);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(meet1);
        todos.add(meet2);
    }

    @Test
    public void shouldMatchesSimpleTask(){
       String query = "English";

       boolean expected = true;
       boolean actual = simple2.matches(query);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldDontMatchesSimpleTask() {
        String query = "Погулять с собакой";

        boolean expected = false;
        boolean actual = simple3.matches(query);

        Assertions.assertEquals(expected, actual);
    }


   @Test
    public void shouldMatchesEpic(){
        String query = "Coffee";
        boolean expected = true;
        boolean actual = epic1.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDontMatchesEpic(){
        String query = "MTS";
        boolean expected = false;
        boolean actual = epic2.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingProject(){
        String query = "Bruno";

        boolean expected = true;
        boolean actual = meet2.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingTopic(){
        String query = "Work";

        boolean expected = true;
        boolean actual = meet1.matches(query);
    }

    @Test
    public void shouldDontMatchesMeeting() {
        String query = "Aviasales";

        boolean expected = false;
        boolean actual = meet1.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    }
