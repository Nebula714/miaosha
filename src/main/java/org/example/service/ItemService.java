package org.example.service;

import org.example.error.BussinessException;
import org.example.service.model.ItemModel;

import java.util.List;

public interface ItemService {
    ItemModel createItem(ItemModel itemModel) throws BussinessException;

    List<ItemModel> listItem();

    ItemModel getItemById(Integer id);
}
