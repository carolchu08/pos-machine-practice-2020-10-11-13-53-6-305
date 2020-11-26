package pos.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosMachine {
    static List<ItemInfo> ITEM_INFOS = ItemDataLoader.loadAllItemInfos();
    public String printReceipt(List<String> barcodes) {
        List<ItemInfo> itemInfoList = getItemInfo(barcodes);
        Map<String, List<Integer>> itemCountAndSubTotal = generateSubtotalOfItem(itemInfoList);
        Integer total = 0;
        String str = "***<store earning no money>Receipt***\n";

        for (Map.Entry<String, List<Integer>> map : itemCountAndSubTotal.entrySet()) {
            total += map.getValue().get(2);
            str += "Name: " + map.getKey() + ", Quantity: " + map.getValue().get(0) + ", Unit price: " + map.getValue().get(1) + " (yuan), Subtotal: " + map.getValue().get(2) + " (yuan)\n";
        }
        str += "----------------------\n";
        str += "Total: " + total + " (yuan)\n";
        str += "**********************";
        return str;
    }
    Map<String, List<Integer>> generateSubtotalOfItem(List<ItemInfo> itemInfoList) {
        Map<String, List<Integer>> result = new HashMap<>();
        Map<String, Integer> countMap = countQuantityOfItems(itemInfoList);
        Map<String, List<Integer>> subTotalMap = calculateSubTotalOfItem(itemInfoList);

        for (Map.Entry<String, Integer> map : countMap.entrySet()) {
            if (!result.containsKey(map.getKey())) {
                List<Integer> temp = new ArrayList<>();
                temp.add(map.getValue());
                temp.add(subTotalMap.get(map.getKey()).get(0));
                temp.add(subTotalMap.get(map.getKey()).get(1));
                result.put(map.getKey(), temp);
            }
        }

        return result;
    }

    public List<ItemInfo> getItemInfo(List<String> barcodes) {
        List<ItemInfo> items = new ArrayList<>();
        for(int i = 0 ; i<barcodes.size();i++) {
            for (int j = 0; j < ITEM_INFOS.size(); j++) {
                if (barcodes.get(i).equals(ITEM_INFOS.get(j).getBarcode())) {
                    items.add(ITEM_INFOS.get(j));
                }
            }
        }
        return items;
    }

    public  Map<String, Integer> countQuantityOfItems( List<ItemInfo> itemInfos){
        Map<String, Integer> result = new HashMap();
        for (ItemInfo info : itemInfos) {
            if (!result.containsKey(info.getName())) {
                result.put(info.getName(), 1);
            }
            else {
                result.put(info.getName(), result.get(info.getName()) + 1);
            }
        }
        return result;
    }

    Map<String, List<Integer>> calculateSubTotalOfItem(List<ItemInfo> itemInfoList) {
        Map<String, List<Integer>> result = new HashMap<>();
        for (ItemInfo info : itemInfoList) {
            if (!result.containsKey(info.getName())) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(info.getPrice());
                temp.add(info.getPrice());
                result.put(info.getName(), temp);
            }
            else {
                List<Integer> temp = result.get(info.getName());
                temp.set(1, temp.get(1) + info.getPrice());
                result.put(info.getName(), temp);
            }
        }
        return result;
    }

}