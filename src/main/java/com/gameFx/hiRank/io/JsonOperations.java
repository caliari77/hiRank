package com.gameFx.hiRank.io;

import java.util.List;

public interface JsonOperations {

    /**
     * Read Json file and load It as Pojo object list.
     *
     * @param fileName Json file name.
     * @param clazz    Pojo class type.
     * @param <T>      Generic class type.
     * @return List of Pojo of type T.
     */
    <T> List<T> readJsonToPojoList(String fileName, Class<T> clazz);

    /**
     * Write Json file from load It as Pojo object list.
     *
     * @param fileName Json file name.
     * @param gameList List of games to be parsed.
     */
    void writePojoToJson(String fileName, List gameList);

}
