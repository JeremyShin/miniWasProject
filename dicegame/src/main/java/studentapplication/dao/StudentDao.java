package studentapplication.dao;

import studentapplication.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;



    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();

        try{

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {

        }

        return list;
    }

}
