package BaiTapLession12;

import java.util.ArrayList;
import java.util.List;

public class AssetManager {
        private List<Asset> assets = new ArrayList<>();

        public void showValue(Asset a) {
            System.out.println("Giá trị thị trường: " + a.getMarketValue());
        }

        public void addAsset(Asset asset) {
            assets.add(asset);
        }

        public void showAll() {
            if (assets.isEmpty()) {
                System.out.println("Danh sách trống!");
                return;
            }
            for (Asset a : assets) {
                System.out.println(a);
            }
        }

        public Asset searchAsset(String assetCode) {
            for (Asset a : assets) {
                if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                    return a;
                }
            }
            return null;
        }

        public void searchAsset(double price) {
            boolean found = false;
            for (Asset a : assets) {
                if (a.getPurchasePrice() > price) {
                    System.out.println(a);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không có tài sản nào giá lớn hơn " + price);
            }
        }
    }


