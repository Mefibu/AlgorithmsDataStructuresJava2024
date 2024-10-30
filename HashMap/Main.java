package HashMap;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        
        Class class1 = new Class("AM001", "Applied Math", "09:10");
        Class class2 = new Class("MA002", "Mathematics", "11:50");
        Class class3 = new Class("PH003", "Physics", "12:40");
        Class class4 = new Class("LSS004", "Life Satety and Security", "08:00");

        schedule.addClass(class1);
        schedule.addClass(class2);
        schedule.addClass(class3);
        schedule.addClass(class4);
        
        System.out.println("All scheduled classes:");
        schedule.printAllClasses();

        // Search
        System.out.println("\nFinding class with code MA002:");
        Class foundClass = schedule.findClass("MA002");
        if (foundClass != null) {
            System.out.println(foundClass);
        } else {
            System.out.println("Class not found.");
        }

        
        System.out.println("\nRemoving class with code AM001.");
        schedule.removeClass("AM001");

       
        System.out.println("\nAll scheduled classes after removal:");
        schedule.printAllClasses();
    }
}