package App;

import dao.studentManagementDao;
import pojo.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class studentManagementApp {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        studentManagementDao dao=new studentManagementDao();
        String option="";
        do{
            System.out.println("A. View All Student Records");
            System.out.println("B. Add a Student Record");
            System.out.println("C. Update a Student Record");
            System.out.println("D. Delete a Student Record");
            System.out.println("E. Search a Student Record");
            System.out.println("F. Exit Program");
            System.out.println("---------------------------");
            System.out.print("Enter an option: ");
            option=br.readLine();

            switch (option.toUpperCase()){
                case "A":
                    viewStudents(dao);
                    break;
                case "B":
                    addStudent(dao);
                    break;
                case "C":
                    updateStudent(dao);
                    break;
                case "D":
                    deleteStudent(dao);
                    break;
                case "E":
                    searchStudent(dao);
                    break;
                case "F":
                    System.out.println("________**Thanks for using **__________");
                    System.exit(0);
                    break;
                default:
                    System.out.println("*----------Invalid option-------* Select a valid option");
                    break;
            }

        }
        while(!option.equals("F"));
    }
    public static void displayStudent(Student student){
        System.out.println("Student ID: "+student.getStudID());
        System.out.println("Student Name: "+student.getStudName());
        System.out.println("Student Subject: "+student.getStudSub());
        System.out.println("Student Marks: "+student.getStudMarks());
        System.out.println("-------------------------");

    }
    public static void viewStudents(studentManagementDao dao)throws Exception{
        List<Student> stuList=dao.getAllStudents();
        for(Student stu:stuList) {
            displayStudent(stu);
        }
        System.out.println("-------------------------");
    }
    public static void addStudent(studentManagementDao dao)throws Exception{
        System.out.print("Enter student id: ");
        String ID=br.readLine();
        System.out.print("Enter student name: ");
        String Name=br.readLine();
        System.out.print("Enter student subject: ");
        String Sub=br.readLine();
        System.out.print("Enter student marks: ");
        int marks=Integer.parseInt(br.readLine());

        Student student=new Student(ID,Name,Sub,marks);
        int status=dao.insertStudents(student);
        if(status==1){
            System.out.println("Inserted");
            System.out.println("-------------------------");
        }
        else{
            System.out.println("Failed");
            System.out.println("-------------------------");
        }
    }
    public static void updateStudent(studentManagementDao dao)throws Exception{
        System.out.print("Enter student id: ");
        String id= br.readLine();
        System.out.print("Enter student name: ");
        String name= br.readLine();
        System.out.print("Enter student subject: ");
        String sub= br.readLine();
        System.out.print("Enter student marks: ");
        int marks=Integer.parseInt(br.readLine());
        Student student=new Student(id,name,sub,marks);
        int status=dao.updateStudents(student);
        if(status==0){
            System.out.println("Failed");
            System.out.println("-------------------------");
        }
        else{
            System.out.println("Successfully updated");
            System.out.println("-------------------------");
        }
    }
    public static void deleteStudent(studentManagementDao dao)throws Exception{
        System.out.print("Enter Student ID: ");
        String id=br.readLine();
        int status=dao.deleteStudents(id);
        if(status==1){
            System.out.println("Deletion successful");
            System.out.println("-------------------------");
        }else{
            System.out.println("Failed to delete");
            System.out.println("-------------------------");
        }
    }
    public static void searchStudent(studentManagementDao dao)throws Exception{
        System.out.print("Enter student id: ");
        String id=br.readLine();
        Student student=dao.getStudentsById(id);
        displayStudent(student);
    }
}
