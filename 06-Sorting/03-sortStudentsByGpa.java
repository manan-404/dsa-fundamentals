public class sortStudentsByGpa {

    static class Student {
        String name;
        String cmsId;
        double gpa;

        Student(String name, String cmsId, double gpa) {
            this.name = name;
            this.cmsId = cmsId;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", CMS-ID: " + cmsId + ", GPA: " + gpa;
        }
    }

    // Insertion sort, descending by GPA
    static void sortByGpaDescending(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].gpa < key.gpa) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    static void printStudents(Student[] students) {
        for (Student s : students) System.out.println(s);
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Ali", "12345", 3.4),
            new Student("Fatima", "54321", 3.9),
            new Student("Zain", "67890", 2.8),
            new Student("Ayesha", "09876", 3.95),
            new Student("Bilal", "11223", 3.1)
        };

        System.out.println("--- Before Sorting ---");
        printStudents(students);

        sortByGpaDescending(students);

        System.out.println("\n--- After Sorting by GPA (Descending) ---");
        printStudents(students);
    }
}
