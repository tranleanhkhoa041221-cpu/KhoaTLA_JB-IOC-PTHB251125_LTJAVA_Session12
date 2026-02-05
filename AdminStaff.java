package BaiTapLession12;

public class AdminStaff extends Staff {
        private double bonus;

    public AdminStaff() {
    }

    public AdminStaff(int id, String name, double baseSalary, double bonus) {
            super(id, name, baseSalary);
            this.bonus = bonus;
        }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
        public double calculateTotalSalary() {
            return this.getBaseSalary() + bonus;


        }

        @Override
        public String toString() {
            return "[Admin] " + super.toString() +
                    " | Bonus: " + bonus +
                    " | Total Salary: " + calculateTotalSalary();
        }
    }


