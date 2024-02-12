package org.example.service;

import org.example.error.BussinessException;
import org.example.service.model.ItemModel;

import java.util.List;

public interface ItemService {
    ItemModel createItem(ItemModel itemModel) throws BussinessException;

    List<ItemModel> listItem();

    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId, Integer amount) throws BussinessException;

    //商品销量增加
    void increaseSales(Integer itemId, Integer amount) throws BussinessException;
}
