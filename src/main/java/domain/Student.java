package domain;

import json.*;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private static final int FAIL = 2;
    private ArrayList<Json> jArrList = new ArrayList<>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);

        for (Tuple<String, Integer> exam:exams) {
            JsonPair jCourse = new JsonPair("course", new JsonString(exam.key));
            JsonPair jMark = new JsonPair("mark", new JsonNumber(exam.value));
            JsonPair jPassed = new JsonPair("passed", new JsonBoolean((exam.value > FAIL)));
            jArrList.add(new JsonObject(jCourse, jMark, jPassed));
        }
    }

    @Override
    public JsonObject toJsonObject() {
        JsonArray jArr = new JsonArray(jArrList.toArray(new Json[0]));
        JsonObject jStudent = super.toJsonObject();
        jStudent.add(new JsonPair("exams", jArr));

        return jStudent;
    }
}