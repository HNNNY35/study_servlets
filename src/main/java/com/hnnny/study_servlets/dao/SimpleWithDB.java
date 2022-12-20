package com.hnnny.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleWithDB {
    public ArrayList<HashMap> getList(){
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        Statement statementAnswer = commons.getStatement();

        // 설문과 답항 내용 출력
        String query = "SELECT * FROM questions_list " +
                "ORDER BY ORDERS";

        // 아래 while문 안에 문항+답항 묶음이 들어있음 = bundle(첫번째 문항에 해당하는 답항들, 두번째 문항에 해당하는 답항들...)
        // 이 while문에 들어있는 데이터들을 어떤 데이터 타입에 담아주지? ArrayList
        ArrayList<HashMap> bundle_list = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // 설문 문항에 맞는 설문 답항 콘솔에 출력
                System.out.print(resultSet.getInt("ORDERS") + ". ");
                System.out.println(resultSet.getString("QUESTIONS"));
                String uid = resultSet.getString("QUESTIONS_UID");

            // 1. 문항 부분 : orders,questions,questions_uid => 순서가 있으면 ArrayList, 순서가 없으면 HashMap으로 넣어야 함
            // => 컬럼이름으로 가져왔기 때문에 순서 X => HashMap 
                HashMap<String, Object> question = new HashMap<String, Object>(); 
                // String과 Int 모두 담을 수 있는 것 : 둘의 조상인 Object
                question.put("ORDERS", resultSet.getInt("ORDERS"));
                question.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                question.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));

                
                // 설문자 답 받기
                query = "SELECT example_list.EXAMPLE_UID, example_list.EXAMPLE, example_list.ORDERS " +
                "FROM answers inner Join example_list " +
                " on answers.EXAMPLE_UID = example_list.EXAMPLE_UID " +
                " WHERE QUESTIONS_UID = '" + uid + "' " +
                "ORDER BY ORDERS";
                ResultSet resultSetAnswer = statementAnswer.executeQuery(query);
                // 설문 답항 콘솔에 출력
                ArrayList<HashMap> example_list = new ArrayList<>();
                while (resultSetAnswer.next()) {
                    System.out.print(resultSetAnswer.getInt("ORDERS") + ". ");
                    System.out.println(resultSetAnswer.getString("EXAMPLE"));

            // 2. 답항 부분 : 
                    HashMap<String, Object> answer = new HashMap<>();        
                    answer.put("ORDERS", resultSetAnswer.getInt("ORDERS"));
                    answer.put("EXAMPLE", resultSetAnswer.getString("EXAMPLE"));
                    answer.put("EXAMPLE_UID", resultSetAnswer.getString("EXAMPLE_UID"));

                    example_list.add(answer);
                }
                resultSetAnswer.close();

            // 3. 문항+답항 한 묶음으로 만들기
                HashMap<String, Object> bundle = new HashMap<>();
                bundle.put("question", question);
                bundle.put("answer_list", example_list);

                bundle_list.add(bundle);
            }

            statementAnswer.close();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bundle_list;
    }
}
