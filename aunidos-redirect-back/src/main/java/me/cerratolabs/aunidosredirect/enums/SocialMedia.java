package me.cerratolabs.aunidosredirect.enums;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public enum SocialMedia {
    WHATSAPP(1, "whatsapp"),
    TWITTER(2, "twitter"),
    FACEBOOK(3, " facebook  "),
    INSTAGRAM(4, " instagram "),
    WEB(5, " web");

    private Integer id;
    private String name;
    private Map<Integer, SocialMedia> MAP_CACHE_ID;
    private Map<String, SocialMedia> MAP_CACHE_NAME;

    {
        MAP_CACHE_ID = new HashMap<>();
        MAP_CACHE_NAME = new HashMap<>();
        for (SocialMedia social : SocialMedia.values()) {
            MAP_CACHE_ID.put(social.id, social);
            MAP_CACHE_NAME.put(social.name, social);
        }


    }

    SocialMedia(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SocialMedia getEnumById(Integer id) {
        return MAP_CACHE_ID.get(id);
    }

    public SocialMedia getEnumByName(String name) {
        return MAP_CACHE_NAME.get(name);
    }
}