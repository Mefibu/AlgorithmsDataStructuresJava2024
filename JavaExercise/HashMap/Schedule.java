package JavaExercise.HashMap;

import java.util.HashMap;

public class Schedule {
    private HashMap<String, Class> schedule;

    public Schedule() {
        this.schedule = new HashMap<>();
    }

    
    public void addClass(Class newClass) {
        schedule.put(newClass.getClassCode(), newClass);
    }

    
    public void removeClass(String classCode) {
        schedule.remove(classCode);
    }

   
    public Class findClass(String classCode) {
        return schedule.get(classCode);
    }

    
    public void printAllClasses() {
        if (schedule.isEmpty()) {
            System.out.println("No classes scheduled.");
        } else {
            for (Class cls : schedule.values()) {
                System.out.println(cls);
            }
        }
    }
}