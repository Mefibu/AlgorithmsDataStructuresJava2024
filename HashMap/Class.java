package HashMap;


public class Class {
    private String classCode;
    private String subjectName;
    private String time;

    // Конструктор
    public Class(String classCode, String subjectName, String time) {
        this.classCode = classCode;
        this.subjectName = subjectName;
        this.time = time;
    }

    // Геттери
    public String getClassCode() {
        return classCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTime() {
        return time;
    }

    // Перевизначення toString для зручного відображення інформації
    @Override
    public String toString() {
        return "Class Code: " + classCode + ", Subject: " + subjectName + ", Time: " + time;
    }
}