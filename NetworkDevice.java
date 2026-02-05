package BaiTapLession12;

public class NetworkDevice extends Asset{
        private int numberOfPorts;

    public NetworkDevice() {
    }

    public NetworkDevice(String assetCode, String name, double purchasePrice,
                         int numberOfPorts) {
            super(assetCode, name, purchasePrice);
            this.numberOfPorts = numberOfPorts;
        }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    @Override
        public double getMarketValue() {
            return this.getPurchasePrice() * 0.9;
        }

        @Override
        public String toString() {
            return "[NetworkDevice] " + super.toString() +
                    " | Số cổng: " + numberOfPorts +
                    " | Giá trị hiện tại: " + getMarketValue();
        }
    }


