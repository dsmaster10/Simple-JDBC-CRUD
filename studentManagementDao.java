package dao;

import dbutil.DBUtil;
import pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//insert,update,delete,view all,search by id

public class studentManagementDao {
  public List<Student> getAllStudents()throws Exception{
      List<Student> studentList=new ArrayList<>();
      Connection conn=DBUtil.getConnection();
      PreparedStatement pst= conn.prepareStatement("Select * from students");
      ResultSet rs=pst.executeQuery();
      while (rs.next()){
          Student student=new Student(rs.getString("stuId"),rs.getString("stuName"),rs.getString("stuSub"),rs.getInt("stuMarks"));
          studentList.add(student);
      }
      DBUtil.closeConnection(conn);
      return studentList;
    }
  public int insertStudents(Student student)throws Exception{
      int status=0;
      Connection conn=DBUtil.getConnection();
      PreparedStatement pst = conn.prepareStatement("insert into students values(?,?,?,?)");
      pst.setString(1,student.getStudID());
      pst.setString(2,student.getStudName());
      pst.setString(3, student.getStudSub());
      pst.setInt(4,student.getStudMarks());

      status=pst.executeUpdate();
      return status;
  }
  public Student getStudentsById(String studId) throws Exception{
      Student student=null;
      Connection conn = DBUtil.getConnection();
      PreparedStatement pst = conn.prepareStatement("select * from students where stuId=?");
      pst.setString(1,studId);
      ResultSet rs=pst.executeQuery();

      while(rs.next()){
          student=new Student(rs.getString("stuId"),rs.getString("stuName"),rs.getString("stuSub"),rs.getInt("stuMarks"));
      }
      DBUtil.closeConnection(conn);
      return student;
  }
  public int deleteStudents(String studId) throws Exception{
      int status=0;
      Connection conn = DBUtil.getConnection();
      PreparedStatement pst = conn.prepareStatement("delete from students where stuId=? ");
      pst.setString(1,studId);
      status = pst.executeUpdate();
      DBUtil.closeConnection(conn);
      return status;
  }
  public int updateStudents(Student student)throws Exception{
      int status =0;
      Connection conn = DBUtil.getConnection();
      PreparedStatement pst = conn.prepareStatement("update students set stuName=?,stuSub=?,stuMarks=? where stuId=?");
      pst.setString(1,student.getStudName());
      pst.setString(2, student.getStudSub());
      pst.setInt(3,student.getStudMarks());
      pst.setString(4,student.getStudID());
      status=pst.executeUpdate();
      return status;
  }

}
