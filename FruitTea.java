package BaiTapLession12;

public class FruitTea extends Drink{
        public FruitTea(String id, String name, double price) {
            super(id, name, price);
        }

        @Override
        public void prepare() {
            System.out.println(">>> Cách pha: Lắc với đá và trái cây tươi.");
        }
    }


