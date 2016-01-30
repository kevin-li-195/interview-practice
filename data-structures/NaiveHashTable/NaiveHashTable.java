public class NaiveHashTable {
    private static final int SIZE = 1;
    private static Student[] students = new Student[SIZE];

    static class Student {
        int id;
        String name;
        Student next;

        public Student(int a, String b) {
            id = a;
            name = b;
            next = null;
        }

        public Student(int a, String b, Student l) {
            id = a;
            name = b;
            next = l;
        }

        public static Student getStudent(int key, Student s) {
            System.out.println("Starting getStudent");
            do { System.out.println("Looking for student in linkedlist...");
                 if (s.id == key) {
                     return(s);
                 } else {
                     System.out.println("Looking for " + key + ", but found " + s.id + ". Keep looking in LinkedList.");
                     s = s.next;
                 }
            } while (s.next != null);
            return(null);
        }
    }

    private static int getHash(int sid) {
        return(sid % SIZE);
    }

    private void put(int studentID, String studentName) {
        int index = getHash(studentID);
        Student s = students[index];
        Student newS;
        if (s == null) {
            newS = new Student(studentID, studentName);
        } else {
            newS = new Student(studentID, studentName, students[index]);
        }
        students[index] = newS;
    }

    private Student get(int key) {
        int i = getHash(key);
        System.out.println("The bucket is " + i);
        return(Student.getStudent(key, students[i]));
    }

    public static void main(String[] args) {
        NaiveHashTable t = new NaiveHashTable();
        t.put(1, "Kevin");
        t.put(212, "Foxtrot");
        t.put(3141, "Charlie");
        t.put(34252, "Chingchong");
        t.put(41, "Pingu");
        t.put(42, "Maestro");
        t.put(91, "Tango");
        t.put(72, "Whiskey");
        Student a = t.get(34252);
        if (a == null) {
            System.out.println("Student ID not found.");
        } else {
            System.out.println("Found " + a.name);
        }
    }
}
