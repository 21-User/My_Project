package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.dao.EmployeeDao;
import com.fc.dao.StudentDao;
import com.fc.dao.SubjectDao;
import com.fc.entity.Department;
import com.fc.entity.Employee;
import com.fc.entity.Student;
import com.fc.entity.Subject;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTableTest {
    @Test
    public void testFindAllSubject() {
        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);

        List<Subject> subjects = subjectDao.findAll();

        for (Subject subject : subjects) {
            System.out.println(subject);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindAllStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFIndAllDepartment() {
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        List<Department> departments = departmentDao.findAll();

        for (Department department : departments) {
            System.out.println(department);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindAllEmployee() {
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);

        List<Employee> employees = employeeDao.findAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        MyBatisUtil.commit();
    }
}
