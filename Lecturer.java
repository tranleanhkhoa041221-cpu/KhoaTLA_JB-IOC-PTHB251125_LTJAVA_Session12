package BaiTapLession12;

public class Lecturer extends Staff{
        private int teachingHours;

    public Lecturer() {
    }

    public Lecturer(int id, String name, double baseSalary, int teachingHours) {
            super(id, name, baseSalary);
            this.teachingHours = teachingHours;
        }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    @Override
        public double calculateTotalSalary() {
            return this.getBaseSalary() + teachingHours * 200000;
        }


        @Override
        public String toString() {
            return "[Lecturer] " + super.toString() +
                    " | Teaching Hours: " + teachingHours +
                    " | Total Salary: " + calculateTotalSalary();
        }
    }


