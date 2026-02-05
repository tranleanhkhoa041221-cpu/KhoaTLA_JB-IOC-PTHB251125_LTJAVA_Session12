package BaiTapLession12;

public class Computer extends Asset {
        private int ram;
        private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice,
                    int ram, String cpu) {
            super(assetCode, name, purchasePrice);
            this.ram = ram;
            this.cpu = cpu;
        }

        @Override
        public double getMarketValue() {
            return this.getPurchasePrice() * 0.8;
        }

        @Override
        public String toString() {
            return "[Computer] " + super.toString() +
                    " | RAM: " + ram +
                    " | CPU: " + cpu +
                    " | Giá trị hiện tại: " + getMarketValue();
        }

}
