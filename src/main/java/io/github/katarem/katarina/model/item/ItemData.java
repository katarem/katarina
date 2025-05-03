package io.github.katarem.katarina.model.item;

import java.util.Map;

import lombok.Data;

@Data
public class ItemData {
    private String version;
    private Map<String, ItemDto> data;
}
