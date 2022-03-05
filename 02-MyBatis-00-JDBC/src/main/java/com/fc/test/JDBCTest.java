package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    @Test
    public void testSelect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/student02?useSSL=false&characterEncoding=UTF8";
            String username = "root";
            String password = "15239440831";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "select * from student";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setGender(resultSet.getString(4));
                student.setBirthday(resultSet.getDate(5));
                student.setInfo(resultSet.getString(6));

                students.add(student);
            }

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
